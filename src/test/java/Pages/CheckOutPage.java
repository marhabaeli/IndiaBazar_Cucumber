package Pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.TestBase;

public class CheckOutPage extends TestBase {
	@FindBy(id="billing_first_name")
	public WebElement fName;
	
	@FindBy(id="billing_last_name")
	WebElement lName;
	
	@FindBy(id="billing_email")
	WebElement email;
	
	@FindBy(id="billing_phone")
	WebElement phone;
	
	@FindBy(id="s2id_billing_country")
	WebElement country;
	
	@FindBy(id="s2id_autogen1_search")
	WebElement searchCntry;
	
	@FindBy(id="billing_address_1")
	WebElement address;
	
	@FindBy(id="billing_city")
	WebElement city;
	
	@FindBy(id="select2-chosen-2")
	WebElement state;
	
	@FindBy(id="s2id_autogen2_search")
	WebElement stateSearch;
	
	@FindBy(id="billing_postcode")
	WebElement postCode;
	
	@FindBy(id="place_order")
	WebElement placeOrder;
	
	@FindBy(xpath="//*[contains(text(),\"Thank you\")]")
	public WebElement completePayment;
	
//	Actions
	public void fillTheBill(List<String> billInfo) {
		fName.sendKeys(billInfo.get(0));	//firstname
		lName.sendKeys(billInfo.get(1));	//last name
		email.sendKeys(billInfo.get(2));	//email
		phone.sendKeys(billInfo.get(3));	//phone
//		JavascriptExecutor executor=(JavascriptExecutor)driver;
//		String jsScript="arguments[0].value='"+billInfo[3]+"';";
//		executor.executeScript(jsScript, phone);
//		executor.executeScript("arguments[0].value=2121212121;", phone);
		country.click();				
		searchCntry.sendKeys(billInfo.get(4)+Keys.ENTER);	//country
		address.sendKeys(billInfo.get(5));	//address
		city.sendKeys(billInfo.get(6));		//city
//		state.sendKeys(billInfo[7]);	//state
		state.click();
		stateSearch.sendKeys(billInfo.get(7)+Keys.ENTER);
		postCode.sendKeys(billInfo.get(8));	//postCode
		
	}
	
	public void clickOnPlaceOrder() {
		
		placeOrder.click();
	}
	
	public boolean isPaymentDone() {
		return completePayment.isDisplayed();
	}
}
