package org.example.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class Login {

    LoginPage loginPage = new LoginPage();

    @Given("navigating to {string}")
    public void navigatingTo(String url) {
        Hooks.driver.navigate().to(url);
    }


    @And("I enter a valid username {string} and password {string}")
    public void iEnterAValidUsernameAndPassword(String arg0, String arg1) {
        loginPage.enterUserName(arg0);
        loginPage.enterPassword(arg1);
        loginPage.clickLoginButton();
    }


}
