import 'dotenv/config';

function required(name: string): string {
  const value = process.env[name];
  if (!value) {
    throw new Error(`Missing required environment variable: ${name} (see .env.example)`);
  }
  return value;
}

export const env = {
  baseUrl: process.env.BASE_URL ?? 'https://www.saucedemo.com/',
  headless: (process.env.HEADLESS ?? 'false').toLowerCase() === 'true',
  /** Resolved lazily so tests that don't need credentials don't fail on import. */
  get standardUser(): { username: string; password: string } {
    return { username: required('STANDARD_USER'), password: required('STANDARD_PASSWORD') };
  },
} as const;
