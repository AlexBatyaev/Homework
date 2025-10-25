import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    public void testPaymentSystemLogos() {
        int expectedLogoCount = 5;
        assertEquals(expectedLogoCount, paymentPage.getPaymentSystemLogosCount(), "Неверное количество логотипов");

        for (int i = 0; i < paymentPage.getPaymentSystemLogosCount(); i++) {
            assertNotNull(paymentPage.getPaymentSystemLogoSrc(i), "У логотипа " + (i + 1) + " нет атрибута src");
            assertNotNull(paymentPage.getPaymentSystemLogoAlt(i), "У логотипа " + (i + 1) + " нет атрибута alt");
        }
    }

    @Test
    public void testDetailsServiceLink() {
        assertEquals("Подробнее о сервисе", paymentPage.getDetailsServiceLinkText(), "Текст ссылки не соответствует ожидаемому");
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", paymentPage.getDetailsServiceLinkHref(), "Атрибут href ссылки не соответствует ожидаемому");
    }

    @Test
    public void testPayConnectionForm() {
        paymentPage.selectPaymentType("Услуги связи");
    }

    @Test
    public void testPayInternetForm() {
        paymentPage.selectPaymentType("Домашний интернет");
        paymentPage.enterInternetPhone("291234567");
        paymentPage.enterInternetSum("15");
        paymentPage.enterInternetEmail("internet@example.com");
        paymentPage.clickInternetSubmitButton();
    }

    @Test
    public void testPayInstalmentForm() {
        paymentPage.selectPaymentType("Рассрочка");
        paymentPage.enterInstalmentScore("1234567890");
        paymentPage.enterInstalmentSum("20");
        paymentPage.enterInstalmentEmail("instalment@example.com");
        paymentPage.clickInstalmentSubmitButton();
    }

    @Test
    public void testPayArrearsForm() {
        paymentPage.selectPaymentType("Задолженность");
        paymentPage.enterArrearsScore("0987654321");
        paymentPage.enterArrearsSum("25");
        paymentPage.enterArrearsEmail("arrears@example.com");
        paymentPage.clickArrearsSubmitButton();
    }
}
