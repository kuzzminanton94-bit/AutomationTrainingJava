package com.aqa.tests;

import com.aqa.config.Config;
import com.aqa.core.BrowserFactory;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeEach
    void setUp() {
        playwright = Playwright.create();

        browser = BrowserFactory.createBrowser(
                playwright,
                Config.getBrowserType()
        );

        context = browser.newContext(
                new Browser.NewContextOptions()
                        .setViewportSize(null)
        );

        page = context.newPage();
        page.navigate("https://www.saucedemo.com/",
                new Page.NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED)
                );
    }

    @AfterEach
    void tearDown() {
        playwright.close();
    }
}