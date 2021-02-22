package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\java\\Features",
		glue={"Stepdefinition"},
		dryRun = false,
		plugin = {"pretty"},
		monochrome = true
		)

public class Runner {

}
