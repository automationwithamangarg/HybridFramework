package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/Features",
        glue = "StepDefinitions",
        dryRun = true,
        monochrome = false,
        plugin = {"pretty","html:reports/cucumber-reports.html"},
        publish = false
)
public class TestRunner extends AbstractTestNGCucumberTests {
    //Test changes in branch 2
}
