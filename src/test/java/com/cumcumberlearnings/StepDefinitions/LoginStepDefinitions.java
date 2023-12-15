package com.cumcumberlearnings.StepDefinitions;

import com.cumcumberlearnings.pageObject.loginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;


import java.time.Duration;

public class LoginStepDefinitions {
    public static WebDriver driver;
    loginPage login;

    @Before
    public void openTheApplication() {
        driver = new FirefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }
    @Given("I am on the Orange HRM login page")
    public void iAmOnTheOrangeHRMLoginPage() {

        driver = new FirefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        Assert.assertEquals("OrangeHRM",title);

    }


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

    @After
    public void tearDown(){
        driver.quit();

    }


}
