
import api.API;
import faker.FakeUser;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.LoginPage;
import pageObject.ProfilePage;
import pageObject.StellarBurgerHomePage;
import user.User;


import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;

public class LogoutTest {
    private WebDriver driver;
    User user;
    StellarBurgerHomePage stellarBurgerHomePage;
    LoginPage loginPage;
    ProfilePage profilePage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        stellarBurgerHomePage = new StellarBurgerHomePage(driver);
        stellarBurgerHomePage.openHomePage();
        user = FakeUser.fakeUser();
    }

    @After
    public void tearDown() {
        API.removeUser(API.getToken(user));
        driver.quit();
    }

    @Test
    @DisplayName("Выход из аккаунта через личный кабинет")
    public void logoutFromPersonalAccount() {
        stellarBurgerHomePage.personalAccountButtonClick();
        loginPage.logInUser(user);
        profilePage.clickExitButton();
        MatcherAssert.assertThat(loginPage.getEnterTitleText(), equalTo("Вход"));
    }


}