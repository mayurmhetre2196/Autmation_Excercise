package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Feature\\Excercise.feature", glue = { "StepDefination" }, plugin = {
		"pretty", "html:Report/Ebay/cucumber-reports.html", "json:Report/Ebay/cucumber.json" }, monochrome = true, dryRun = false
				)
public class Ebaytestrunner {

}
