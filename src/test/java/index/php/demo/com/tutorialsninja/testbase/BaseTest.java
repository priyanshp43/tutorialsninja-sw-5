package index.php.demo.com.tutorialsninja.testbase;

import index.php.demo.com.tutorialsninja.propertyreader.PropertyReader;
import index.php.demo.com.tutorialsninja.utilities.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utility {
    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod
    public void setUp(){
        selectBrowser(browser);
    }


    @AfterMethod
    public void tearDown(){
        closeBrowser();
    }
}
