package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
    WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    By selectFlightButton = By.xpath("//button[contains(text(),'Select')]"); // Adjust the locator

    public void selectFirstFlight() {
        driver.findElement(selectFlightButton).click();
    }
}
