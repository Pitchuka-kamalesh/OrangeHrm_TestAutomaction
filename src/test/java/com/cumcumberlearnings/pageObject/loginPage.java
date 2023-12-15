package com.cumcumberlearnings.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class loginPage{
    WebDriver driver;


    By user_name = By.name("username");
    By password_id = By.name("password");
    By login_button = By.className("oxd-button");

    By error_alert = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]");

    By required_field = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span");
    By login_header = By.tagName("h6");

    public loginPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    public void enterUsername(String username){
        driver.findElement(user_name).sendKeys(username);
    }
    public void enterPassword(String password){
        driver.findElement(password_id).sendKeys(password);
    }
    public void clickLogin(){
        driver.findElement(login_button).click();
    }

    public void userLogin(String username, String password){
        driver.findElement(user_name).sendKeys(username);
        driver.findElement(password_id).sendKeys(password);
        driver.findElement(login_button).click();

    }
    public String validate_Error_Cred(String type){
        String error = null;
        if (type.equals("valid")){
            error = driver.findElement(login_header).getText();

        } else {
            try {
                error = driver.findElement(error_alert).getText();

            }catch (Exception e){
                error = driver.findElement(required_field).getText();
                System.out.println("Print exception"+e);
            }

        }

        return error;
    }

}
