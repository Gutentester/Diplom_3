import api.API;
import faker.FakeUser;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObject.LoginPage;
import pageObject.ProfilePage;
import pageObject.RegisterPage;
import pageObject.StellarBurgerHomePage;
import user.User;
import webdriver.WebdriverSetup;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;

public class RegistrationTest {
    private WebDriver driver;
    User user;
    StellarBurgerHomePage stellarBurgerHomePage;
    RegisterPage registerPage;

    @Before
    public void setUp () {
        driver = WebdriverSetup.getBrowser("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WebdriverSetup.WEBDRIVER_WAIT_TIME, TimeUnit.SECONDS);
        registerPage = new RegisterPage(driver);
        stellarBurgerHomePage = new StellarBurgerHomePage(driver);
        stellarBurgerHomePage.openHomePage();
    }

    @After
    public void tearDown() {
        API.removeUser(API.getToken(user));
        driver.quit();
    }

    @Test
    @DisplayName("Регистрация нового юзера с некорректным паролем")
    public void registrationNewUserWithIncorrectData() {
        user = FakeUser.fakeUserWithShortPassword();
        stellarBurgerHomePage.personalAccountButtonClick();
        registerPage.registerLinkClick();
        registerPage.setRegisterData(user.getName(), user.getEmail(), user.getPassword());
        registerPage.registerButtonClick();
        MatcherAssert.assertThat(registerPage.getInvalidPasswordText(), equalTo("Некорректный пароль"));
    }

    @Test
    @DisplayName("Регистрация нового юзера с корректными данными")
    public void registrationNewUserWithCorrectData() {
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        user = FakeUser.fakeUser();
        stellarBurgerHomePage.personalAccountButtonClick();
        registerPage.registerLinkClick();
        registerPage.setRegisterData(user.getName(), user.getEmail(), user.getPassword());
        registerPage.registerButtonClick();
        MatcherAssert.assertThat(loginPage.getEnterTitleText(), equalTo("Вход"));
        loginPage.logInUser(user);
        Assert.assertTrue(profilePage.profileButtonIsEnabled());
    }
}
