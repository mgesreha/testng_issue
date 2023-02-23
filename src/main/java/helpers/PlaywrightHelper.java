package helpers;

import com.microsoft.playwright.*;

public class PlaywrightHelper {

    static Playwright playwright;
    static Browser browser;
    Page page;
    BrowserContext browserContext;


    static void launchBrowser(){
        playwright = Playwright.create();
        browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }


    static void closeBrowser(){
        playwright.close();
    }

//    @BeforeMethod
    void createContextAndPage(){
        browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920,1080));
        page = browserContext.newPage();
    }

//    @AfterMethod
    void closeContext() {
        browserContext.close();
    }
}
