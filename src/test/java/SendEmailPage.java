import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SendEmailPage extends BasePage {
    public SendEmailPage(WebDriver driver) {
        super(driver);
    }

    public void goTo(String url)
    {
        driver.get(url);
        wait.until(ExpectedConditions.titleContains("Gmail - Compose Mail"));
    }

    public boolean testSendEmail(String toName, String Subject, String bodyMessage)
    {
        driver.findElement(By.name("to")).sendKeys(toName);

        driver.findElement(By.name("subject")).sendKeys(Subject);

        driver.findElement(By.name("body")).sendKeys(bodyMessage);

        driver.findElement(By.name("nvp_bu_send")).click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[role=alert]")));

        WebElement  alert = driver.findElement(By.cssSelector("[role=alert]"));



        return alert.getAttribute("innerHTML").toLowerCase().contains("Your message has been sent".toLowerCase());
    }
}
