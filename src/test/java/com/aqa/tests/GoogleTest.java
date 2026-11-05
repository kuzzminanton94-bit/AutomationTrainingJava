package com.aqa.tests;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GoogleTest extends BaseTest {

    @Test
    void shouldOpenGoogle() {
        page.navigate("https://www.google.com");

        assertThat(page.title()).contains("Google");
    }
}