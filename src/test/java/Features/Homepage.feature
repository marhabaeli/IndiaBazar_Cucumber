Feature: Homepage Function

Background: 
	Given user is on the Homepage
@OpenBrowser
Scenario: Homepage has 3 sliders
    #Given user is on the Homepage
    When user click on shop menu
    And user click on Home menu
    Then Home page has three sliders

  #Scenario: Homepage has 3 arrivals
    #Given user is on the Homepage
    #When user click on shop menu
    #And user click on Home menu
    #Then homepage has three arrivals
#
  #Scenario: user can see the review
    #Given user is on the Homepage
    #When user click on shop menu
    #And user click on Home menu
    #Then user can see the review

 #@CloseBrowser
  Scenario: user is able to add a book to basket
    #Given user is on the Homepage
    When user click on shop menu
    And user click on Home menu
    Then user can add book
   
   
  
   #Scenario: Close Browser
   #Then browser gets closed
   
    