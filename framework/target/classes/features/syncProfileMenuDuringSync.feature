Feature: Confirm the Username and 'Sign Out' buttons are available from the profile menu during Sync
  @Sync
  Scenario: Login and sync via the profile menu
    Given I launch the mobile app
    And I enter a username
    And I enter a password
    And I select the sign-in button
    And I select the profile menu
    And I select sync without wait
    And I select the profile menu
    Then the signed in user is listed
    And I wait for the sync to complete
    And I select the profile menu
    And if the Sign out button is selected the user is signed out