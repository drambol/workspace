@smoke
Feature: Login Action
  I want to use this template for my feature file

  @tag1
  Scenario Outline: Successful search with Valid Credentials
    Given User go to "http://www.baidu.com/"
    When User enters "<keyword>"
    And User click search

    Examples: 
      | keyword           |
      | StandardChartered |
      | Drambol           |
