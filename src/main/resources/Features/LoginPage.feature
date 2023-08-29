Feature: Login test user

  Scenario: Verify user able to login
    Given User is on loginpage
    When User enter <username> and <password>
    And User clicks on login button
    Then User is navigated to homepage
    And User verifies homepage title
    And User verifies homepage title


    @Test
  Scenario Outline: Verify user able to login 2
    Given User is on loginpage
    And User clicks on login button
    Then User is navigated to homepage
    And User verifies homepage title
    And User verifies homepage title
    Examples:
      | username | password |
    |Aman Garg  |12345     |
    |Noor      |Test@123     |
