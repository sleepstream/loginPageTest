package ui.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import testResources.listeners.SelenideListener;

import static testResources.TestProperties.getTestPropertyInteger;

public abstract class SelenideBase {

    public WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        SelenideLogger.addListener("allure", new SelenideListener());
    }

    //create chromeDriver with default options
    public void setUpChromeDriverWithDefaultOptions() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--lang=ru_RU.UTF8");
        options.addArguments("--window-size=1200,768");
        //options.addArguments("--headless");
        Configuration.timeout = 30000;
        driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
    }
}