Feature: Initial login
@full
  Scenario: Login to the Mobile Portal for the first time and sync
    Given I enter a username
    And I enter a password
    And I select the sign-in button
    And I perform an initial sync
    Then I am met with the Mobile Portal homepage


