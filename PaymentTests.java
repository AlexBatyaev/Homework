import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;
import java.time.Duration;

public class PaymentTests {

        private WebDriver getDriver() {
                return new ChromeDriver();
    }

    @Test
    public void testPaymentSystemLogos() {
        WebDriver driver = getDriver();
        driver.get("https://www.mts.by/");
        List<WebElement> logos = driver.findElements(By.cssSelector(".pay__partners ul li img"));
        int expectedLogoCount = 5;

        Assertions.assertEquals(expectedLogoCount, logos.size(), "Неверное количество логотипов");

        for (WebElement logo : logos) {
            Assertions.assertNotNull(logo.getAttribute("src"), "У логотипа нет атрибута src");
            Assertions.assertNotNull(logo.getAttribute("alt"), "У логотипа нет атрибута alt");
        }
        driver.quit();
    }
    @Test
    public void testDetailsServiceLink() {
        WebDriver driver = getDriver();
        driver.get("https://www.mts.by/");
        WebElement link = driver.findElement(By.cssSelector(".pay > .pay__wrapper > a"));
        Assertions.assertEquals("Подробнее о сервисе", link.getText(), "Текст ссылки не соответствует ожидаемому");
        Assertions.assertEquals("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", link.getAttribute("href"), "Атрибут href ссылки не соответствует ожидаемому");
        driver.quit();
    }
    @Test
    public void testPayConnectionForm() {
        WebDriver driver = getDriver();
        driver.get("https://www.mts.by/");

                try {
            WebElement acceptCookiesButton = driver.findElement(By.xpath("//button[contains(text(), 'Принять')]"));
            acceptCookiesButton.click();
            Thread.sleep(500);
        } catch (Exception e) {

        }

        try {
            driver.findElement(By.cssSelector(".select__header")).click();
        } catch (Exception e) {
            //
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement connectionService;
        try {
            connectionService = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='select__item']/p[text()='Услуги связи']")));
        } catch (TimeoutException e) {
            System.out.println("Element not found after 10 seconds: " + e.getMessage());
            throw e;
        }

        try {
            connectionService.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            System.out.println("ElementClickInterceptedException: " + e.getMessage());

            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", connectionService);
        }
        driver.quit();
    }
    @Test
    public void testPayInternetForm() {
        WebDriver driver = getDriver();
        driver.get("https://www.mts.by/");


        try {
            WebElement acceptCookiesButton = driver.findElement(By.xpath("//button[contains(text(), 'Принять')]"));
            acceptCookiesButton.click();
            Thread.sleep(500);
        } catch (Exception e) {

        }



        try {
            driver.findElement(By.cssSelector(".select__header")).click();
        } catch (Exception e) {
            //
        }


        WebElement internetService = driver.findElement(By.xpath("//li[@class='select__item']/p[text()='Домашний интернет']"));
        try {
            internetService.click();
        } catch (Exception e) {

            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", internetService);
        }

        WebElement phoneField = driver.findElement(By.cssSelector("#internet-phone"));
        phoneField.sendKeys("291234567");

        WebElement sumField = driver.findElement(By.cssSelector("#internet-sum"));
        sumField.sendKeys("15");

        WebElement emailField = driver.findElement(By.cssSelector("#internet-email"));
        emailField.sendKeys("internet@example.com");


        WebElement continueButton = driver.findElement(By.cssSelector("#pay-internet button[type='submit']"));
        continueButton.click();

        driver.quit();
    }

    @Test
    public void testPayInstalmentForm() {
        WebDriver driver = getDriver();
        driver.get("https://www.mts.by/");


        try {
            driver.findElement(By.cssSelector(".select__header")).click();
        } catch (Exception e) {
            //
        }

        WebElement instalmentService = driver.findElement(By.xpath("//li[@class='select__item']/p[text()='Рассрочка']"));
        instalmentService.click();


        WebElement scoreField = driver.findElement(By.cssSelector("#score-instalment"));
        scoreField.sendKeys("1234567890");

        WebElement sumField = driver.findElement(By.cssSelector("#instalment-sum"));
        sumField.sendKeys("20");

        WebElement emailField = driver.findElement(By.cssSelector("#instalment-email"));
        emailField.sendKeys("instalment@example.com");


        WebElement continueButton = driver.findElement(By.cssSelector("#pay-instalment button[type='submit']"));
        continueButton.click();


        driver.quit();
    }
    @Test
    public void testPayArrearsForm() {
        WebDriver driver = getDriver();
        driver.get("https://www.mts.by/");


        try {
            driver.findElement(By.cssSelector(".select__header")).click();
        } catch (Exception e) {
            //
        }


        WebElement arrearsService = driver.findElement(By.xpath("//li[@class='select__item']/p[text()='Задолженность']"));
        arrearsService.click();


        WebElement scoreField = driver.findElement(By.cssSelector("#score-arrears"));
        scoreField.sendKeys("0987654321");

        WebElement sumField = driver.findElement(By.cssSelector("#instalment-sum"));
        sumField.sendKeys("25");

        WebElement emailField = driver.findElement(By.cssSelector("#arrears-email"));
        emailField.sendKeys("arrears@example.com");


        WebElement continueButton = driver.findElement(By.cssSelector("#pay-arrears button[type='submit']"));
        continueButton.click();


        driver.quit();
    }
}
