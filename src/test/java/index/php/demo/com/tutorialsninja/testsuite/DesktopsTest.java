package index.php.demo.com.tutorialsninja.testsuite;

import index.php.demo.com.tutorialsninja.pages.DesktopsPage;
import index.php.demo.com.tutorialsninja.pages.HomePage;
import index.php.demo.com.tutorialsninja.pages.ProductDetailsPage;
import index.php.demo.com.tutorialsninja.pages.ShoppingCartPage;
import index.php.demo.com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

import java.util.ArrayList;
import java.util.Collections;

public class DesktopsTest extends BaseTest {

    HomePage homePage ;
    DesktopsPage desktopsPage;
    ProductDetailsPage detailPage ;
    ShoppingCartPage cartPage ;

    @BeforeMethod
    public void inIt(){
        HomePage homePage = new HomePage();
        DesktopsPage desktopsPage = new DesktopsPage();
        ProductDetailsPage detailPage = new ProductDetailsPage();
        ShoppingCartPage cartPage = new ShoppingCartPage();
    }

    @Test(groups = {"sanity"})
    public void  verifyProductArrangeInAlphaBaticalOrder(){
        homePage.mouseHoverOnDesktop();
        homePage.clickOnMenuOption("Show AllDesktops");
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : desktopsPage.getListsOfProduct()) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
        desktopsPage.selectSortByZToA("Name (Z - A)");
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : desktopsPage.getListsOfProduct()) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);
        Assert.assertEquals(afterSortByZToAProductsName,originalProductsName,
                "Product not sorted into Z to A order");
    }

    @Test(dataProvider = "productData",dataProviderClass = TestData.class)
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        homePage.mouseHoverOnCurrencyAndClickOn();
        homePage.selectCurrencyAsAPound("£Pound Sterling");
        homePage.mouseHoverOnDesktop();
        homePage.clickOnMenuOption("Show AllDesktops");
        desktopsPage.selectSortByZToA("Name (A - Z)");
        desktopsPage.clickOnYourSelectedProduct("HP LP3065");
        Assert.assertEquals(detailPage.getPageTitle(), "HP LP3065",
                "Product not display");
        detailPage.selectDeliveryDate("2024", "November", "27");
        Thread.sleep(200);
        detailPage.enterQuantity("1");
        Thread.sleep(200);
        detailPage.clickOnAddToCartButton();
        Thread.sleep(2000);
        Assert.assertTrue(detailPage.getProductAddToCartSuccessMessage()
                        .contains("Success: You have added HP LP3065 to your shopping cart!"),
                "Product not added to cart");
        Thread.sleep(2000);
        detailPage.clickOnShoppingCartLink();
        Thread.sleep(2000);
        Assert.assertTrue(cartPage.getShoppingCartPageTitle().contains("Shopping Cart"));
        Assert.assertEquals(cartPage.getProductName(), "HP LP3065",
                "Product name not matched");
        Assert.assertTrue(cartPage.getDeliveryDate().contains("2024-11-27"),
                "Delivery date not matched");
        Assert.assertEquals(cartPage.getProductModel(), "Product 21",
                "Model not matched");
        Assert.assertEquals(cartPage.getProductTotalPrise(), "£74.73",
                "Total not matched");
    }
}
