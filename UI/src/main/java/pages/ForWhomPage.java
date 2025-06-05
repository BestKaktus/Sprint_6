package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForWhomPage extends BasePage {

    public ForWhomPage(WebDriver driver) {
        super(driver);
    }

    private final By username = By.xpath(".//input[contains(@placeholder, 'Имя')]");
    private final By surname = By.xpath(".//input[contains(@placeholder, 'Фамилия')]");
    private final By address = By.xpath(".//input[contains(@placeholder, 'Адрес')]");
    private final By metroStaton = By.xpath(".//input[contains(@placeholder, 'Станция')]");
    private final String metroDropdown = ".//*[contains(text(), '%s')]";
    private final By phoneNumber = By.xpath(".//input[contains(@placeholder, 'Телефон')]");
    private final By continueButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button");

    public void fillIntheFields(String nameValue, String surnameValue, String addressValue, String metroStationValue, String phoneNumberValue) {
        driver.findElement(username).sendKeys(nameValue);
        driver.findElement(surname).sendKeys(surnameValue);
        driver.findElement(address).sendKeys(addressValue);
        driver.findElement(metroStaton).click();
        driver.findElement(By.xpath(String.format(metroDropdown, metroStationValue))).click();
        driver.findElement(phoneNumber).sendKeys(phoneNumberValue);
    }

    public void clickContinueButton() {
        scrollPageContinueButton();
        driver.findElement(continueButton).click();
    }

    public void scrollPageContinueButton() {
        WebElement element = driver.findElement(continueButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

}
