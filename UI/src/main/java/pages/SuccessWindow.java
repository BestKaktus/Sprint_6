package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessWindow extends BasePage {

    public SuccessWindow(WebDriver driver) {
        super(driver);
    }

    private final By message = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

    public String checkMessageGetText() {
        return driver.findElement(message).getText();
    }

}
