import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SuccessOrderChromeTest{

    private WebDriver driver;
    private final String URL = "https://qa-scooter.praktikum-services.ru/";

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void checkSuccessOrderUpButton(String nameValue, String surnameValue, String addressValue,
                                          String metroStationValue, String phoneNumberValue,
                                          String date, String duration, String colorId, String comment) {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.acceptCookies();
        objMainPage.clickOrderButtonUp();
        ForWhomPage objForWhomPage = new ForWhomPage(driver);
        objForWhomPage.fillIntheFields(nameValue, surnameValue, addressValue, metroStationValue,
                phoneNumberValue);
        objForWhomPage.clickContinueButton();
        AboutRentalPage objAboutRentalPage = new AboutRentalPage(driver);
        objAboutRentalPage.fillAboutRentalPageFields(date,duration, colorId, comment);
        objAboutRentalPage.clickOrderButton();
        ConfirmationWindow objConfirmationWindow = new ConfirmationWindow(driver);
        objConfirmationWindow.clickYesButton();
        SuccessWindow objSuccessWindow = new SuccessWindow(driver);
        objSuccessWindow.checkMessageGetText();
        assertTrue(objSuccessWindow.checkMessageGetText().contains("Заказ оформлен"));
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void checkSuccessOrderDownButton(String nameValue, String surnameValue, String addressValue,
                                            String metroStationValue, String phoneNumberValue,
                                            String date, String duration, String colorId, String comment) {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.acceptCookies();
        objMainPage.clickOrderButtonDown();
        ForWhomPage objForWhomPage = new ForWhomPage(driver);
        objForWhomPage.fillIntheFields(nameValue, surnameValue, addressValue, metroStationValue,
                phoneNumberValue);
        objForWhomPage.clickContinueButton();
        AboutRentalPage objAboutRentalPage = new AboutRentalPage(driver);
        objAboutRentalPage.fillAboutRentalPageFields(date,duration, colorId, comment);
        objAboutRentalPage.clickOrderButton();
        ConfirmationWindow objConfirmationWindow = new ConfirmationWindow(driver);
        objConfirmationWindow.clickYesButton();
        SuccessWindow objSuccessWindow = new SuccessWindow(driver);
        objSuccessWindow.checkMessageGetText();
        assertTrue(objSuccessWindow.checkMessageGetText().contains("Заказ оформлен"));
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of("Мяу", "Мяу", "Суздаль", "Царицыно", "79604568888",
                        "Choose четверг, 5-е июня 2025 г.", "двое суток", "black", "Ыыыыыыы"),
                Arguments.of("Морда", "Серая", "Москва", "Сокольники", "79604563423",
                        "Choose среда, 4-е июня 2025 г.", "сутки", "grey", "comment"),
                Arguments.of("Ещё", "Морда", "Санкт-Петербург", "Маяковская", "79604500023",
                        "Choose вторник, 3-е июня 2025 г.", "сутки", "grey", "12345")
        );
    }

}
