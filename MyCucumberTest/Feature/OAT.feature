Feature: User can transfer between own accounts

@smoke
Scenario Outline: Different users can login FO
    Given User go to Login Page
    When User enters "<userName>" and "<passWord>" and click Login
    Then User Login Successfully
           
Examples: 
      | userName    | passWord |
      | 6500001111  | ibnk1357 |
      | 6500003391  | ibnk1357 |

@test
Scenario: User can go to OAT menu
    Given User go to Login Page
    When User enters username and password and click Login
    | 6500001111  | ibnk1357 |
    Then User Login Successfully
    Then User clicks Menu

