package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class DetailFlight {
    private WebDriver driver;
    private WebDriverWait wait;
    private String url;

    private static final Logger logger = LoggerFactory.getLogger(FlightOrderTest.class);

    public DetailFlight(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void openFlightDetailsPage(WebElement flightDetailLink) {
        try {
            url = flightDetailLink.getAttribute("href");
            String startDelimiter = "/details.aspx";
            int startIndex = url.indexOf(startDelimiter);
            if (startIndex != -1) {
                String extractedUrl = url.substring(startIndex);
                logger.info("Extracted URL: " + extractedUrl);
            } else {
                logger.error("Start delimiter not found in the URL.");
            }
            driver.get("https://www.issta.co.il/flights" + url);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.open(arguments[0], '_blank');", url);
            wait.until(ExpectedConditions.urlContains("details.aspx"));
            // Click the flight detail link
            WebElement button = driver.findElement(By.xpath("//button[text()='המשך']"));
            button.click();
            logger.info("Successfully clicked the 'Continue' button to checkout.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

