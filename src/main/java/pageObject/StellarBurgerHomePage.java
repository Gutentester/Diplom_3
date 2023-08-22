package pageObject;

import constants.URLs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StellarBurgerHomePage {

    private WebDriver driver;

    // Кнопка "Личный кабинет"
    private final By personalAccountButton = By.xpath(".//p[text() = 'Личный Кабинет']");

    // Кнопка "Войти в аккаунт"
    private final By logInButton = By.xpath(".//button[text() = 'Войти в аккаунт']");

    // Кнопка "Конструктор"
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");

    // Логотип
    private final By logo = By.className("AppHeader_header__logo__2D0X2");

    // Кнопка "Булки"
    private final By bunsButton = By.xpath(".//span[text()='Булки']");

    // Кнопка "Булки" активна
    private final By bunsButtonIsActive = By.xpath(".//div[(contains(@class, 'tab_tab_type_current__2BEPc') and (contains(span/text(),'Булки')))]");

    // Кнопка "Соусы"
    private final By saucesButton = By.xpath(".//span[text()='Соусы']");

    // Кнопка "Соусы" активна
    private final By saucesButtonIsActive = By.xpath(".//div[(contains(@class, 'tab_tab_type_current__2BEPc')) and (contains(span/text(),'Соусы'))]");

    // Кнопка "Начинки"
    private final By fillingsButton = By.xpath(".//span[text()='Начинки']");

    // Кнопка "Начинки" активна
    private final By fillingsButtonIsActive = By.xpath(".//div[(contains(@class, 'tab_tab_type_current__2BEPc')) and (contains(span/text(),'Начинки'))]");

    // Заголовок "Соберите бургер"
    private final By createBurgerTitle = By.xpath(".//h1[text()='Соберите бургер']");

    // Конструктор класса
    public StellarBurgerHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод открытия главной страницы
    public void openHomePage() {
        driver.get(URLs.BASE_URL);
    }

    // Метод для клика по кноке "Личный кабинет"
    public void personalAccountButtonClick() {
        driver.findElement(personalAccountButton).click();
    }

    // Метод для нажатия по кнопке "Войти в аккаунт"
    public void logInButtonClick() {
        driver.findElement(logInButton).click();
    }

    public void logoClick() {
        driver.findElement(logo).click();
    }

    public void constructorButtonClick() {
        driver.findElement(constructorButton).click();
    }

    public void bunsButtonClick() {
        driver.findElement(bunsButton).click();
    }

    public void saucesButtonClick() {
        driver.findElement(saucesButton).click();
    }

    public void fillingsButtonClick() {
        driver.findElement(fillingsButton).click();
    }

    public boolean bunsButtonIsActive() {
        return driver.findElement(bunsButtonIsActive).isEnabled();
    }
    public boolean saucesButtonIsActive() {
        return driver.findElement(saucesButtonIsActive).isEnabled();
    }
    public boolean fillingsButtonIsActive() {
        return driver.findElement(fillingsButtonIsActive).isEnabled();
    }

    public String getCreateBurgerTitleText() {
        return driver.findElement(createBurgerTitle).getText();
    }


}
