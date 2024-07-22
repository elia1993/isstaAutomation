package pages;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.SearchResultsPage;
public class FlightOrderTest {
    WebDriver driver;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    CheckoutPage checkoutPage;


    @BeforeMethod
    public void setUp() {
        // Set the path to the msedgedriver executable
        System.setProperty("chromedriver", "C:\\Users\\elia_\\eclipse-workspace\\AutomationTest\\lib\\chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.issta.co.il/");

        // Initialize page objects
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    public void testOrderingAFlight() throws InterruptedException {
        // Click on the Flights tab
    	homePage.clickFlightsTab();
        // Enter the departure city

        homePage.setDeparture("london");
        // Enter the destination city
        homePage.setDestination("Los Angeles");
        // Click the Search button
        //homePage.setStartDate("2024-08-01");
        //homePage.setEndDate("2024-08-15");
        //homePage.clickSearchButton();

        // Select the first flight from the search results
        //searchResultsPage.selectFirstFlight();

        // Assert that the checkout page is displayed
        Assert.assertTrue(checkoutPage.isCheckoutPageDisplayed(), "Checkout page is not displayed.");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
