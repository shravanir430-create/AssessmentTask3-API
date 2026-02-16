package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/Features", // Path to .feature files
    glue = "com.stepDefinition",              // The Java files package name
    plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class Runner {
}