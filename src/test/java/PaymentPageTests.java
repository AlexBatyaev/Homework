import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(AllureJunit5.class)
@Epic("UI Tests")
@Feature("Payment Page")
public class PaymentPageTests {

    private WebDriver driver;
    private PaymentPage paymentPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        paymentPage = new PaymentPage(driver);
        paymentPage.acceptCookies();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @Story("Check Logos")
    @Description("Verify that payment system logos are displayed correctly.")
    @Severity(SeverityLevel.NORMAL) // Уровень важности теста
    public void testPaymentSystemLogos() {
        int expectedLogoCount = 5;
        assertEquals(expectedLogoCount, paymentPage.getPaymentSystemLogosCount(), "Неверное количество логотипов");

        for (int i = 0; i < paymentPage.getPaymentSystemLogosCount(); i++) {
            assertNotNull(paymentPage.getPaymentSystemLogoSrc(i), "У логотипа " + (i + 1) + " нет атрибута src");
            assertNotNull(paymentPage.getPaymentSystemLogoAlt(i), "У логотипа " + (i + 1) + " нет атрибута alt");
        }
    }

    @Test
    @Story("Check 'Details of Service' Link")
    @Description("Check if the 'Details of Service' link is correct.")
    @Severity(SeverityLevel.NORMAL)
    public void testDetailsServiceLink() {
        assertEquals("Подробнее о сервисе", paymentPage.getDetailsServiceLinkText(), "Текст ссылки не соответствует ожидаемому");
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", paymentPage.getDetailsServiceLinkHref(), "Атрибут href ссылки не соответствует ожидаемому");
    }

    @Test
    @Story("Pay Connection Form Test")
    @Description("Test the 'Pay Connection' form.")
    @Severity(SeverityLevel.MINOR)
    public void testPayConnectionForm() {
        paymentPage.selectPaymentType("Услуги связи");
    }

    @Test
    @Story("Pay Internet Form Test")
    @Description("Test the 'Pay Internet' form.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("INTERNET-PAY-001")
    public void testPayInternetForm() {
        paymentPage.selectPaymentType("Домашний интернет");
        paymentPage.enterInternetPhone("291234567");
        paymentPage.enterInternetSum("15");
        paymentPage.enterInternetEmail("internet@example.com");
        paymentPage.clickInternetSubmitButton();
    }

    @Test
    @Story("Pay Installment Form Test")
    @Description("Test the 'Pay Installment' form.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("INSTALLMENT-PAY-001")
    public void testPayInstalmentForm() {
        paymentPage.selectPaymentType("Рассрочка");
        paymentPage.enterInstalmentScore("1234567890");
        paymentPage.enterInstalmentSum("20");
        paymentPage.enterInstalmentEmail("instalment@example.com");
        paymentPage.clickInstalmentSubmitButton();
    }

    @Test
    @Story("Pay Arrears Form Test")
    @Description("Test the 'Pay Arrears' form.")
    @Severity(SeverityLevel.NORMAL)
    public void testPayArrearsForm() {
        paymentPage.selectPaymentType("Задолженность");
        paymentPage.enterArrearsScore("0987654321");
        paymentPage.enterArrearsSum("25");
        paymentPage.enterArrearsEmail("arrears@example.com");
        paymentPage.clickArrearsSubmitButton();
    }
}
