Feature: Sync after logging in
@Sync

  Scenario: I sign in then I sign out
    Given I launch the mobile app
    And I enter a username
    And I enter a password
    And I select the sign-in button
    And I select the profile menu
    And I sign out
    Then I receive a confirmation

  Scenario: Login and download a report after syncing, confirming the report data
  Given I launch the mobile app
    And I enter a username
    And I enter a password
    And I select the sign-in button
    And I select the profile menu
    And I select sync
    And I select Cloud Reports
    And I download a specific report
    And I open the report
    Then I confirm the reports data
    And I select the back arrow
    And I select the context menu
    And I delete the report
    And I select the profile menu
    And I sign out
    And I receive a confirmation