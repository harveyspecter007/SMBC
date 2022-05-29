package utils;

import io.cucumber.java.After;
import lombok.extern.java.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log
public class WebdriverUtil {

    public static WebDriver webDriver;
    WebDriverWait wait;

    public WebdriverUtil() {
        System.setProperty("webdriver.chrome.driver", "/Users/kalyansangaraju/Downloads/chromedriver");
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, 15);

    }

    public String getTextFromElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        log.info("Text from WebElement : " + element.getText());
        return element.getText();

    }

    public void gotoURL(String url) {
        log.info("Navigating to URL : " + url);
        webDriver.get(url);
    }

    public void clickOnWebElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }


}
