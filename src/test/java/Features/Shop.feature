
Feature: Shopping functionality
	Background: 
    Given user is on the Shopping page 
  #@OpenBrowser    
  Scenario: Filter by price
  	When user adjust the filter by price
  	And click on filter button
  	Then user can view books in that range
  	
  Scenario: Product categories
  	When user click any of the product link
  	Then user can only view that category product
  	
  Scenario: Read more functionality
  	When user click on read more button
  	Then it indicates out of store

	@CloseBrowser
	Scenario: Add and view basket functionality
		When user click on add to basket button
		Then user can view the book with price
		When user click on view basket link
		Then user can find the subtotal always less than total
		When user click on Proceed to Check out button
		Then user can view all the details
		When user fill the form using below msg
			|fName		| lName|email							|phone			|Country			|Address1				|City			|State	|Zip	|
			|tester01	|tester|tester01@gmail.com|2121212121	|United States|2134 Fox Drive	|GrandLake|Kansas	|66087|
		And user click on Place Order button
		Then user can complete his process