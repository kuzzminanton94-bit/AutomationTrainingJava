package com.aqa.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class InventoryPage {

    private final Locator title;
    private final Locator inventoryItems;

    public InventoryPage(Page page) {
        title = page.locator("[data-test='title']");
        inventoryItems = page.locator("[data-test='inventory-item']");
    }

    public Locator getTitle() {
        return title;
    }

    public Locator getInventoryItems() {
        return inventoryItems;
    }
}