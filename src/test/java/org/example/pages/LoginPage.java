package org.example.pages;

import org.example.Steps.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {


    WebDriver driver;
    By usernameInputLocator = By.xpath("//input[@name='username']");
    By passwordInputLocator = By.xpath("//input[@name='password']");
    By loginButtonLocator = By.xpath("//button[@type='submit']");


    public void waitForElementToAppear(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void enterUserName(String username) {

        WebElement emailInput = Hooks.driver.findElement(usernameInputLocator);
        emailInput.sendKeys(username);
    }
    public void enterPassword(String password) {

        WebElement passwordInput = Hooks.driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }
    public void clickLoginButton() {
        Hooks.driver.findElement(loginButtonLocator).click();
    }


}
