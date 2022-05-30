package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ReadProperties;
import utils.WebdriverUtil;

public class InvestopediaPage extends WebdriverUtil {

    @FindBy(css = ".tv-symbol-header__first-line.tv-symbol-info-widget__first-line")
    private WebElement stockTitle;

    @FindBy(css = ".tv-symbol-price-quote__value.js-symbol-last")
    private WebElement stockPrice;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptButton;

    public InvestopediaPage() {
        PageFactory.initElements(webDriver, this);
    }

    public void goToInvestopedia() {
        ReadProperties readProperties = new ReadProperties();
        gotoURL(readProperties.getProperty("page_url"));
        clickOnWebElement(acceptButton);
        webDriver.switchTo().frame(0);


    }

    public String getStockTitle() {
        return getTextFromElement(stockTitle);
    }

    public double getStockPrice() {
        return Double.parseDouble(getTextFromElement(stockPrice));
    }

    public void closeBrowser() {
        webDriver.quit();
    }

}
