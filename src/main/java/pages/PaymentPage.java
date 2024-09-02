package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage {
    private WebDriver driver;

    // Локаторы для элементов
    private By phoneNumberField = By.name("phone");
    private By continueButton = By.xpath("//button[contains(text(), 'Продолжить')]");
    private By amountField = By.name("amount");
    private By errorMessage = By.className("error-message");

    // Локаторы для проверки надписей в незаполненных полях
    private By phoneNumberPlaceholder = By.xpath("//input[@name='phone']/@placeholder");
    private By amountPlaceholder = By.xpath("//input[@name='amount']/@placeholder");

    // Локаторы для различных типов услуг
    private By serviceOption = By.xpath("//label[contains(text(), 'Услуги связи')]");
    private By internetOption = By.xpath("//label[contains(text(), 'Домашний интернет')]");
    private By installmentOption = By.xpath("//label[contains(text(), 'Рассрочка')]");
    private By debtOption = By.xpath("//label[contains(text(), 'Задолженность')]");

    // Локаторы для элементов окна подтверждения
    private By confirmationWindow = By.className("confirmation-window");
    private By confirmationAmount = By.xpath("//div[@class='confirmation-amount']");
    private By confirmationPhone = By.xpath("//div[@class='confirmation-phone']");
    private By cardPlaceholder = By.xpath("//input[@name='card-number']/@placeholder");

    // Локаторы для иконок платёжных систем
    private By paymentIcons = By.xpath("//div[@class='payment-systems']//img");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    // Методы взаимодействия с элементами
    public void selectServiceOption() {
        driver.findElement(serviceOption).click();
    }

    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void enterAmount(String amount) {
        driver.findElement(amountField).sendKeys(amount);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public String getPhoneNumberPlaceholder() {
        return driver.findElement(phoneNumberPlaceholder).getAttribute("placeholder");
    }

    public String getAmountPlaceholder() {
        return driver.findElement(amountPlaceholder).getAttribute("placeholder");
    }

    public boolean isConfirmationWindowDisplayed() {
        return driver.findElement(confirmationWindow).isDisplayed();
    }

    public String getConfirmationAmount() {
        return driver.findElement(confirmationAmount).getText();
    }

    public String getConfirmationPhone() {
        return driver.findElement(confirmationPhone).getText();
    }

    public String getCardPlaceholder() {
        return driver.findElement(cardPlaceholder).getAttribute("placeholder");
    }

    public boolean arePaymentIconsDisplayed() {
        return driver.findElements(paymentIcons).size() > 0;
    }
}
