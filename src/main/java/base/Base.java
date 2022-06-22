package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static base.Constants.Base_URL;

public class Base {
    public WebDriver webDriver;
    public WebDriverWait wait;

    public void setWebDriver(String testBrowser) {

        switch (testBrowser) {
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                wait = new WebDriverWait(webDriver, 3);
                System.out.println("Chrome Açıldı");
                webDriver.manage().window().maximize();
                break;
            }
            case "firefox": {
                WebDriverManager.chromedriver().setup();
                webDriver = new FirefoxDriver();
                System.out.println("Firefox Açıldı");
                webDriver.manage().window().maximize();
            }

        }

    }

    public void openBrowser() {
        webDriver.get(Base_URL);
        webDriver.manage().window().maximize();
    }

    public void quit() {
        webDriver.quit();
    }
}
