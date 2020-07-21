package ui.smoke;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.base.SelenideBase;
import ui.elements.pages.LoginPage;
import ui.elements.pages.WorkflowPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static testResources.TestProperties.getTestProperty;
import static ui.enums.WorkFlowPageData.HEADER;

public class LoginUI extends SelenideBase {

    private LoginPage loginPage;
    private WorkflowPage workflowPage;

    @BeforeMethod
    void beforeMethod() {
        setUpChromeDriverWithDefaultOptions();
        open(getTestProperty("baseUrl"));
        loginPage = page(LoginPage.class);
        workflowPage = page(WorkflowPage.class);
    }

    @AfterMethod
    void afterMethod() {
        driver.close();
    }

    @Test
    void loginPageTest() {
        //check data on login page
        loginPage.checkLoginButtons();

        //login to application
        loginPage.login(getTestProperty("username"), getTestProperty("password"));

//        //check data on workFlow page
//        workflowPage.checkHeader(HEADER.ru);

        //logOut from workFlow page
        workflowPage.logOut();
    }
}
