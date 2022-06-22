package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    WebDriver driver;
    WebDriverWait wait;


    public MainPage(WebDriver _driver, WebDriverWait _wait) {
        this.driver = _driver;
        this.wait = _wait;
    }

    public void clickMenu() {
        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imdbHeader-navDrawerOpen--desktop")));
        menu.click();
    }

    public void selectMenuItem() {
        WebElement menuItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/oscars/?ref_=nv_ev_acd']")));
        menuItem.click();
    }

    public String checkPageName() {
        String pageName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='nav-heading']//h1"))).getText();
        return pageName;
    }

    public void sendKeysSearchBar(String query) {
        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        searchBar.sendKeys(query);
        searchBar.sendKeys(Keys.RETURN);
    }

}
