Feature: Sync after logging in
@Sync
  Scenario: Login and download a report after syncing, confirming the report data
  Given I launch the mobile app
    And I enter a username
    And I enter a password
    And I select the sign-in button
    And I select the profile menu
    And I select sync
    And I select Cloud Reports
    And I search cloud reports for "Sync Test - Template"
    And I download the report
    And I open the report
    Then I confirm the reports data
    And I select the back arrow
    And I close the local search field
    And I select the context menu
    And I delete the report
    And I select the profile menu
    And if the Sign out button is selected the user is signed out
    And I receive a confirmation