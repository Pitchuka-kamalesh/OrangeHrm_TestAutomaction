package com.cumcumberlearnings.Common;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.cumcumberlearnings.Common.BaseClass;
import io.cucumber.java.Scenario;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import java.util.concurrent.TimeUnit;

public class Hooks extends BaseClass {



    @Before
    public static void setupDriver() throws InterruptedException{
        System.out.println("Opening the Browser");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @After
    public static void teardown(Scenario scenario) throws Exception{

        if(scenario.isFailed()){
//            JavascriptExecutor js = (JavascriptExecutor)driver;
//            js.executeScript(
//                    "arguments[0].style.border = '3px solid red'",
//                    scenario);

            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "test failed");
        }

        System.out.println("Closing the browser instances");
        driver.quit();
    }
}
