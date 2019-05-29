import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchEmailPage extends BasePage {



    public SearchEmailPage(WebDriver driver) {
        super(driver);
    }


    public void goTo(String url)
    {
        driver.get(url);
        wait.until(ExpectedConditions.titleContains("Gmail - Inbox"));

    }

    public int testSearch(String searcString)
    {
        WebElement searcField = driver.findElement(By.tagName("table")).findElement(By.tagName("table")).findElement(By.name("q"));
        searcField.sendKeys(searcString);
        driver.findElement(By.tagName("table")).findElement(By.tagName("table")).findElement(By.name("nvp_site_mail")).click();
        wait.until(ExpectedConditions.titleContains(searcString));

        List<WebElement> results = driver.findElement(By.name("f")).findElement(By.className("th")).findElements(By.tagName("tr"));
        int count = results.size();
        //check find elements for not empty line
        for(WebElement webElement : results)
        {
            try {
                webElement.findElement(By.tagName("input"));
            }
            catch(Exception ex)
            {
                count--;
            }
        }


        return count;
    }
}
