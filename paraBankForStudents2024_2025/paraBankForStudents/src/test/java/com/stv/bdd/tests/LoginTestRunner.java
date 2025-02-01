package com.stv.bdd.tests;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/stv/bdd/features/LoginForm.feature",
        glue = {"com.stv.bdd.tests"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class LoginTestRunner {
}
