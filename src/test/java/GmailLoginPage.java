import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.internal.Utils;

import java.io.File;

public class GmailLoginPage extends BasePage {


    public GmailLoginPage(WebDriver driver) {
        super(driver);
    }

    public void goTo(String url)
    {
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
    }

    public boolean login(String name, String password)
    {

        try {
            driver.findElement(By.name("identifier")).sendKeys(name);
            driver.findElement(By.id("identifierNext")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            driver.findElement(By.name("password")).sendKeys(password);
            driver.findElement(By.id("passwordNext")).click();

            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("guser")));



            return true;
        }
        catch (Exception ex)
        {
            return false;
        }



    }
}
