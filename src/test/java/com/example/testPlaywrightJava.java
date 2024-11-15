package com.example;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class testPlaywrightJava {

    static Playwright playwright;
    static Browser browser;

    @BeforeAll
    public static void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
    }

    @AfterAll
    public static void tearDown() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }

    @Test
    public void testTitle() {
        Page page = browser.newPage();
        page.navigate("https://www.example.com");
        String title = page.title();
        assertTrue(title.contains("Example Domain"));
        page.close();
    }

    @Test
    public void testSomeOtherFeature() {
        // Adicione outros testes aqui
        assertTrue(true); // Exemplo de teste simples
    }
}
