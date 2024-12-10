package index.php.demo.com.tutorialsninja.pages;

import index.php.demo.com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MyAccountsPage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement myAccountPageTitle;


   // By myAccountPageTitle = By.xpath("//h2[normalize-space()='My Account']");

    public String getMyAccountPageTitle(){
        return getTextFromElement((WebElement) myAccountPageTitle);
    }
}
