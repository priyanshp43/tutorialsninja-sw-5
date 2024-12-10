package index.php.demo.com.tutorialsninja.pages;

import index.php.demo.com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ComponentsPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Components')]")
    WebElement components;

    // By components = By.xpath("//h2[contains(text(),'Components')]");

    public String getPageTitleOfComponents() {
        return getTextFromElement(components);
    }
}
