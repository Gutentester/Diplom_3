import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.StellarBurgerHomePage;
import webdriver.WebdriverSetup;

import java.util.concurrent.TimeUnit;

public class ConstructorPageTest {
    private WebDriver driver;
    StellarBurgerHomePage stellarBurgerHomePage;

    @Before
    public void setUp() {
        driver = WebdriverSetup.getBrowser("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        stellarBurgerHomePage = new StellarBurgerHomePage(driver);
        stellarBurgerHomePage.openHomePage();
    }

    @Test
    @DisplayName("Кликаем по вкладке Булки, проверяем, что она активна")
    public void bunsTabSelect() {
        stellarBurgerHomePage.fillingsButtonClick();
        stellarBurgerHomePage.bunsButtonClick();
        Assert.assertTrue(stellarBurgerHomePage.bunsButtonIsActive());
    }

    @Test
    @DisplayName("Кликаем по вкладке Соусы, проверяем, что она активна")
    public void saucesTabSelect() {
        stellarBurgerHomePage.saucesButtonClick();
        Assert.assertTrue(stellarBurgerHomePage.saucesButtonIsActive());
    }

    @Test
    @DisplayName("Кликаем по вкладке Начинки, проверяем, что она активна")
    public void fillingsTabSelect() {
        stellarBurgerHomePage.fillingsButtonClick();
        Assert.assertTrue(stellarBurgerHomePage.fillingsButtonIsActive());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
