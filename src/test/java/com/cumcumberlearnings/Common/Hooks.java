package com.cumcumberlearnings.Common;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.cumcumberlearnings.Common.BaseClass;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks extends BaseClass {

    @Before
    public static void setupDriver() throws InterruptedException{
        System.out.println("Opening the Browser");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

    @After
    public static void teardown() throws Exception{
        System.out.println("Closing the browser instances");
        driver.quit();
    }
}