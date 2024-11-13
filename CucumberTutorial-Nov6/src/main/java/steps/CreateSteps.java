package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateSteps {


	BaseClass baseClass;

	public CreateSteps(BaseClass baseClass) {
		this.baseClass = baseClass;
	}

	@When("User clicks the create new button")
	public void userClicksTheCreateNewButton() {
		WebElement createNewButton = baseClass.getDriver().findElement(By.partialLinkText("Crea"));
		createNewButton.click();

	}

	@Then("User enters firstname and lastname")
	public void userEntersFirstnameAndLastname() {

		baseClass.getDriver().findElement(By.name("firstname")).sendKeys("Admin");
		baseClass.getDriver().findElement(By.name("lastname")).sendKeys("Tester");
	}

	@Then("User enters emailid or mobilenumber")
	public void userEntersEmailidOrMobilenumber() {
		baseClass.getDriver().findElement(By.name("reg_email__")).sendKeys("Email@mail.com");
	}

	@Then("User enter password and confirm password")
	public void userEnterPasswordAndConfirmPassword() {
		baseClass.getDriver().findElement(By.name("reg_passwd__")).sendKeys("Password@123");
	}

	@Then("User clicks radio button")
	public void userClicksRadioButton() {
		baseClass.getDriver().findElement(By.xpath("//input[@value='-2']")).click();
	}

	@Then("User clicks the submit button")
	public void userClicksTheSubmitButton() {
		baseClass.getDriver().findElement(By.name("websubmit")).click();
	}
}
