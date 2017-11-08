Feature: baidu search
  baidu search

  @smoke
  Scenario: baidu search
    Given Go to baidu home
    And   Type the search text "selenium"
    And   Click the submit
    Then  Wait the query result
