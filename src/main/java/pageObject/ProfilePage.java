package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    WebDriver driver;

    // Кнопка "Профиль"
    private final By profileButton = By.xpath(".//a[text()='Профиль']");

    // Кнопка "Выход"
    private final By exitButton = By.xpath(".//button[text()='Выход']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    // Метод для нажатия на кнопку "Выход"
    public void clickExitButton() {
        driver.findElement(exitButton).click();
    }

    public boolean profileButtonIsEnabled() {
        return driver.findElement(profileButton).isEnabled();
    }
}
