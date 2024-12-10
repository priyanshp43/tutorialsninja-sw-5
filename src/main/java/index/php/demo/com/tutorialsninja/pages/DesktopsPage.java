package index.php.demo.com.tutorialsninja.pages;

import index.php.demo.com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DesktopsPage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Desktops']")
    WebElement desktopTitle;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    By listOfProduct;

    @CacheLookup
    @FindBy(xpath = "input-sort")
    By productSorting;

    //    By desktopTitle = By.xpath("//h2[normalize-space()='Desktops']");
//    By listOfProduct = By.xpath("//h4/a");
//    By productSorting = By.id("input-sort");

    public String getDesktopPageTitle() {
        return getTextFromElement(desktopTitle);
    }

    public List<WebElement> getListsOfProduct() {
        return (List<WebElement>) getWebElement1(listOfProduct);
    }

    public void selectSortByZToA(String option) {
        selectByVisibleTextFromDropDown(productSorting, option);
    }

    public void clickOnYourSelectedProduct(String productName) {
        clickOnElement(By.linkText(productName));
    }
}
