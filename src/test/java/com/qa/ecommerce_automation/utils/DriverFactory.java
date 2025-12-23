package com.qa.ecommerce_automation.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    // ThreadLocal for parallel execution (future ready)
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /**
     * Initialize WebDriver based on browser
     */
    public static WebDriver initDriver(String browser) {

        System.out.println(">>> Initializing browser: " + browser);

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

            // Disable automation infobar
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-notifications");
            options.addArguments("--start-maximized");

            // OPTIONAL (for CI) – keep commented for local
            // options.addArguments("--headless=new");

            tlDriver.set(new ChromeDriver(options));

        } else {
            throw new RuntimeException("Browser not supported: " + browser);
        }

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        return getDriver();
    }

    /**
     * Get WebDriver instance
     */
    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    /**
     * Quit WebDriver safely
     */
    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            tlDriver.remove();
        }
    }
}
