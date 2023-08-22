import api.API;
import faker.FakeUser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.*;
import user.User;
import webdriver.WebdriverSetup;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    private WebDriver driver;
    User user;
    StellarBurgerHomePage stellarBurgerHomePage;
    LoginPage loginPage;
    ProfilePage profilePage;
    RegisterPage registerPage;
    PasswordRecoveryPage passwordRecoveryPage;

    @Before
    public void setUp() {
        driver = WebdriverSetup.getBrowser();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WebdriverSetup.WEBDRIVER_WAIT_TIME, TimeUnit.SECONDS);
        stellarBurgerHomePage = new StellarBurgerHomePage(driver);
        loginPage = new LoginPage(driver);
        user = FakeUser.fakeUser();
        stellarBurgerHomePage.openHomePage();
    }

    @After
    public void tearDown() {
        API.removeUser(API.getToken(user));
        driver.quit();
    }

    @Test
    @DisplayName("Вход с главной страницы")
    public void loginFromHomePage() {
        stellarBurgerHomePage.logInButtonClick();
        loginPage.logInUser(user);
        Assert.assertTrue(profilePage.profileButtonIsEnabled());
    }

    @Test
    @DisplayName("Вход через кнопку Личный кабинет")
    public void loginFromPersonalAccountPage() {
        stellarBurgerHomePage.personalAccountButtonClick();
        loginPage.logInUser(user);
        Assert.assertTrue(profilePage.profileButtonIsEnabled());
    }

    @Test
    @DisplayName("Вход через форму регистрации")
    public void loginFromRegistrationPage() {
        registerPage = new RegisterPage(driver);
        stellarBurgerHomePage.personalAccountButtonClick();
        registerPage.registerLinkClick();
        registerPage.loginLinkClick();
        loginPage.logInUser(user);
        Assert.assertTrue(profilePage.profileButtonIsEnabled());
    }

    @Test
    @DisplayName("Вход через форму восстановления пароля")
    public void loginFromPasswordRecoveryPage() {
        passwordRecoveryPage = new PasswordRecoveryPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        stellarBurgerHomePage.personalAccountButtonClick();
        loginPage.passwordRecoveryLinkClick();
        passwordRecoveryPage.LogInButtonClick();
        loginPage.logInUser(user);
        Assert.assertTrue(profilePage.profileButtonIsEnabled());
    }
}
