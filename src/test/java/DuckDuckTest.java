import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DuckDuckTest {
    WebDriver driver;


    @Test
    public void testDuckSearch() {

        try {

            System.setProperty("webdriver.chrome.driver", "/Users/kalyansangaraju/Downloads/chromedriver");
            driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, 10);

            driver.get("https://duckduckgo.com/");

            WebElement searchTextbox = driver.findElement(By.id("search_form_input_homepage"));
            searchTextbox.sendKeys("test");
            WebElement searchButton = driver.findElement(By.id("search_button_homepage"));
            searchButton.click();

       /* WebElement popup = driver.findElement(By.cssSelector("ddgsi badge-link__close js-badge-link-dismiss"));
        popup.click();*/

            WebElement firstItem = driver.findElement(By.id("r1-0"));
            wait.until(ExpectedConditions.visibilityOf(firstItem));
            firstItem.click();

            String currentURL = driver.getCurrentUrl();
            System.out.println(currentURL);
            Assert.assertTrue("https://www.test.com/".equals(currentURL));
        } catch (Exception e) {

        } finally {
            driver.quit();
        }


    }


}
