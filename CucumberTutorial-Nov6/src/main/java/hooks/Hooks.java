package hooks;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;

public class Hooks {

	WebDriver driver;

	BaseClass baseClass;

	public Hooks(BaseClass baseClass) {
		this.baseClass = baseClass;
	}

	@Before
	public void beforeScenario(Scenario scenario) {
		baseClass.setDriver(driver);
		baseClass.getDriver().manage().window().maximize();
		baseClass.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		baseClass.getDriver().get("https://www.facebook.com/");
		String name = scenario.getName();
		System.out.println("Scenario Name :: " + name);
	}

	@After
	public void afterScenario(Scenario scenario) {
		Status status = scenario.getStatus();
		System.out.println("Scenario Run Status :: " + status);

		boolean failedStatus = scenario.isFailed();
		if (failedStatus == true) {
			TakesScreenshot ts = (TakesScreenshot) baseClass.getDriver();
			byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotAs, "image/png", "screenshot captured...");
		}
		baseClass.getDriver().quit();

	}

	public void beforeStep() {

	}
}
