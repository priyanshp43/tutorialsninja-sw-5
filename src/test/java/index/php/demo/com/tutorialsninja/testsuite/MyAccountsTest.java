package index.php.demo.com.tutorialsninja.testsuite;

import index.php.demo.com.tutorialsninja.pages.HomePage;
import index.php.demo.com.tutorialsninja.pages.LoginPage;
import index.php.demo.com.tutorialsninja.pages.MyAccountsPage;
import index.php.demo.com.tutorialsninja.pages.RegisterAccountPage;
import index.php.demo.com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class MyAccountsTest extends BaseTest {

    HomePage homePage ;
    RegisterAccountPage register ;
    LoginPage loginPage ;
    MyAccountsPage myAccountPage ;

    @BeforeMethod
    public void inIt(){
        HomePage homePage = new HomePage();
        RegisterAccountPage register = new RegisterAccountPage();
        LoginPage loginPage = new LoginPage();
        MyAccountsPage myAccountPage = new MyAccountsPage();
    }


    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = homePage.getListOfMyAccountOption();
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = homePage.getListOfMyAccountOption();
        }
    }


    @Test(groups = {"smoke"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        homePage.clickOnMyAccount();
        selectMyAccountOptions("Register");
        Assert.assertEquals(register.getRegisterAccountTitle(), "Register Account",
                "Register page not displayed");
    }

    @Test(groups = {"regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        homePage.clickOnMyAccount();
        selectMyAccountOptions("Login");
        Assert.assertEquals(loginPage.getLoginPageTitle(), "Returning Customer",
                "Login page not displayed");
    }

    @Test(groups = {"sanity"})
    public void verifyThatUserRegisterAccountSuccessfully(){
        homePage.clickOnMyAccount();
        selectMyAccountOptions("Register");
        register.enterFirstName("Urvi" + getAlphaNumericString(4));
        register.enterLastName("P" + getAlphaNumericString(4));
        register.enterEmail("urvi" + getAlphaNumericString(4) + "@gmail.com");
        register.enterPhoneNumber("07784653788");
        register.enterPassword("0123456");
        register.enterConfirmPassword("0123456");
        register.selectSubscribe("Yes");
        register.clickOnPrivacyPolicyCheckBox();
        register.clickOnContinueButton();
        Assert.assertEquals(register.getAccountRegistrationConformationMessage(),
                "Your Account Has Been Created!", "Your Account Not Created!");
        register.clickOnContinueWithConfirmation();
        homePage.clickOnMyAccount();
        selectMyAccountOptions("Logout");
        Assert.assertEquals(homePage.getConfirmationMessageOfLogout(),
                "Account Logout", "Not logged out");
        homePage.clickOnContinueButton();
    }



    @Test(groups = {"regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        homePage.clickOnMyAccount();
        selectMyAccountOptions("Login");
        loginPage.enterEmail("prime1233@gmail.com");
        loginPage.enterPassword("test1234");
        loginPage.clickOnLogInButton();
        Assert.assertEquals(myAccountPage.getMyAccountPageTitle(), "My Account",
                "My Account Is not Matched!");
        homePage.clickOnMyAccount();
        selectMyAccountOptions("Logout");
        Assert.assertEquals(homePage.getConfirmationMessageOfLogout(),
                "Account Logout", "Not logged out");
        homePage.clickOnContinueButton();
    }
}
