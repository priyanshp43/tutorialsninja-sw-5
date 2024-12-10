package index.php.demo.com.tutorialsninja.pages;

import index.php.demo.com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopMenuPage extends Utility {

    // Constructor to initialize WebDriver
    public TopMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to select a menu
    public void selectMenu(String menu) {
        By menuLocator = By.linkText(menu);
        clickOnElement(By.linkText(menu));
    }
}
