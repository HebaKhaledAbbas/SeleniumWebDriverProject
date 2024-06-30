package org.example.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/main/resources/features",
                 glue = "org.example.Steps",
        plugin = {"pretty", "json:target/cucumber.json"},
        tags = "@UI"
)

public class TestRunner extends AbstractTestNGCucumberTests {



}
