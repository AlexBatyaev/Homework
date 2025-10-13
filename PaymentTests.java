import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PaymentTests {

    private WebDriver driver;
    private final String BASE_URL = "https://www.mts.by/";
    private final Duration TIMEOUT = Duration.ofSeconds(10);

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup(); // Use WebDriverManager for driver setup
        driver = new ChromeDriver();
        driver.manage().window().maximize(); //Maximize window
        driver.manage().timeouts().implicitlyWait(TIMEOUT);
        driver.get(BASE_URL);
        acceptCookies();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Helper method to accept cookies
    private void acceptCookies() {
        try {
            WebElement acceptCookiesButton = driver.findElement(By.xpath("//button[contains(text(), 'Принять')]"));
            acceptCookiesButton.click();
        } catch (NoSuchElementException e) {
            // Ignore if the cookies button is not present
        }
    }

    @Test
    @DisplayName("Проверка количества и атрибутов логотипов платежных систем")
    public void testPaymentSystemLogos() {
        List<WebElement> logos = driver.findElements(By.cssSelector(".pay__partners ul li img"));
        int expectedLogoCount = 5;

        Assertions.assertEquals(expectedLogoCount, logos.size(), "Неверное количество логотипов");

        for (WebElement logo : logos) {
            Assertions.assertNotNull(logo.getAttribute("src"), "У логотипа нет атрибута src");
            Assertions.assertNotNull(logo.getAttribute("alt"), "У логотипа нет атрибута alt");
        }
    }

    @Test
    @DisplayName("Проверка ссылки 'Подробнее о сервисе'")
    public void testDetailsServiceLink() {
        WebElement link = driver.findElement(By.cssSelector(".pay > .pay__wrapper > a"));
        Assertions.assertEquals("Подробнее о сервисе", link.getText(), "Текст ссылки не соответствует ожидаемому");
        Assertions.assertEquals("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", link.getAttribute("href"), "Атрибут href ссылки не соответствует ожидаемому");
    }

    @Test
    @DisplayName("Проверка выбора 'Услуги связи' в форме оплаты")
    public void testPayConnectionForm() {
        openDropdown();
        WebElement connectionService = findDropdownOption("Услуги связи");
        clickElementWithRetry(connectionService);
    }

    @Test
    @DisplayName("Проверка формы оплаты 'Домашний интернет'")
    public void testPayInternetForm() {
        openDropdown();
        WebElement internetService = findDropdownOption("Домашний интернет");
        clickElementWithRetry(internetService);

        WebElement phoneField = driver.findElement(By.cssSelector("#internet-phone"));
        phoneField.sendKeys("291234567");

        WebElement sumField = driver.findElement(By.cssSelector("#internet-sum"));
        sumField.sendKeys("15");

        WebElement emailField = driver.findElement(By.cssSelector("#internet-email"));
        emailField.sendKeys("internet@example.com");

        WebElement continueButton = driver.findElement(By.cssSelector("#pay-internet button[type='submit']"));
        continueButton.click();
    }

    @Test
    @DisplayName("Проверка формы оплаты 'Рассрочка'")
    public void testPayInstalmentForm() {
        openDropdown();
        WebElement instalmentService = findDropdownOption("Рассрочка");
        clickElementWithRetry(instalmentService);


        WebElement scoreField = driver.findElement(By.cssSelector("#score-instalment"));
        scoreField.sendKeys("1234567890");

        WebElement sumField = driver.findElement(By.cssSelector("#instalment-sum"));
        sumField.sendKeys("20");

        WebElement emailField = driver.findElement(By.cssSelector("#instalment-email"));
        emailField.sendKeys("instalment@example.com");

        WebElement continueButton = driver.findElement(By.cssSelector("#pay-instalment button[type='submit']"));
        continueButton.click();
    }

    @Test
    @DisplayName("Проверка формы оплаты 'Задолженность'")
    public void testPayArrearsForm() {
        openDropdown();
        WebElement arrearsService = findDropdownOption("Задолженность");
        clickElementWithRetry(arrearsService);

        WebElement scoreField = driver.findElement(By.cssSelector("#score-arrears"));
        scoreField.sendKeys("0987654321");

        WebElement sumField = driver.findElement(By.cssSelector("#instalment-sum"));
        sumField.sendKeys("25");

        WebElement emailField = driver.findElement(By.cssSelector("#arrears-email"));
        emailField.sendKeys("arrears@example.com");

        WebElement continueButton = driver.findElement(By.cssSelector("#pay-arrears button[type='submit']"));
        continueButton.click();
    }

    private void openDropdown() {
        try {
            driver.findElement(By.cssSelector(".select__header")).click();
        } catch (Exception e) {
            // Ignore if there is a problem opening dropdown (already open)
        }
    }

    private WebElement findDropdownOption(String optionText) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='select__item']/p[text()='" + optionText + "']")));
    }


    private void clickElementWithRetry(WebElement element) {
        try {
            element.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        }
    }
}
