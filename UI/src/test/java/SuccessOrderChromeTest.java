import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SuccessOrderChromeTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }

    @Test
    public void checkSuccessOrderUpButton() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.acceptCookies();
        objMainPage.clickOrderButtonUp();
        ForWhomPage objForWhomPage = new ForWhomPage(driver);
        objForWhomPage.fillIntheFields("Морда", "Серая", "Москва", "Сокольники", "79604563423");
        objForWhomPage.clickContinueButton();
        AboutRentalPage objAboutRentalPage = new AboutRentalPage(driver);
        objAboutRentalPage.fillIntheFields("Choose среда, 4-е июня 2025 г.", "сутки", "grey", "comment");
        objAboutRentalPage.clickOrderButton();
        ConfirmationWindow objConfirmationWindow = new ConfirmationWindow(driver);
        objConfirmationWindow.clickYesButton();
        SuccessWindow objSuccessWindow = new SuccessWindow(driver);
        objSuccessWindow.checkMessageGetText();
        assertTrue(objSuccessWindow.checkMessageGetText().contains("Заказ оформлен"));
    }

    @Test
    public void checkSuccessOrderDownButton() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.acceptCookies();
        objMainPage.clickOrderButtonDown();
        ForWhomPage objForWhomPage = new ForWhomPage(driver);
        objForWhomPage.fillIntheFields("Мяу", "Мяу", "Суздаль", "Царицыно", "79604568888");
        objForWhomPage.clickContinueButton();
        AboutRentalPage objAboutRentalPage = new AboutRentalPage(driver);
        objAboutRentalPage.fillIntheFields("Choose четверг, 5-е июня 2025 г.", "двое суток", "black", "Ыыыыыыы");
        objAboutRentalPage.clickOrderButton();
        ConfirmationWindow objConfirmationWindow = new ConfirmationWindow(driver);
        objConfirmationWindow.clickYesButton();
        SuccessWindow objSuccessWindow = new SuccessWindow(driver);
        objSuccessWindow.checkMessageGetText();
        assertTrue(objSuccessWindow.checkMessageGetText().contains("Заказ оформлен"));
    }

}
