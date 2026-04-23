Feature: Sync after logging in
@Sync
  Scenario: Login and download a report after syncing, confirming the report data
  Given I enter a username
    And I enter a password
    And I select the sign-in button
    And I select the profile menu
    And I select sync
    And I select Cloud Reports
    And I search cloud reports for "Sync Test - Master"
    And I download the report
    And I open the report
    Then I confirm the reports data
    And I select the back arrow
    And I close the local search field
    And I select the context menu
    And I delete the report
