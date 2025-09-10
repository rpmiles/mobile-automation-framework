Feature: Sync from the profile menu
  @Sync
  Scenario: Login and sync via the profile menu
    Given I launch the mobile app
    And I enter a username
    And I enter a password
    And I select the sign-in button
    And I select the profile menu
    And I select sync
    Then I am met with the Mobile Portal homepage
    And I select the profile menu
    And if the Sign out button is selected the user is signed out
