package index.php.demo.com.tutorialsninja.testsuite;

import index.php.demo.com.tutorialsninja.pages.ComponentsPage;
import index.php.demo.com.tutorialsninja.pages.DesktopsPage;
import index.php.demo.com.tutorialsninja.pages.HomePage;
import index.php.demo.com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import index.php.demo.com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {

    HomePage homePage = new HomePage();
    DesktopsPage desktopsPage = new DesktopsPage();
    LaptopsAndNotebooksPage notebooksPage = new LaptopsAndNotebooksPage();
    ComponentsPage componentsPage = new ComponentsPage();

    public void selectMenu(String menu) {
       /* List<WebElement> topMenuList = homePage.getTopMenuList();
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = homePage.getTopMenuList();
        }*/
        homePage.clickOnMenuOption(menu);
    }

    @Test(groups = {"smoke"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        homePage.mouseHoverOnDesktop();
        Thread.sleep(2000);
        selectMenu("Show AllDesktops");
        Assert.assertEquals(desktopsPage.getDesktopPageTitle(), "Desktops",
                "Not navigate to Desktop page");
    }

    @Test(groups = {"sanity"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        homePage.mouseHoverOnLaptopAndNotBook();
        selectMenu("Show AllLaptops & Notebooks");
        Assert.assertEquals(notebooksPage.getTitleOfLaptopAndNotBookPage(),
                "Laptops & Notebooks", "Not navigate to Laptops and Notebooks page");
    }

    @Test(groups = {"regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        homePage.mouseHoverOnComponents();
        selectMenu("Show AllComponents");
        Assert.assertEquals(componentsPage.getPageTitleOfComponents(), "Components",
                "Not navigate to Components page");
    }
}
