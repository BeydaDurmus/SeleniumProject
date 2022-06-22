import base.Base;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SearchResultPage;

public class MainTest extends Base {

    MainPage mainPage;
    SearchResultPage resultPage;
    private static final Logger Log = Logger.getLogger(MainPage.class);

    @BeforeTest
    public void setUp() {
        Log.info("Test is Starting...");
        setWebDriver("chrome");
        mainPage = new MainPage(webDriver, wait);
        resultPage = new SearchResultPage(webDriver, wait);
        openBrowser();
    }

    @Test
    public void clickMenuTest() {

        mainPage.clickMenu();
        quit();
    }

    @Test
    public void checkRightMenuItem() {
        mainPage.clickMenu();
        mainPage.selectMenuItem();
        String name = mainPage.checkPageName();
        Assert.assertEquals(name, "OSCARS");
    }

    @Test(dataProvider = "data-provider")
    public void sendKeysSearchBar(String name) {
        mainPage.sendKeysSearchBar(name);
        resultPage.selectRigthResult(name);
    }

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod() {
        return new Object[][]{{"The Circus"}, {"The Jazz Singer"}};
    }

    @AfterTest
    public void quitBrowser() {
        Log.info("Test Finished...");
        quit();
    }
}
