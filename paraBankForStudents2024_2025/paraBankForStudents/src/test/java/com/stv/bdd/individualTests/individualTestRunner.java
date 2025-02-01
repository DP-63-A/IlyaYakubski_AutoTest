package com.stv.bdd.individualTests;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/stv/bdd/features/Individual.feature",
        glue = {"com.stv.bdd.individualTests"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class individualTestRunner {
}