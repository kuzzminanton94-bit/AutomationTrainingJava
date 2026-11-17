import * as allure from 'allure-js-commons';
import { Severity } from 'allure-js-commons';
import { env } from '../../config/env';
import { test, expect } from '../../fixtures/test';
import { expectedInventory, expectedMessages, invalidPassword } from '../../test-data/login';

test.describe('Login', () => {
  test.beforeEach(async () => {
    await allure.epic('Authentication');
    await allure.feature('Login');
  });

  test(
    'should login with valid credentials',
    { tag: '@smoke' },
    async ({ page, loginPage, inventoryPage }) => {
      await allure.description(
        'Standard user logs in and lands on the inventory page showing the product list.',
      );
      await allure.severity(Severity.CRITICAL);
      const { username, password } = env.standardUser;

      await loginPage.login(username, password);

      await expect(page).toHaveURL(new URL(expectedInventory.path, env.baseUrl).toString());
      await expect(inventoryPage.title).toBeVisible();
      await expect(inventoryPage.inventoryItems).toHaveCount(expectedInventory.itemCount);
    },
  );

  test('should not login with invalid password', { tag: '@regression' }, async ({ loginPage }) => {
    await allure.description('Login with a wrong password shows the credentials-mismatch error.');
    await allure.severity(Severity.NORMAL);

    await loginPage.login(env.standardUser.username, invalidPassword);

    await expect(loginPage.errorMessage).toBeVisible();
    await expect(loginPage.errorMessage).toHaveText(expectedMessages.invalidCredentials);
  });
});
