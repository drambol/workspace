Feature: Login System

@drambol
Scenario: login

Given I am on Login Page
Then I login with "6500001111" and "ibnk1357"
Then take screenshoot
Given I am on Landing Page
Then I click Menu
Given I am on Menu
Then I click MyAccounts
Given I am on MyAccounts Page
Then I input TSP PIN with "111111"
