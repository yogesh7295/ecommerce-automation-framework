package com.qa.ecommerce_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.ecommerce_automation.utils.WaitUtils;

public class LoginPage {

    private WebDriver driver;
    private WaitUtils wait;

    private By username = By.xpath("//input[@name='username']");
    private By password = By.xpath("//input[@name='password']");
    private By loginBtn = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void login(String user, String pass) {

        wait.waitForVisibility(username);
        driver.findElement(username).sendKeys(user);

        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
}
