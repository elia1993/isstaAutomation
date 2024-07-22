package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FlightOrderTest {
    WebDriver driver;
    FlightsHomePage homePage;
    SearchResultsPage searchResultsPage;
    CheckoutPage checkoutPage;

    @BeforeMethod
    public void setUp() {
        // Set the path to the msedgedriver executable
        SafariOptions options = new SafariOptions();
        driver = new SafariDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.issta.co.il/");

        // Initialize page objects
        homePage = new FlightsHomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        checkoutPage = new CheckoutPage(driver);

    }

    @Test
    public void testOrderingAFlight() throws InterruptedException {
        // Click on the Flights tab
    	homePage.clickFlightsTab();
        // Enter the departure city
        homePage.setDeparture("ברלין");
        // Enter the destination city
        homePage.setDestination("אמסטרדם");
        // Click the Search button
        homePage.setStartDate("26/07/24");
        homePage.setEndDate("28/07/24");
        homePage.clickSearchButton();
        homePage.flightDetails();
        // Assert that the checkout page is displayed
        String expectedUrlPrefix = "https://www.issta.co.il/flights/checkout";
        assertTrue(driver.getCurrentUrl().startsWith(expectedUrlPrefix), "Checkout page is not displayed.");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
