package steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	List<WebElement> links;

	BaseClass baseClass;

	public LoginSteps(BaseClass baseClass) {
		this.baseClass = baseClass;
	}

	@When("User gets facebook title and url")
	public void userGetsFacebookTitleAndUrl() {
		System.out.println(baseClass.getDriver().getTitle());
		System.out.println(baseClass.getDriver().getCurrentUrl());
	}

	@When("User gets links count")
	public void userGetsLinksCount() {
		links = baseClass.getDriver().findElements(By.tagName("a"));
		System.out.println(links.size());
	}

	@When("User prints links text and hrefattribute")
	public void userPrintsLinksTextAndHrefattribute() {
		for (WebElement aa : links) {
			System.out.println(aa.getText() + "--->" + aa.getAttribute("href"));
		}
	}

	@When("User enters the username  as {string} and password as {string}")
	public void userEntersTheUsernameAsAndPasswordAs(String userName, String passWord) {
		baseClass.getDriver().findElement(By.id("email")).sendKeys(userName);
		baseClass.getDriver().findElement(By.id("pass")).sendKeys(passWord);
	}

	@When("User clicks the login Button")
	public void userClicksTheLoginButton() {
		baseClass.getDriver().findElement(By.name("login")).click();
	}

	@Then("User gets warning message")
	public void userGetsWarningMessage() {
		String text = baseClass.getDriver()
				.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[2]/div[2]/form/div/div[1]/div[2]"))
				.getText();
		System.out.println(text);
	}

}
