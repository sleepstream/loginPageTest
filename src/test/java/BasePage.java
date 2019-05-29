import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

public class BasePage {

    protected WebDriver driver;
    protected Logger log = Logger.getLogger(this.getClass());

    WebDriverWait wait;



    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait =   new WebDriverWait(driver, 60);;
    }

    public  boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
