Feature: Home Page feature

  Scenario: Verify username on HomePage
    Given User is on loginpage
    When User enter <username> and <password>
    And User verify "Aman Garg" on HomePage

  Scenario: Verify username on Test
    Given User is on step1
    When User is on Step2
    And User verify Step3
