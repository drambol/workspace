@smoke
Feature: Login Action
  I want to use this template for my feature file

  @tag2
  Scenario: Successful search with Valid Credentials
    Given User go to "http://www.baidu.com/"
    When User enters "Drambol"
    And User click search
    Given User click link
    Given User click url
