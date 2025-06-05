package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class AboutRentalPage extends BasePage {

    public AboutRentalPage(WebDriver driver) {
        super(driver);
    }

    private final By timeOfDelivery = By.xpath(".//div[@class='react-datepicker__input-container']/input");
    private final String dateOfDelivery = ".//div[@aria-label='%s']";
    private final By durationOfRental = By.xpath(".//div[@class='Dropdown-placeholder']");
    private final String durationOption = ".//div[@role='option' and text()='%s']";
    private final String color = ".//input[@id='%s']";
    private final By commentForCourier = By.xpath(".//input[contains(@placeholder,'Комментарий')]");
    private final By orderButton = RelativeLocator.with(By.xpath(".//button[contains(text(), 'Заказать')]")).below(commentForCourier);

    public void fillAboutRentalPageFields(String date, String duration, String colorId, String comment) {
        driver.findElement(timeOfDelivery).isEnabled();
        driver.findElement(timeOfDelivery).click();
        driver.findElement(By.xpath(String.format(dateOfDelivery, date))).isEnabled();
        driver.findElement(By.xpath(String.format(dateOfDelivery, date))).click();
        driver.findElement(durationOfRental).isEnabled();
        driver.findElement(durationOfRental).click();
        driver.findElement(By.xpath(String.format(durationOption, duration))).isEnabled();
        driver.findElement(By.xpath(String.format(durationOption, duration))).click();
        driver.findElement(By.xpath(String.format(color, colorId))).click();
        driver.findElement(commentForCourier).isEnabled();
        driver.findElement(commentForCourier).sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).isEnabled();
        driver.findElement(orderButton).click();
    }

}
