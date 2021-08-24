Feature: Direct to Amazon Login Page
  @amazonCreateUser
  Scenario: Go to amazoncom main page
    Given User should go to login page
    And User should enter user name
    And User should enter password
    Then User should click login
    Then User should see success message

