package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.InvestopediaPage;

import static org.junit.Assert.fail;

public class StockPriceSteps {

    private InvestopediaPage investopediaPage;

    public StockPriceSteps(InvestopediaPage investopediaPage) {
        this.investopediaPage = investopediaPage;
    }

    @Given("I Logon to Investopedia")
    public void i_logon_to_investopedia() {
        investopediaPage.goToInvestopedia();
    }

    @When("The Stock Name Matches the Expected {string}")
    public void the_stock_name_matches_the_expected(String string) {
        Assert.assertTrue(string.equals(investopediaPage.getStockTitle()));
    }

    @Then("Validate the Apple Stock Price with {double} USD")
    public void validate_the_apple_stock_price_with_usd(double expPrice) {

        double priceFromWeb = investopediaPage.getStockPrice();
        if (priceFromWeb < expPrice) {
            Assert.assertTrue(true);
        } else {
            fail(String.format("Stock Price %d greater than Expected value %d ", priceFromWeb, expPrice));
        }

    }

    @After
    public void closeBrowser() {
        investopediaPage.closeBrowser();
    }
}
