package Stepdefinition;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Pages.AccountPage;
import Pages.Homepage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_SD extends TestBase{

	Homepage homepage;
	AccountPage accntPage;
	
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
	    getPage();
	    homepage=PageFactory.initElements(driver, Homepage.class);
	    accntPage=PageFactory.initElements(driver, AccountPage.class);
	    homepage.clickOnMyAccntBtn();
	}

	@When("user enter {string} and {string}")
	public void user_enter_and(String string, String string2) {
		accntPage.setLoginUsernm(string);
		accntPage.setLoginPsw(string2);
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		accntPage.clickLoginBtn();
	}

	@Then("user is able to login")
	public void user_is_able_to_login() throws Exception {
		Thread.sleep(2000);
		assertTrue(accntPage.logoutBtn.isDisplayed());
		accntPage.clickLogout();
	}

	@Then("user is not able to login")
	public void user_is_not_able_to_login() {
		assertTrue(accntPage.getErrTxt().toLowerCase().contains("error"));
		
	}
}
