package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {
    WebDriver driver;
    WebDriverWait wait;

    public SearchResultPage(WebDriver _driver, WebDriverWait _wait) {
        this.driver = _driver;
        this.wait = _wait;
    }

    public void selectRigthResult(String name) {
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='findSection'][1]//a[text()='" + name + "']")));
        result.click();
    }
}
