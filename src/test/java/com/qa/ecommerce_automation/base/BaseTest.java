package com.qa.ecommerce_automation.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.ecommerce_automation.utils.ConfigReader;
import com.qa.ecommerce_automation.utils.DriverFactory;

public class BaseTest {

    protected WebDriver driver;
    protected Properties prop;

    @BeforeMethod
    public void setup() {

        // Load config.properties
        prop = ConfigReader.initProperties();

        // Initialize browser using DriverFactory
        driver = DriverFactory.initDriver(prop.getProperty("browser"));

        // Launch application URL
        driver.get(prop.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {

        // Quit browser safely
        DriverFactory.quitDriver();
    }
}
