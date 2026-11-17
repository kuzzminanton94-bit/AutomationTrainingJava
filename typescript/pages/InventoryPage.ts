import type { Locator, Page } from '@playwright/test';

export class InventoryPage {
  readonly title: Locator;
  readonly inventoryItems: Locator;

  constructor(page: Page) {
    this.title = page.locator("[data-test='title']");
    this.inventoryItems = page.locator("[data-test='inventory-item']");
  }
}
