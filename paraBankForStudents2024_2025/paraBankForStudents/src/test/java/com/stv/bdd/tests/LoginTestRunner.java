package com.stv.bdd.tests;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//If an error occurs and being logged aat the Parabank webpage, register there with another data
// and change login and password in LoginForm.feature file.
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/stv/bdd/features/LoginForm.feature",
        glue = {"com/stv/bdd/tests"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class LoginTestRunner {
}
