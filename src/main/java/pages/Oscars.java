package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Oscars {

    WebDriver driver;
    WebDriverWait wait;
    List<String> infos = new ArrayList<String>();
    List<String> photosLink = new ArrayList<String>();

    public Oscars(WebDriver _driver, WebDriverWait _wait) {
        this.driver = _driver;
        this.wait = _wait;
    }

    public void selectYear() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='event-history-widget__years']//a[contains(text(),'1929')]")));
        element.click();
    }

    public String checkRightYearPage() {
        String pageName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='event-year-header__year']"))).getText();
        return pageName;
    }

    public void selectFilm(String name) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='event-widgets__award'][2]//div[@class='event-widgets__primary-nominees']//a[contains(text(),'" + name + "')]")));
        element.click();
    }

    public String checkRightPageName() {
        String pageName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-testid='hero-title-block__title']"))).getText();
        return pageName;
    }

    public List<String> getInfoList() {
        List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@data-testid='title-pc-wide-screen']//li[@class='ipc-inline-list__item']")));
        for (WebElement element : list) {
            infos.add(element.getText());
        }
        return infos;
    }

    public void returnMainPage() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("home_img_holder")));
        element.click();
    }

    public void clickPhotos() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-testid='photos-title']")));
        element.click();
    }

    public List<String> getPhotosLink() {
        List<WebElement> photos = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='media_index_thumb_list']/a")));
        for (WebElement photo : photos) {
            String link = photo.getAttribute("href");
            photosLink.add(link);
        }
        return photosLink;
    }


}
