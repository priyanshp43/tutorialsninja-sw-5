package index.php.demo.com.tutorialsninja.pages;

import index.php.demo.com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "(//h1)[2]")
    WebElement pageTitle;

//    By pageTitle = By.xpath("(//h1)[2]");

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productName ;

//    By productName = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement deliveryDate ;

//    By deliveryDate = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]");

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement productModel;

//    By productModel = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]");

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement totalPrice ;


//    By totalPrice = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");

    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement changeQuantity;

//    By changeQuantity = By.xpath("//input[contains(@name, 'quantity')]");

    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement updateBtn;

//    By updateBtn = By.xpath("//button[contains(@data-original-title, 'Update')]");

    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement messageOfProductUpdate ;

//    By messageOfProductUpdate = By.xpath("//div[@id='checkout-cart']/div[1]");

    public String getShoppingCartPageTitle() {
        return getTextFromElement(pageTitle);
    }
    public String getProductName() {
        return getTextFromElement(productName);
    }
    public String getDeliveryDate() {
        return getTextFromElement(deliveryDate);
    }
    public String getProductModel() {
        return getTextFromElement(productModel);
    }
    public String getProductTotalPrise() {
        return getTextFromElement(totalPrice);
    }
    public void changeQuantity(String qty){
        sendTextToElement(changeQuantity, qty);
    }
    public void clickOnUpdateButton(){
        clickOnElement(updateBtn);
    }
    public String getProductUpdateSuccessMessage() {
        return getTextFromElement(messageOfProductUpdate);
    }
}
