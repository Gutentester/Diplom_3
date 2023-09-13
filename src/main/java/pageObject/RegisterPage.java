package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    // Ссылка "Войти"
    private final By loginLink = By.className("Auth_link__1fOlj");

    // Драйвер
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
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
        driver.findElement(registerButton).click();
    }

    // Метод для ввода данных при регистрации пользователя
    public void setRegisterData(String name, String email, String password) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
    }

    // Метод для клика на ссылку "Войти"
    public void loginLinkClick() {
        driver.findElement(loginLink).click();
    }
}
