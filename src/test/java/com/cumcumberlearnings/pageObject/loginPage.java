package com.cumcumberlearnings.pageObject;

import com.cumcumberlearnings.Common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class loginPage extends BaseClass {

    private final By user_name = By.xpath("//input[@name='username']");
    private final By password_id = By.xpath("//input[@name='password']");
    private final By login_button = By.xpath("//button[@type='submit']");
    private final By error_alert = By.xpath("//p[@class = 'oxd-text oxd-text--p oxd-alert-content-text']");
    private final By required_field = By.tagName("span");
    private final By login_header = By.tagName("h6");

    public loginPage(WebDriver driver) {
        BaseClass.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    public void enterUsername(String username){
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(user_name).sendKeys(username);
    }
    public void enterPassword(String password){
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
        switch (type){
            case "valid":
                error = driver.findElement(login_header).getText();
                break;
            case "invalid":
                error = driver.findElement(required_field).getText();
                break;
        }
        return error;
    }

}
