#features/SearchGoogle.feature

Feature: Google search

Scenario: Search for webdriver        
	Given I am on the Google homepage
	Then I will search for "webdriver"
	Then I should see "webdriver"
	