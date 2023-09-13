package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebdriverSetup {
    public static final long WEBDRIVER_WAIT_TIME = 15;
    public static WebDriver getBrowser(String browser) {

        switch (browser) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
                return new ChromeDriver();

            case "Yandex":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/yandexdriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:/Users/Gutentester/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
                return new ChromeDriver(options);

            default:
                throw new RuntimeException("Название браузера некорректно");
        }
    }
}