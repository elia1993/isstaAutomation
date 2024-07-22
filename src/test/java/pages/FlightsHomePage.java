package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class FlightsHomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By flightsTab = By.xpath("//a[@href='/flights']");
    private By departureField = By.xpath("//input[@placeholder='בחר מוצא']");
    private By DestinationField = By.xpath("//input[@placeholder='לאיפה?']");
    // The date picker container
    private By startDateField = By.id("start_date");
    private By endDateField = By.id("end_date");
    private By searchButton = By.xpath("//button[text()='חפשו']");

    private static final Logger logger = LoggerFactory.getLogger(FlightOrderTest.class);


    // Constructor
    public FlightsHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickFlightsTab() {
        try {
            WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(flightsTab));
            tab.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the Departure.
     *
     * @param Departure The destination to set.
     */
    public void setDeparture(String departure) {
    try {
        // Define locators
        By suggestionsListLocator = By.cssSelector(".ng-list-autocomplete");
        By itemLocator = By.cssSelector(".ng-list-autocomplete li");
        // Click on the input field to activate the autocomplete
        WebElement departureInput = wait.until(ExpectedConditions.visibilityOfElementLocated(departureField));
        departureInput.click();
        departureInput.clear();
        Thread.sleep(2000); // 2 seconds sleep
        // Enter a search query to trigger departure
        departureInput.sendKeys(departure);
        Thread.sleep(2000);
        WebElement suggestionsList = wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionsListLocator));
        // Find all <li> elements within the suggestions list
        List<WebElement> items = suggestionsList.findElements(itemLocator);
        // Check if there are enough items in the list
        if (items.size() > 1) { // Ensure there are at least 2 items
            // Click on the second <li> element
            WebElement secondItem = items.get(1); // Index 1 for the second item
            secondItem.click();
            Thread.sleep(2000); // 2 seconds sleep
            logger.info("Clicked on the second item.");
            Thread.sleep(2000); // 2 seconds sleep
        } else {
            logger.info("Less than two items found.");
        }
    } catch (org.openqa.selenium.TimeoutException e) {
        System.out.println("TimeoutException: Failed to find the suggestions list within the timeout period.");
        e.printStackTrace();
    } catch (Exception e) {
        System.out.println("Exception: Failed to click on the desired item.");
        e.printStackTrace();
    }
}

    /**
     * Sets the destination.
     *
     * @param destination The destination to set.
     */
    public void setDestination(String Destination) {
        try {
            // Click on the input field to activate the autocomplete
            WebElement departureInput = wait.until(ExpectedConditions.visibilityOfElementLocated(DestinationField));
            departureInput.click();
            // Enter a search query to trigger Destination
            departureInput.sendKeys(Destination);
            Thread.sleep(2000); // 2 seconds sleep
            logger.info("Setting Destination to:{}",Destination);
        } catch (org.openqa.selenium.TimeoutException e) {
            logger.error("TimeoutException: Failed to find the suggestions list or item within the timeout period.");
            e.printStackTrace();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            logger.error("NoSuchElementException: Element not found.");
            e.printStackTrace();
        } catch (Exception e) {
            logger.error("Exception: Failed to click on the desired item.");
            e.printStackTrace();
        }
    }


/**
 * Sets the start date for the flight.
 *
 * @param startDate The start date in "yyyy-MM-dd" format.
 */
    public void setStartDate(String startDate) {
        try {
            WebElement startDateInput = wait.until(ExpectedConditions.elementToBeClickable(startDateField));
            startDateInput.click();
            String[] dateParts = startDate.split("/");
            int date = Integer.parseInt(dateParts[0]);
            String xpathExpression = String.format("//div[contains(@class, 'day') and contains(@class, 'valid') and span[text()='%d']]", date);
            WebElement dateElement = driver.findElement(By.xpath(xpathExpression));
            dateElement.click();
            Thread.sleep(2000); // 2 seconds slee
            logger.info("Setting start date to: {}", startDate);
        } catch (Exception e) {
            logger.error("Invalid date format: {}", startDate, e);
            e.printStackTrace();
        }
    }
    /**
     * Sets the end date for the flight.
     *
     * @param endDate The end date in "yyyy-MM-dd" format.
     */
    public void setEndDate(String endDate) {
        try {
            String[] dateParts = endDate.split("/");
            int date = Integer.parseInt(dateParts[0]);
            String xpathExpression = String.format("//div[contains(@class, 'day') and contains(@class, 'valid') and span[text()='%d']]", date);
            WebElement dateElement = driver.findElement(By.xpath(xpathExpression));
            dateElement.click();
            Thread.sleep(2000); // 2 seconds sleep
            logger.info("End date set to: " + endDate);
        } catch (Exception e) {
            logger.error("Failed to set end date", e);
            e.printStackTrace();
        }
    }
    public void clickSearchButton() {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        	element.click();
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * opens flight details page.
     */
    public void flightDetails(){
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("a[flight-id]")));
            List<WebElement> flightIdElements = driver.findElements(By.cssSelector("a[flight-id]"));
            DetailFlight detailFlight = new DetailFlight(driver);
            detailFlight.openFlightDetailsPage(flightIdElements.get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
