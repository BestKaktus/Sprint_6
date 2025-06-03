package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmationWindow extends BasePage{

    public ConfirmationWindow(WebDriver driver) {
        super(driver);
    }

    private final By yesButton = By.xpath(".//button[contains(text(), 'Да')]");

    public void clickYesButton() {
        waitUntilButtonYesIsClickable();
        driver.findElement(yesButton).isEnabled();
        driver.findElement(yesButton).click();
    }

    public void waitUntilButtonYesIsClickable() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(yesButton));
    }

}
