import api.API;
import com.github.javafaker.Faker;
import faker.FakeUser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.LoginPage;
import pageObject.ProfilePage;
import pageObject.StellarBurgerHomePage;
import user.User;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    private WebDriver driver;
    User user;
    Faker faker;
    StellarBurgerHomePage stellarBurgerHomePage;
    LoginPage loginPage;
    ProfilePage profilePage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        stellarBurgerHomePage = new StellarBurgerHomePage(driver);
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
        user = FakeUser.fakeUser();
        stellarBurgerHomePage.personalAccountButtonClick();
        loginPage.logInUser(user);
        Assert.assertTrue(profilePage.profileButtonIsEnabled());
    }
}
