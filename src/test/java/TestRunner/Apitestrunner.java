package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src\\test\\resources\\Feature\\API.feature" }, glue = { "StepDefination" }, tags="@Getrequest",plugin = {
		"pretty", "html:Report/API/cucumber-reports.html", "json:Report/API/cucumber-reports.json" }, monochrome = true, dryRun = false)
public class Apitestrunner {

}
