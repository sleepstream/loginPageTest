package ui.elements.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import ui.elements.base.BasePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class WorkflowPage extends BasePage {

    @FindBy(css = "head > title")
    private SelenideElement workFlowTitle;

    @FindBy(css = ".username-wrapper")
    private SelenideElement userMenu;

    @FindBy(css = ".user-menu-dropdown > div > ul > li:last-child")
    private SelenideElement logOut;

    @Step("Check header")
    public void checkHeader(String text) {
        workFlowTitle.shouldBe(visible);
        workFlowTitle.shouldHave(text(text));
    }

    @Step("Logout")
    public void logOut() {
        userMenu.shouldBe(visible);
        userMenu.click();
        logOut.click();
    }
}
