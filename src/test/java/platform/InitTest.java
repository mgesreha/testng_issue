package platform;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import platform.listeners.CustomListeners;

public class InitTest {

    static Playwright playwright;
    static Browser browser;
    protected Page page;
    protected BrowserContext context;

    @BeforeSuite
    protected static void launchBrowser(){
        CustomListeners.setAcceptedRate(40);
        playwright = Playwright.create();
        browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @BeforeMethod
    protected void createContextAndPage(){
        context = browser.newContext();
        page = browser.newPage();
        page.setViewportSize(1920,1080);
    }

    @AfterMethod
    protected void closeContext() {
        page.close();
        context.close();
    }

    @AfterSuite
    protected static void closeBrowser(){
        playwright.close();
    }
}

