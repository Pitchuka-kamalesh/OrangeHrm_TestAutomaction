package com.cumcumberlearnings.StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public  static WebDriver driver;
    @BeforeTest
    public void setUp() throws Exception{
        driver = new FirefoxDriver();

    }

    @AfterTest
    public void TearDown(){ driver.quit();}
}
