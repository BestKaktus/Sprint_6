package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookies() {
        driver.findElement(By.id("rcc-confirm-button")).click();
    }
}
