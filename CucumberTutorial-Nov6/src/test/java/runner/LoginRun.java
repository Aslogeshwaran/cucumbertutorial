package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
		
		features = "./src/main/resources/features",
		snippets = SnippetType.CAMELCASE,
		glue = {"steps","hooks"},
		dryRun = false,
		tags = "@create or @smoke",
		plugin = {
				"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"html:./src/test/resources/reports/index.html",
				"json:./src/test/resources/reports/index.json",
				"junit:./src/test/resources/reports/index.xml"
				
		}
		)
public class LoginRun extends AbstractTestNGCucumberTests{

}
