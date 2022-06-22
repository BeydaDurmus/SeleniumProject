import base.Base;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.Oscars;
import pages.SearchResultPage;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class OscarsPageTest extends Base {
    Oscars oscarsPage;
    MainPage mainPage;
    SearchResultPage resultPage;
    List<String> infoListFromSearch = new ArrayList<String>();
    List<String> infoListFromMenu = new ArrayList<String>();
    List<String> photos = new ArrayList<String>();
    private static final Logger Log = Logger.getLogger(MainPage.class);

    @BeforeTest
    public void setUp() {
        Log.info("Test is Starting...");
        setWebDriver("chrome");
        oscarsPage = new Oscars(webDriver, wait);
        mainPage = new MainPage(webDriver, wait);
        resultPage = new SearchResultPage(webDriver, wait);
        openBrowser();
    }


    @Test
    public void checkSelectedRightYear() {
        mainPage.clickMenu();
        mainPage.selectMenuItem();
        oscarsPage.selectYear();
        String name = oscarsPage.checkRightYearPage();
        Assert.assertEquals(name, "1929 Awards");
    }

    @Test(dataProvider = "data-provider")
    public void checkFilmFromMenu(String name) {
        mainPage.clickMenu();
        mainPage.selectMenuItem();
        oscarsPage.selectYear();
        oscarsPage.checkRightYearPage();
        oscarsPage.selectFilm(name);
        String pageName = oscarsPage.checkRightPageName();
        infoListFromMenu = oscarsPage.getInfoList();
        Assert.assertEquals(pageName, name);
    }

    @Test(dataProvider = "data-provider")
    public void checkFilmFromSearch(String name) {
        mainPage.sendKeysSearchBar(name);
        resultPage.selectRigthResult(name);
        String pageName = oscarsPage.checkRightPageName();
        infoListFromSearch = oscarsPage.getInfoList();
        Assert.assertEquals(pageName, name);
    }

    @Test
    public void checkInfoList() {
        Assert.assertEquals(infoListFromMenu, infoListFromSearch);
    }

    @Test(dataProvider = "data-provider")
    public void getPhotoLink(String name) {
        mainPage.sendKeysSearchBar(name);
        resultPage.selectRigthResult(name);
        oscarsPage.clickPhotos();
        photos = oscarsPage.getPhotosLink();
        for (String photoUrl : photos) {
            try {
                URL url = new URL(photoUrl);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("HEAD");
                con.connect();
                Integer statusCode = con.getResponseCode();
                Log.info("Photo URL Is A Valid Link.." + photoUrl);
                Assert.assertEquals(200, statusCode);
            } catch (Exception e) {

                // Display exception/s on console
                System.out.println(e.getMessage());
            }


        }

    }

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod() {
        return new Object[][]{{"The Circus"}, {"The Jazz Singer"}};
    }

    @AfterTest
    public void quitBrowser() {
        Log.info("Test Finished.");
        quit();
    }
}
