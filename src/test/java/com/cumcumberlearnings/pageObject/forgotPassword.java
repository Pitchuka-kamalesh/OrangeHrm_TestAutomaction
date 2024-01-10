package com.cumcumberlearnings.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class forgotPassword {
    WebDriver driver;

   private final By forgot_password_link = By.xpath("//p[@class = 'oxd-text oxd-text--p orangehrm-login-forgot-header']");
   private final By reset_password_button = By.xpath("//button[@type='submit']");

    private final By message_header = By.tagName("h6");

    private final By required_field = By.tagName("span");

    public forgotPassword(WebDriver driver) {
        this.driver = driver;
    }


    public void clickResetPasswordButton(){
        driver.findElement(reset_password_button).click();
    }

    public void clickForgotPassword(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(forgot_password_link).click();
    }

    public String getMessageHeaderText(String valid) {
        WebElement headerElement;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        if (valid.equalsIgnoreCase("valid")){
            headerElement = driver.findElement(message_header);

        } else {
            headerElement = driver.findElement(required_field);

            }

        return headerElement.getText();

    }
}
