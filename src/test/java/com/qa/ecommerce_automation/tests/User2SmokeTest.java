package com.qa.ecommerce_automation.tests;

import org.testng.annotations.Test;
import com.qa.ecommerce_automation.base.BaseTest;

public class User2SmokeTest extends BaseTest {

    @Test
    public void verifyHomePageLoads() {
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
    }
}
