import io.qameta.allure.Attachment;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BaseTest  {
    protected static WebDriver driver;
    protected Logger log = Logger.getLogger(this.getClass());

    @Parameters({ "selenium.browser"})
    @BeforeTest
    public void setUp(@Optional("Chrome") String browserName) throws MalformedURLException {
        PropertyConfigurator.configure(getClass().getResource("log4j.properties"));


        driver = BrowserFactory.getBrowser(browserName);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        log.info("------ Start ------");
    }

    @Attachment
    public static byte[] makeScreenshot() {
        if(driver!=null)
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        return null;
    }

    @AfterTest
    public void shutDown() {
        driver.quit();
        log.info("Driver shut down");
    }
}