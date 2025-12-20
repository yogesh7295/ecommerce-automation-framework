package com.qa.ecommerce_automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.ecommerce_automation.base.BaseTest;
import com.qa.ecommerce_automation.pages.HomePage;
import com.qa.ecommerce_automation.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLoginFunctionality() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                prop.getProperty("username"),
                prop.getProperty("password")
        );

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(
                homePage.isDashboardDisplayed(),
                "Login failed - Dashboard not visible"
        );
    }
}
