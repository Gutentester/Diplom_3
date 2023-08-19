package pageObject;

import com.google.gson.annotations.Until;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

import static junit.framework.TestCase.assertEquals;

public class RegisterPage {

    WebDriver driver;

    // Инпут "Имя"
    private By nameInput = By.xpath("//label[.='Имя']/../input");

    // Инпут "Email"
    private By emailInput = By.xpath("//label[.='Email']/../input");

    // Инпут "Пароль"
    private By passwordInput = By.name("Пароль");

    // Кнопка "Зарегистрироваться"
    private By registerButton = By.xpath(".//button[text() = 'Зарегистрироваться']");

    // Ссылка "Зарегистрироваться"
    private By registerLink = By.className("Auth_link__1fOlj"); //By.name(".//a[text() = 'Зарегистрироваться']");

    // Ошибка "Некорректный пароль"
    private By invalidPasswordError = By.xpath(".//p[text()='Некорректный пароль']");

    // Заголовок "Вход" на форме авторизации
    private By titleEnter = By.xpath("//h2[.='Вход']");


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод проверки текста в заголовке
    public void assertTitleEnterText(String text) {
        String actualTitle = driver.findElement(titleEnter).getText();
        String expectedTitle = text;
        assertEquals("Текст заголовка отличается от ожидаемого", actualTitle, expectedTitle);
    }

    // Метод получения текста ошибки некорректного пароля
    public String getInvalidPasswordText() {
        return driver.findElement(invalidPasswordError).getText();
    }

    // Метод для нажатия ссылки "Зарегистрироваться"
    public void registerLinkClick() {
        driver.findElement(registerLink).isDisplayed();
        driver.findElement(registerLink).click();
    }

    // Метод нажатия на кнопку "Зарегистрироваться"
    public void registerButtonClick() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(registerButton));
        driver.findElement(registerButton).click();
    }

    // Метод для ввода данных регистрации
    public void setRegisterData(String name, String email, String password) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void setName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void setEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }
}
