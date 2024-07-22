package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    By checkoutHeader = By.id("checkoutHeader"); // Adjust the locator

    public boolean isCheckoutPageDisplayed() {
        return driver.findElement(checkoutHeader).isDisplayed();
    }
}
