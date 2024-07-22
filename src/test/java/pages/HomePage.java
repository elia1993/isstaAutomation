package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By flightsTab = By.xpath("//a[@href='/flights']");
    private By departureField = By.cssSelector(".ng-field.ng-field-autocomplete.ng-field-destination");
    private By inputFieldsLocator = By.cssSelector(".ng-field.ng-field-autocomplete.ng-field-destination");
    private By startDateField = By.id("vacations-start-date");
    private By endDateField = By.id("vacations-end-date");
    private By searchButton = By.cssSelector(".ng");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Methods to interact with the page
    public void clickFlightsTab() {
        try {
        	Thread.sleep(2000); 

            WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(flightsTab));
            tab.click();
            System.out.println("Flights tab clicked");
        } catch (Exception e) {
            System.out.println("Failed to click Flights tab");
            e.printStackTrace();
        }
    }

    /*
    public void setDeparture() {
        WebElement departureInput = wait.until(ExpectedConditions.visibilityOfElementLocated(departureField));
        departureInput.click();
        departureInput.clear();
        By ulLocator = By.cssSelector(".ng-list-autocomplete");
        wait.until(ExpectedConditions.visibilityOfElementLocated(ulLocator));

        // Locate the first <i> element inside the <ul>
        By firstIElementLocator = By.cssSelector(".ng-list-autocomplete li:first-child i");
        WebElement firstIElement = wait.until(ExpectedConditions.elementToBeClickable(firstIElementLocator));

        // Click the first <i> element
        firstIElement.click();
    }
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
        // Enter a search query to trigger suggestions
        departureInput.sendKeys(departure); // Type something to trigger autocomplete
        Thread.sleep(2000); // 2 seconds sleep

        // Wait for the suggestions list to be visible
        WebElement suggestionsList = wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionsListLocator));

        // Find all <li> elements within the suggestions list
        List<WebElement> items = suggestionsList.findElements(itemLocator);

        // Check if there are enough items in the list
        if (items.size() > 1) { // Ensure there are at least 2 items
            // Click on the second <li> element
            WebElement secondItem = items.get(1); // Index 1 for the second item
            secondItem.click();
            Thread.sleep(2000); // 2 seconds sleep
            System.out.println("Clicked on the second item.");
            Thread.sleep(2000); // 2 seconds sleep
        } else {
            System.out.println("Less than two items found.");
        }

    } catch (org.openqa.selenium.TimeoutException e) {
        System.out.println("TimeoutException: Failed to find the suggestions list within the timeout period.");
        e.printStackTrace();
    } catch (Exception e) {
        System.out.println("Exception: Failed to click on the desired item.");
        e.printStackTrace();
    }
}

public void setDestination(String destination) {
    try {
    	  By suggestionsListLocator = By.cssSelector(".ng-list-autocomplete");
          By itemLocator = By.cssSelector(".ng-list-autocomplete li");
        // Find all input fields with the specified class
        List<WebElement> inputFields = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(inputFieldsLocator));
        
        System.out.println("Less than two input fields found." + inputFields.size());

        // Target the second input field
        WebElement destinationInput = inputFields.get(1); // Index 1 for the second item
        
        // Click on the destination input field to activate the autocomplete
        destinationInput.click();
        destinationInput.clear();
        destinationInput.sendKeys(destination);

		// Wait for the suggestions list to be visible
        WebElement suggestionsList = wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionsListLocator));

        // Find all <li> elements within the suggestions list
        Thread.sleep(2000);
        List<WebElement> items = suggestionsList.findElements(itemLocator);

        // Check if there are enough items in the list
        if (items.size() > 1) { // Ensure there are at least 2 items
            // Click on the second <li> element
            WebElement secondItem = items.get(1); // Index 1 for the second item
            secondItem.click();
            Thread.sleep(2000); // 2 seconds sleep
            System.out.println("Clicked on the second item.");
            Thread.sleep(2000); // 2 seconds sleep
        } else {
            System.out.println("Less than two items found.");
        }

    } catch (org.openqa.selenium.TimeoutException e) {
        System.out.println("TimeoutException: Failed to find the suggestions list within the timeout period.");
        e.printStackTrace();
    } catch (Exception e) {
        System.out.println("Exception: Failed to click on the desired item.");
        e.printStackTrace();
    }
}


    public void setStartDate(String startDate) {
        try {
            WebElement startDateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(startDateField));
            startDateInput.clear();
            startDateInput.sendKeys(startDate);
            System.out.println("Start date set to: " + startDate);
        } catch (Exception e) {
            System.out.println("Failed to set start date");
            e.printStackTrace();
        }
    }

    public void setEndDate(String endDate) {
        try {
            WebElement endDateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(endDateField));
            endDateInput.clear();
            endDateInput.sendKeys(endDate);
            System.out.println("End date set to: " + endDate);
        } catch (Exception e) {
            System.out.println("Failed to set end date");
            e.printStackTrace();
        }
    }

    public void clickSearchButton() {
        try {
        	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        	element.click();
            System.out.println("Search button clicked");
        } catch (Exception e) {
            System.out.println("Failed to click search button");
            e.printStackTrace();
        }
    }
}
