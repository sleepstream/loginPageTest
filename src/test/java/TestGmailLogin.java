
import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

@Listeners({ OnFailure.class })
public class TestGmailLogin  extends BaseTest{

    static String nodeUrl= "http://localhost:4444/wd/hub";
    String url = "https://mail.google.com/mail/h/bob81gxiqnlc/";
    String urlSendEmail ="https://mail.google.com/mail/u/0/h/1ks5kcrvhx7fg/?&cs=b&pv=tl&v=b";
    private String searchString="from:\"Филинин Илья\"";
    private String login = "testaccaristov@gmail.com";
    private String password = "123456789@#";

    public Integer countSearch = null;

    private String toEmail = "ilya.filinin@simbirsoft.com";


    @Test(description="Try to log in to e-mail box")
    public void testLogin()
    {
        log.info("Log step 1: go to login page");
            GmailLoginPage gmailLoginPage = new GmailLoginPage(driver);
            gmailLoginPage.goTo(url);
            boolean result = gmailLoginPage.login(login, password);
            Assert.assertTrue(result);
    }

    @Test(description="Try find e-mails in box")
    public void testSearch()
    {
        log.info("Log step 1: enter search text");
        SearchEmailPage searchEmailPage = new SearchEmailPage(driver);
        searchEmailPage.goTo(url);
        countSearch = searchEmailPage.testSearch(searchString);
        Assert.assertTrue(countSearch>0);
    }


    @Test(description="Try to create and send e-mail")
    public void testSendEmail()
    {
        log.info("Log step 1: create e-mail");
        SendEmailPage sendEmailPage = new SendEmailPage(driver);
        sendEmailPage.goTo(urlSendEmail);
        String bodyMessage="Результат поиска писем по запросу: "+searchString+"\n" + countSearch+ "\n" +
                            "Данное письмо создано автоматически с использованием Selenium GRID + WebDriver\n" +
                            "Исходный код по ссылке:\n" +
                            "https://github.com/sleepstream/GmailSearch-Send-Test";
        boolean sendResult = sendEmailPage.testSendEmail(toEmail, "Тестовое задание. <Аристов>", bodyMessage);

        Assert.assertTrue(sendResult);
    }
}
