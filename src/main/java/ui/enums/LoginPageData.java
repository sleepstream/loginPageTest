package ui.enums;

public enum LoginPageData {
    LOGIN_BUTTON("Войти", ""),
    LOGIN_BUTTON_DOMAIN("Войти (другая учетная запись)", ""),
    LOGIN_BUTTON_CURRENT("Войти (текущая учетная запись)", "");

    public String ru;
    public String en;

    LoginPageData(String ru, String en) {
        this.ru = ru;
        this.en = en;
    }
}
