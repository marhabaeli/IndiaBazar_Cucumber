package Stepdefinition;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Pages.Homepage;
import Pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Homepage_SD extends TestBase {

	Homepage homepage;
	ProductsPage pruductsPage;
	
	@Given("user is on the Homepage")
	public void user_is_on_the_homepage() {
//	    System.out.println("user is on the homepage");
		getPage();
		homepage = PageFactory.initElements(driver, Homepage.class);
		pruductsPage = PageFactory.initElements(driver, ProductsPage.class);
	}

	@When("user click on shop menu")
	public void user_click_on_shop_menu() {
//	    System.out.println("user clicked on shop menu");
		homepage.clickOnShopmenu();
	}

	@When("user click on Home menu")
	public void user_click_on_home_menu() {
//	    System.out.println("user clicked on home button");
		pruductsPage.clickOnHomemenu();
	}

	@Then("Home page has three sliders")
	public void home_page_has_three_sliders() {
//	    System.out.println("home page has 3 sliders");
		int slidersCnt = homepage.getSliderCnt();
		assertEquals(3, slidersCnt);
	}

	@Then("homepage has three arrivals")
	public void homepage_has_three_arrivals() {
//	    System.out.println("home page has 3 arrivals");
		int newArrivalsCnt = homepage.getArrivalsCnt();
		assertEquals(3, newArrivalsCnt);		
	}

	@Then("user can see the review")
	public void user_can_see_the_review() {
	   System.out.println("user can see the review");
	}

	@Then("user can add book")
	public void user_can_add_book() {
	    System.out.println("user can add book");
	}
	
	@Then("browser gets closed")
	public void browser_gets_closed() {
	    System.out.println("Browser gets closed");
	}

}
