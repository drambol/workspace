Feature: Test Baidu

@drambol
Scenario: Baidu

Given I am on Baidu Page
Then Input search criteria with "StandardChartered"
Then Click submit
