package com.cumcumberlearnings.Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {
    public static  WebDriver driver;
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));

}
