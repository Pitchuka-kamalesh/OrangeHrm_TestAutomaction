package com.cumcumberlearnings.StepDefinitions;

import com.cumcumberlearnings.pageObject.forgotPassword;
import com.cumcumberlearnings.pageObject.loginPage;
import com.cumcumberlearnings.Common.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class resetpasswordStepDefinitions extends BaseClass {

    loginPage login;
    forgotPassword forgotpassword;

    @Given("I am on the Orange HRM login pages")
    public void iAmOnTheOrangeHRMLoginPages() {
        String title = driver.getTitle();
        Assert.assertEquals("OrangeHRM",title);

    }
    @And("Click on the forgot password")
    public void click_On_The_ForgotPassword() {
        forgotpassword = new forgotPassword(driver);
        forgotpassword.clickForgotPassword();

    }
    @And("Enter the username {string}")
    public void enter_The_Username(String username) {
        login = new loginPage(driver);
        login.enterUsername(username);
    }

    @When("I click on the ResetPassword button")
    public void i_ClickOn_TheResetPassword_Button() {
        forgotpassword.clickResetPasswordButton();

    }

    @Then("If it is {string} then shows message {string}")
    public void if_ItIs_Then_ShowsMessage(String valid, String message) {
        String error = forgotpassword.getMessageHeaderText(valid);
        Assert.assertEquals(message,error);

        
    }

}
