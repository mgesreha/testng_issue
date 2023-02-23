package platform.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Step;

public class LoginPage {
    private final Page page;
    private Locator userNameLocator;
    private Locator passwordLocator;
    private Locator loginButton;

    public LoginPage(Page page) {
        this.page = page;
        userNameLocator = this.page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("username"));
        passwordLocator = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("password"));
        loginButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("login"));
    }

    @Step
    public LoginPage navigate(){
        page.navigate("https://platform.dev.happysurgeon.com/");
        return this;
    }

    @Step("Login")
    public HomePage login(String userName, String password){
        userNameLocator.fill(userName);
        passwordLocator.fill(password);
        loginButton.click();
        return new HomePage(page);
    }
}