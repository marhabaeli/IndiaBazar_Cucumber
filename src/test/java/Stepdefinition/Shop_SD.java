package Stepdefinition;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Pages.CheckOutPage;
import Pages.Homepage;
import Pages.Shoppage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Shop_SD extends TestBase{

	Homepage homepage;
	Shoppage shoppage;
	CheckOutPage checkoutpage;
	
	@Given("user is on the Shopping page")
	public void user_is_on_the_shopping_page() {
	    homepage=PageFactory.initElements(driver, Homepage.class);
	    shoppage=PageFactory.initElements(driver, Shoppage.class);
	    checkoutpage=PageFactory.initElements(driver, CheckOutPage.class);
	    getPage();
	    homepage.clickOnShopmenu();
	}

	@When("user adjust the filter by price")
	public void user_adjust_the_filter_by_price() {
		int val1=(int)(Math.random()*100+50);  //to put min value,get it from 50, 150
		int val2=(int)(Math.random()*60+10);	//to put max value, get it from 10, 70
		
		if(val1>val2) {
			int t=val2; val2=val1; val1=t;
		}
		if(val2-val1<40) {
			val1-=10;
			val2+=10;
		}
//		System.out.println(val1+","+val2);
		shoppage.clickOnslider(val1, val2*(-1));
		setLogger("Price slider got clicked");
	}

	@When("click on filter button")
	public void click_on_filter_button() {
		shoppage.clickOnFilter();
		setLogger("Filter button got clicked");
	}

	@Then("user can view books in that range")
	public void user_can_view_books_in_that_range() {
		ArrayList<String> priceRange=shoppage.getSpanValue();
//		System.out.println("price range:"+priceRange);
		int min=Integer.parseInt(priceRange.get(0));
		int max=Integer.parseInt(priceRange.get(1));
//		System.out.println("max="+max+", min="+min);		
		assertTrue(shoppage.isFiltered(min, max));
	}

	@When("user click any of the product link")
	public void user_click_any_of_the_product_link() {
		int clickableElemIndx=1;
		shoppage.clickOnCtgLnk(clickableElemIndx);
	}

	@Then("user can only view that category product")
	public void user_can_only_view_that_category_product() {
		int clickableElemIndx=1;
		String lnkCaption=shoppage.prdctCtgLst.get(clickableElemIndx).findElement(By.xpath("./a")).getText();
		String lnkCnt=shoppage.prdctCtgLst.get(clickableElemIndx).findElement(By.xpath("./span")).getText();
		setLogger(lnkCaption+" "+lnkCnt+ "got clicked");
		lnkCnt=lnkCnt.replace("(", "");
		lnkCnt=lnkCnt.replace(")", "");
		
		int m=Integer.parseInt(lnkCnt);
		assertTrue(shoppage.isCategorized(lnkCaption) && shoppage.ctgPrdctLst.size()==m);
	}

	@When("user click on read more button")
	public void user_click_on_read_more_button() {
		for(WebElement elem: shoppage.sortedElemLst) {
			WebElement readMoreElem=elem.findElement(By.xpath("./a[2]"));
			if(readMoreElem.getText().equalsIgnoreCase("Read more")) {
				setLogger(elem.findElement(By.xpath("./a[1]")).getText()+" got selected");
				readMoreElem.click();
				setLogger("clicked Read More");
				break;
			}
		}		
	}

	@Then("it indicates out of store")
	public void it_indicates_out_of_store() {
		assertTrue(shoppage.isOOSIndc());
	}

	@When("user click on add to basket button")
	public void user_click_on_add_to_basket_button() {
	   
	}

	@Then("user can view the book with price")
	public void user_can_view_the_book_with_price() {
	    
	}

	@When("user click on view basket link")
	public void user_click_on_view_basket_link() {
		for(WebElement elem: shoppage.sortedElemLst) {
			WebElement add2CardElem=elem.findElement(By.xpath("./a[2]"));
			if(add2CardElem.getText().equalsIgnoreCase("Add to basket")) {
				setLogger(elem.findElement(By.xpath("./a[1]/h3")).getText()+" got selected");
				add2CardElem.click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				assertTrue(shoppage.isItemInCart());
				elem.findElement(By.xpath("./a[3]")).click();
				setLogger("viewing cart conditions.....");
				break;
			}
		}
	}

	@Then("user can find the subtotal always less than total")
	public void user_can_find_the_subtotal_always_less_than_total() {
		assertTrue(shoppage.isTotalGreatThanSub());
	}

	@When("user click on Proceed to Check out button")
	public void user_click_on_proceed_to_check_out_button() {
		shoppage.clickOnPrChkOutBtn();
		setLogger("checking item details.....");
	}

	@Then("user can view all the details")
	public void user_can_view_all_the_details() {
		assertTrue(shoppage.isDetailsThere());
	}

	@When("user fill the form using below msg")
	public void user_fill_the_form_using_below_msg(DataTable dataTable) {
		List<List<String>> billInfoList=dataTable.asLists(String.class);
		
		checkoutpage.fillTheBill(billInfoList.get(1));
		setLogger("user info got filled");
	}

	@When("user click on Place Order button")
	public void user_click_on_place_order_button() {
		checkoutpage.clickOnPlaceOrder();
		setLogger("clicked on PLACE ORDER");
	}

	@Then("user can complete his process")
	public void user_can_complete_his_process() throws Exception {
		Thread.sleep(3000);
		assertTrue(checkoutpage.isPaymentDone());
	}
}
