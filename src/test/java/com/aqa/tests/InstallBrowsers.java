package com.aqa.tests;

import com.microsoft.playwright.CLI;

import java.io.IOException;
import java.net.URISyntaxException;

public class InstallBrowsers {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        CLI.main(new String[]{"install", "chromium"});
    }
}