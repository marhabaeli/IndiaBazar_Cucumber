
Feature: Login functionality
Background:
	Given user is on the login page
	
#@OpenBrowser
Scenario Outline: Login with valid data
	When user enter "<username>" and "<password>"
	And user click on login button
	Then user is able to login 
	Examples:
	 		|username							|password				|
	 		|tester001@shark.com	|Sh@rk001!Come$	|
	 		
Scenario Outline: Login with invalid data
	When user enter "<username>" and "<password>"
	And user click on login button
	Then user is not able to login 
	
	Examples:
	 		|username							|password				|
	 		|tester001@shark.com	|wrongpassword	|
	 		|tester001@shark.com	|								|
	 		|											|Sh@rk001!Come$	|
	 		|											|								|
	 		
	