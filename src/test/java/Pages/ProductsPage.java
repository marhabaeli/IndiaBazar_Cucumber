package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.TestBase;

public class ProductsPage extends TestBase {

	//elements
	
	@FindBy(xpath = "//a[text()=\'Home\']")
	WebElement homElement;
	
	//Actions
	public void clickOnHomemenu() {
		homElement.click();
	}
}
