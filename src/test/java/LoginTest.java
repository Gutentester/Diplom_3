import api.API;
import faker.FakeUser;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObject.*;
import user.User;
import webdriver.WebdriverSetup;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;

public class LoginTest {

    private WebDriver driver;
    User user;
    StellarBurgerHomePage stellarBurgerHomePage;
    ProfilePage profilePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    PasswordRecoveryPage passwordRecoveryPage;

    @Before
    public void setUp() {
        driver = WebdriverSetup.getBrowser("Yandex");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WebdriverSetup.WEBDRIVER_WAIT_TIME, TimeUnit.SECONDS);
        user = FakeUser.fakeUser();
        stellarBurgerHomePage = new StellarBurgerHomePage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        registerPage = new RegisterPage(driver);
        passwordRecoveryPage = new PasswordRecoveryPage(driver);
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
        registerPage.registerLinkClick();
        registerPage.setRegisterData(user.getName(), user.getEmail(), user.getPassword());
        registerPage.registerButtonClick();
        MatcherAssert.assertThat(loginPage.getEnterTitleText(), equalTo("Вход"));
        loginPage.logInUser(user);
        Assert.assertTrue(profilePage.profileButtonIsEnabled());
    }

    @Test
    @DisplayName("Вход через кнопку Личный кабинет")
    public void loginFromPersonalAccountPage() {
        stellarBurgerHomePage.personalAccountButtonClick();
        registerPage.registerLinkClick();
        registerPage.setRegisterData(user.getName(), user.getEmail(), user.getPassword());
        registerPage.registerButtonClick();
        MatcherAssert.assertThat(loginPage.getEnterTitleText(), equalTo("Вход"));
        loginPage.logInUser(user);
        Assert.assertTrue(profilePage.profileButtonIsEnabled());
    }

    @Test
    @DisplayName("Вход через форму регистрации")
    public void loginFromRegistrationPage() {
        stellarBurgerHomePage.personalAccountButtonClick();
        registerPage.registerLinkClick();
        registerPage.setRegisterData(user.getName(), user.getEmail(), user.getPassword());
        registerPage.registerButtonClick();
        MatcherAssert.assertThat(loginPage.getEnterTitleText(), equalTo("Вход"));
        loginPage.logInUser(user);
        Assert.assertTrue(profilePage.profileButtonIsEnabled());
    }

    @Test
    @DisplayName("Вход через форму восстановления пароля")
    public void loginFromPasswordRecoveryPage() {
        stellarBurgerHomePage.personalAccountButtonClick();
        registerPage.registerLinkClick();
        registerPage.setRegisterData(user.getName(), user.getEmail(), user.getPassword());
        registerPage.registerButtonClick();
        MatcherAssert.assertThat(loginPage.getEnterTitleText(), equalTo("Вход"));
        loginPage.logInUser(user);
        profilePage.clickExitButton();
        loginPage.passwordRecoveryLinkClick();
        passwordRecoveryPage.LogInButtonClick();
        loginPage.logInUser(user);
        Assert.assertTrue(profilePage.profileButtonIsEnabled());
    }
}
