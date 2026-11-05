package com.aqa.core;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

import com.aqa.config.Config;
import com.aqa.config.BrowserType;

public class BrowserFactory {

    public static Browser createBrowser(
            Playwright playwright,
            BrowserType browserType
    ) {

        LaunchOptions options = new LaunchOptions()
                .setHeadless(Config.isHeadless())
                .setArgs(java.util.List.of("--start-maximized"));

        return switch (browserType) {
            case CHROMIUM -> playwright.chromium().launch(options);
            case FIREFOX -> playwright.firefox().launch(options);
            case WEBKIT -> playwright.webkit().launch(options);
        };
    }
}