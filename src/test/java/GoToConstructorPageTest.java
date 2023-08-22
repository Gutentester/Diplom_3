import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObject.LoginPage;
import pageObject.StellarBurgerHomePage;
import webdriver.WebdriverSetup;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;

public class GoToConstructorPageTest {

    private WebDriver driver;
    StellarBurgerHomePage stellarBurgerHomePage;
    LoginPage loginPage;

    @Before
    public void setUp () {
        driver = WebdriverSetup.getBrowser();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WebdriverSetup.WEBDRIVER_WAIT_TIME, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        stellarBurgerHomePage = new StellarBurgerHomePage(driver);
        stellarBurgerHomePage.openHomePage();
    }

    @Test
    @DisplayName("Переход к конструктору по кнопке Конструктор")
    public void goToConstructorPageByConstructorButton() {
        stellarBurgerHomePage.personalAccountButtonClick();
        loginPage.constructorButtonClick();
        MatcherAssert.assertThat(stellarBurgerHomePage.getCreateBurgerTitleText(), equalTo("СОберите бургер"));
    }

    @Test
    @DisplayName("Переход к конструктору по кнопке Конструктор")
    public void goToConstructorPageByLogo() {
        stellarBurgerHomePage.personalAccountButtonClick();
        stellarBurgerHomePage.logoClick();
        MatcherAssert.assertThat(stellarBurgerHomePage.getCreateBurgerTitleText(), equalTo("СОберите бургер"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
