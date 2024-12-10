package index.php.demo.com.tutorialsninja.pages;

import index.php.demo.com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {



    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement loginPageTitle;

    @CacheLookup
    @FindBy(xpath = "input-email")
    WebElement email ;

    @CacheLookup
    @FindBy(xpath = "input-password")
    WebElement  password;

    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement  btnLogin;



//    By loginPageTitle = By.xpath("//h2[contains(text(),'Returning Customer')]");
//    By email = By.id("input-email");
//    By password = By.id("input-password");
//    By btnLogin = By.xpath("//form[contains(@action,'login')]//input[@type='submit']");


    public String getLoginPageTitle(){
        return getTextFromElement(loginPageTitle);
    }
    public void enterEmail(String mail) {
        sendTextToElement(email, mail);
    }
    public void enterPassword(String pass) {
        sendTextToElement(password, pass);
    }
    public void clickOnLogInButton() {
        clickOnElement(btnLogin);
    }
}
