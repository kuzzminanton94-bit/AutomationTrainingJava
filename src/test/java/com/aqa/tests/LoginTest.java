package com.aqa.tests;

import com.aqa.pages.InventoryPage;
import com.aqa.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {

    @Test
    void shouldLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(page);

        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(page);

        assertThat(page).hasURL(
                "https://www.saucedemo.com/inventory.html"
        );

        assertThat(inventoryPage.getTitle()).isVisible();
        assertThat(inventoryPage.getInventoryItems()).hasCount(6);
    }

    @Test
    void shouldNotLoginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage(page);

        loginPage.login("standard_user", "wrong_password");

        assertThat(loginPage.getErrorMessage()).isVisible();

        assertThat(loginPage.getErrorMessage()).hasText(
                "Epic sadface: Username and password do not match any user in this service"
        );
    }
}