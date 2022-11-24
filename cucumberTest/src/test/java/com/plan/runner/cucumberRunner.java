package com.plan.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/resources/features/loginPage.feature"}, glue = {"com.plan.definitions"},
plugin = {})

public class cucumberRunner extends AbstractTestNGCucumberTests {

}
