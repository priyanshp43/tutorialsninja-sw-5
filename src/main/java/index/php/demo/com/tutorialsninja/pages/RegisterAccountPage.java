package index.php.demo.com.tutorialsninja.pages;

import index.php.demo.com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterAccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement pageTitle;

//    By pageTitle = By.xpath("//h1[contains(text(),'Register Account')]");

    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstName;

//    By firstName = By.id("input-firstname");

    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastName;

//    By lastName = By.id("input-lastname");

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement email;

//    By email = By.id("input-email");

    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement phoneNumber;

//    By phoneNumber = By.id("input-telephone");

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;
//    By password = By.id("input-password");

    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement confirmPassword;

//    By confirmPassword = By.id("input-confirm");

    @CacheLookup
    @FindBy(xpath = "//fieldset[3]//input")
    WebElement subscribeButton;
//    By subscribeButton = By.xpath("//fieldset[3]//input");

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyPolicy;

//    By privacyPolicy = By.xpath("//div[@class = 'buttons']//input[@name='agree']");

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement continueButton;

//    By continueButton = By.xpath("//div[@class = 'buttons']//input[@value='Continue']");

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement confirmationMessage;

//    By confirmationMessage = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueConfirmation;

//    By continueConfirmation = By.xpath("//a[contains(text(),'Continue')]");

    public String getRegisterAccountTitle() {
        return getTextFromElement((WebElement) pageTitle);
    }

    public void enterFirstName(String fstName) {
        sendTextToElement(firstName, fstName);
    }

    public void enterLastName(String lstName) {
        sendTextToElement(lastName, lstName);
    }

    public void enterEmail(String mail) {
        sendTextToElement(email, mail);
    }

    public void enterPhoneNumber(String number) {
        sendTextToElement(phoneNumber, number);
    }

    public void enterPassword(String pwd) {
        sendTextToElement(password, pwd);
    }

    public void enterConfirmPassword(String cnfrmPwd) {
        sendTextToElement(confirmPassword, cnfrmPwd);
    }

    public void selectSubscribe(String option) {
        selectByContainsTextFromDropDown((By) subscribeButton, option);
    }

    public void clickOnPrivacyPolicyCheckBox() {
        clickOnElement(privacyPolicy);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }

    public String getAccountRegistrationConformationMessage() {
        return getTextFromElement((WebElement) confirmationMessage);
    }

    public void clickOnContinueWithConfirmation() {
        clickOnElement(continueConfirmation);
    }
}
