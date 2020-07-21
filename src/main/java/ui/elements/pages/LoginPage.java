package ui.elements.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import ui.elements.base.BasePage;

import static com.codeborne.selenide.Condition.text;
import static ui.enums.LoginPageData.*;

public class LoginPage extends BasePage {

    @FindBy(css = "#username")
    private SelenideElement usernameInput;

    @FindBy(css = "#password")
    private SelenideElement passwordInput;

    @FindBy(css = "#login_button")
    private SelenideElement loginButton;

    @FindBy(css = "#remember")
    private SelenideElement rememberCheckbox;

    @FindBy(css = ".header > .login_corp")
    private SelenideElement headerLoginTitle;

    @FindBy(css = "#login_button_domain")
    private SelenideElement loginButtonDomain;

    @FindBy(css = "#login_button_current")
    private SelenideElement loginButtonCurrent;

    @Step("Login in GreenData")
    public void login(String username, String password) {
        usernameInput.click();
        usernameInput.setValue(username);
        passwordInput.click();
        passwordInput.setValue(password);
        rememberCheckbox.click();
        loginButton.click();
    }

    @Step("Check login buttons text")
    public void checkLoginButtons() {
        loginButton.shouldHave(text(LOGIN_BUTTON.ru));
        loginButtonDomain.shouldHave(text(LOGIN_BUTTON_DOMAIN.ru));
        loginButtonCurrent.shouldHave(text(LOGIN_BUTTON_CURRENT.ru));
    }
}
