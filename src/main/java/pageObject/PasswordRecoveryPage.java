package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {

    WebDriver driver;

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Кнопка "Войти"
    private final By logInButton = By.className("Auth_link__1fOlj");

    // Клик по кнопке "Войти"
    public void LogInButtonClick() {
        driver.findElement(logInButton).click();
    }
}
