#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: War Swords Home Page First Products
Check that the links to all the product pages work

	@tag1
	Scenario Outline: First few product links redirect to their respective pages 
		Given We are at the Home Page
		When The subscribe modal is closed
		And The "<link>" link is clicked
		Then The page title is displayed as "<link>"
		
		
    Examples: 
      | link  									|
      | Japanese/Samurai Swords | 
      | Medieval European Swords|
      | Movie/Television Swords |
      | Anime/Gaming Swords     |
      
     