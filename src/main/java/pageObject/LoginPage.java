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
    private final By passwordRecoveryLink = By.xpath(".//a[text()='Восстановить пароль']");

    // Кнопка "Личный кабинет"
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");

    // Кнопка "Конструктор"
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод получения текста в заголовке
    public String getEnterTitleText() {
        return driver.findElement(enterTitle).getText();
    }

    // Метод ввода email в поле Email
    public void setEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    // Метод ввода пароля в поле Password
    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    // Метод ввода логина и пароля на форме авторизации
    public void setLogInData(String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
    }

    // Метод для клика по кнопке "Войти"
    public void loginButtonClick() {
        driver.findElement(loginButton).click();
    }

    // Метод для клика по кнопке "Личный кабинет"
    public void personalAccountButtonClick() {
        driver.findElement(personalAccountButton).click();
    }

    // Метод для клика по ссылке "Восстановить пароль"
    public void passwordRecoveryLinkClick() {
        driver.findElement(passwordRecoveryLink).click();
    }

    // Метод для клика по кнопке "Конструктор"
    public void constructorButtonClick() {
        driver.findElement(constructorButton).click();
    }

    // Метод авторизации юзера. Учетные данные берутся у заданного юзера. Выполняется переход на страницу профиля.
    public void logInUser(User user) {
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        loginButtonClick();
        personalAccountButtonClick();
    }
}