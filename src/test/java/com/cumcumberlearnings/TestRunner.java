package com.cumcumberlearnings;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        },
        features = {"src/test/resources/features"},
        glue = {"com.cumcumberlearnings.StepDefinitions"}
//        tags = "@BeforeTest"
)

public class TestRunner extends AbstractTestNGCucumberTests {



}