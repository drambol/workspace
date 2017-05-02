Feature: User can login mobile banking
  
@smoke  
Scenario Outline: User can login FO
    Given User go to Login Page
    When User enters "<userName>" and "<passWord>" and click Login
    Then User Login Successfully
           
Examples: 
      | userName    | passWord |
      | 6500001111  | ibnk1357 |
      | 6500003391  | ibnk1357 |
      
      
      
      