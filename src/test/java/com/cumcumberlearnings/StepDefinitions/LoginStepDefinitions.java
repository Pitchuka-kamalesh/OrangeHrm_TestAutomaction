package com.cumcumberlearnings.StepDefinitions;

import com.cumcumberlearnings.pageObject.loginPage;
import com.cumcumberlearnings.Common.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginStepDefinitions extends BaseClass {

    loginPage login;


    @Given("I have enter {string} and {string}")
    public void iHaveEnterAnd(String username, String password) throws InterruptedException {
        login = new loginPage(driver);
        login.enterUsername(username);
        login.enterPassword(password);
    }

    @When("I click on the login button")
    public void iClickOnTheLoginButton() {

        login.clickLogin();

    }

    @Then("It should show an error message indicating {string} and {string}")
    public void itShouldShowAnErrorMessageIndicating(String message,String type) {
        String error = login.validate_Error_Cred(type);
        Assert.assertEquals(message,error);

    }




}
