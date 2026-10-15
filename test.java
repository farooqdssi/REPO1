import { test, expect } from '@playwright/test';

test('JMS Login with username and password', async ({ page }) => {
  // Open JMS application
  await page.goto(process.env.JMS_URL!);

  // Enter login credentials
  await page.getByLabel(/username/i).fill(process.env.JMS_USERNAME!);
  await page.getByLabel(/password/i).fill(process.env.JMS_PASSWORD!);

  // Click Login
  await page.getByRole('button', { name: /login|sign in/i }).click();

  // Verify successful login
  await expect(page.getByText(/dashboard/i)).toBeVisible();
});
