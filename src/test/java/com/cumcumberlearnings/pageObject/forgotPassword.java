package com.cumcumberlearnings.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class forgotPassword {
    WebDriver driver;

    By forgot_password_link = By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[4]/p[1]");
    By reset_password_button = By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/form[1]/div[2]/button[2]");

    By message_header = By.tagName("h6");

    By required_field = By.className("ymqHP ExcM8");

    public forgotPassword(WebDriver driver) {
        this.driver = driver;
    }


    public void clickResetPasswordButton(){
        driver.findElement(reset_password_button).click();
    }

    public void clickForgotPassword(){
        driver.findElement(forgot_password_link).click();
    }

    public String getMessageHeaderText(String valid) {
        WebElement headerElement;
        if (valid.equals("valid")){
            headerElement = driver.findElement(message_header);

        } else {


            headerElement = driver.findElement(required_field);

            }

        return headerElement.getText();

    }
}
