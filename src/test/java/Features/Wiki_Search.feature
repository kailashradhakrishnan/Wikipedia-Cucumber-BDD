
Feature: Wikipedia Search Page Automation
  
  Scenario Outline: Validate Search Results    
    Given Validate the launched Search Page
    And Enter "<Search Criteria>" in the search bar
    And Click on Search
    Then Validate the Search Results "<Search Criteria>"
    
    Examples:
    |Search Criteria					|
    |Software Testing					|
    |Software Development			|
		|QA analyst								|
		
	
	Scenario Outline: Validate Suggestions from Search bar by using one or two letters
		Given Enter "<input>" by using two or three letters in the search bar
		And Select results from dropdown "<Suggestions>"
		Then Validate the Selected Results "<Suggestions>"
		
		Examples:
    |Suggestions		|input|
    |United Kingdom	|Un		|
    |Scotland				|Sco	|
    
   @now   
   Scenario: Validate Help link is opening in a new window
   Given Click on Help link
   Then Navigate to new window and validate the page tile
   
		
  
