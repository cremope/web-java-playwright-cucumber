package steps;

import com.microsoft.playwright.*;
import config.ConfigLoader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ScreenshotUtil;

public class Hooks {
    private static Playwright playwright;
    private static Browser browser;
    private static Page page;

    @Before(order = 0)
    public void setup() {
        playwright = Playwright.create();
        boolean headlessMode = ConfigLoader.isHeadless();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(headlessMode)
                .setSlowMo(150)
        );
        page = browser.newPage();
    }

    @After
    public void teardown(Scenario scenario) {
        ScreenshotUtil.capturarEAnexar(page, "Evidencia_" + scenario.getName());

        if (page != null) {
            page.close();
            browser.close();
            playwright.close();
        }
    }

    public static Page getPage() {
        return page;
    }
}