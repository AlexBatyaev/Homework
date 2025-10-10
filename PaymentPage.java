import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PaymentPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = ".select__header")
    private WebElement paymentTypeDropdownHeader;

    @FindBy(xpath = "//ul[@class='select__list']/li/p[@class='select__option']")
    private List<WebElement> paymentTypeDropdownOptions;

    @FindBy(xpath = "//button[contains(text(), 'Принять')]")
    private WebElement acceptCookiesButton;


    @FindBy(id = "connection-phone")
    private WebElement connectionPhoneInput;

    @FindBy(id = "connection-sum")
    private WebElement connectionSumInput;

    @FindBy(id = "connection-email")
    private WebElement connectionEmailInput;

    @FindBy(css = "#pay-connection button[type='submit']")
    private WebElement connectionSubmitButton;


    @FindBy(id = "internet-phone")
    private WebElement internetPhoneInput;

    @FindBy(id = "internet-sum")
    private WebElement internetSumInput;

    @FindBy(id = "internet-email")
    private WebElement internetEmailInput;

    @FindBy(css = "#pay-internet button[type='submit']")
    private WebElement internetSubmitButton;


    @FindBy(id = "score-instalment")
    private WebElement instalmentScoreInput;

    @FindBy(id = "instalment-sum")
    private WebElement instalmentSumInput;

    @FindBy(id = "instalment-email")
    private WebElement instalmentEmailInput;

    @FindBy(css = "#pay-instalment button[type='submit']")
    private WebElement instalmentSubmitButton;



    @FindBy(id = "score-arrears")
    private WebElement arrearsScoreInput;

    @FindBy(id = "arrears-sum")
    private WebElement arrearsSumInput;

    @FindBy(id = "arrears-email")
    private WebElement arrearsEmailInput;

    @FindBy(css = "#pay-arrears button[type='submit']")
    private WebElement arrearsSubmitButton;


    @FindBy(css = ".pay > .pay__wrapper > a")
    private WebElement detailsServiceLink;


    @FindBy(css = ".pay__partners ul li img")
    private List<WebElement> paymentSystemLogos;



    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void acceptCookies() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton)).click();
        } catch (org.openqa.selenium.TimeoutException e) {
                        System.out.println("Кнопка принятия куки не найдена.");
        }
    }




    public void selectPaymentType(String paymentType) {
        paymentTypeDropdownHeader.click();

        for (WebElement option : paymentTypeDropdownOptions) {
            if (option.getText().equals(paymentType)) {

                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", option);
                break;
            }
        }
        wait.until(ExpectedConditions.textToBePresentInElement(paymentTypeDropdownHeader, paymentType));
    }

    public void enterConnectionPhone(String phone) {
        connectionPhoneInput.sendKeys(phone);
    }

    public void enterConnectionSum(String sum) {
        connectionSumInput.sendKeys(sum);
    }

    public void enterConnectionEmail(String email) {
        connectionEmailInput.sendKeys(email);
    }

    public void clickConnectionSubmitButton() {
        connectionSubmitButton.click();
    }

    public String getConnectionPhonePlaceholder() {
        return connectionPhoneInput.getAttribute("placeholder");
    }

    public String getConnectionSumPlaceholder() {
        return connectionSumInput.getAttribute("placeholder");
    }

    public String getConnectionEmailPlaceholder() {
        return connectionEmailInput.getAttribute("placeholder");
    }


    public void enterInternetPhone(String phone) {
        internetPhoneInput.sendKeys(phone);
    }

    public void enterInternetSum(String sum) {
        internetSumInput.sendKeys(sum);
    }

    public void enterInternetEmail(String email) {
        internetEmailInput.sendKeys(email);
    }

    public void clickInternetSubmitButton() {
        internetSubmitButton.click();
    }


    public void enterInstalmentScore(String score) {
        instalmentScoreInput.sendKeys(score);
    }
    public void enterInstalmentSum(String sum) {
        instalmentSumInput.sendKeys(sum);
    }

    public void enterInstalmentEmail(String email) {
        instalmentEmailInput.sendKeys(email);
    }

    public void clickInstalmentSubmitButton() {
        instalmentSubmitButton.click();
    }



    public void enterArrearsScore(String score) {
        arrearsScoreInput.sendKeys(score);
    }

    public void enterArrearsSum(String sum) {
        arrearsSumInput.sendKeys(sum);
    }

    public void enterArrearsEmail(String email) {
        arrearsEmailInput.sendKeys(email);
    }

    public void clickArrearsSubmitButton() {
        arrearsSubmitButton.click();
    }

    public String getDetailsServiceLinkText() {
        return detailsServiceLink.getText();
    }

    public String getDetailsServiceLinkHref() {
        return detailsServiceLink.getAttribute("href");
    }

    public int getPaymentSystemLogosCount() {
        return paymentSystemLogos.size();
    }

    public String getPaymentSystemLogoSrc(int index) {
        return paymentSystemLogos.get(index).getAttribute("src");
    }

    public String getPaymentSystemLogoAlt(int index) {
        return paymentSystemLogos.get(index).getAttribute("alt");
    }


}
