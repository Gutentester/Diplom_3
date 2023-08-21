package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class LoginPage {

    private WebDriver driver;

    // Заголовок "Вход" на форме авторизации
    private By enterTitle = By.xpath(".//h2[text()='Вход']");

    // Инпут "Email"
    private final By emailInput = By.xpath(".//label[text()='Email']/../input");

    // Инпут "Пароль"
    private final By passwordInput = By.xpath(".//label[text()='Пароль']/../input");

    // Кнопка "Войти"
    private final By loginButton = By.xpath(".//button[text()='Войти']");

    // Ссылка "Восстановить пароль"
    private final By passwordRecoveryButton = By.xpath(".//a[text()='Восстановить пароль']");

    //Кнопка "Личный кабинет"
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод получения текста в заголовке
    public String getEnterTitleText() {
        return driver.findElement(enterTitle).getText();
    }

    public void setEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void setLogInData(String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void loginButtonClick() {
        driver.findElement(loginButton).click();
    }

    public void personalAccountButtonClick() {
        driver.findElement(personalAccountButton).click();
    }

    public void logInUser(User user) {
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        loginButtonClick();
        personalAccountButtonClick();
    }
}