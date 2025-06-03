package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage {

    private final String dropdown = ".//div[@id='accordion__heading-%d']";
    private final String textUnderDropdown = ".//div[@id='accordion__panel-%d']";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void scrollPageUntilDropdown(int index) {
        WebElement element = driver.findElement(By.xpath(String.format(dropdown, index)));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waitForLoadDropdownText(int index) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(textUnderDropdown, index))));
    }

    public String clickDropdown(int index) {
        scrollPageUntilDropdown(index);
        driver.findElement(By.xpath(String.format(dropdown, index))).isEnabled();
        driver.findElement(By.xpath(String.format(dropdown, index))).click();
        waitForLoadDropdownText(index);
        return driver.findElement(By.xpath(String.format(textUnderDropdown, index))).getText();
    }

    private final By orderButtonUp = By.xpath(".//button[@class='Button_Button__ra12g']");
    private final By orderButtonDown = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");

    public void clickOrderButtonUp() {
        driver.findElement(orderButtonUp).isEnabled();
        driver.findElement(orderButtonUp).click();
    }

    public void scrollPageUntilOrderButtonDown() {
        WebElement element = driver.findElement(orderButtonDown);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickOrderButtonDown() {
        scrollPageUntilOrderButtonDown();
        driver.findElement(orderButtonDown).isEnabled();
        driver.findElement(orderButtonDown).click();
    }

}
