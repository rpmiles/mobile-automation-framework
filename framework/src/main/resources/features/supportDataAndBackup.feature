Feature: Check support screen and backup

  Scenario Outline: Confirm the support screen is displaying the correct info and trigger a backup

    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    And I select the back arrow
    And I select the profile menu
    #Given I select the profile menu
    When I select support
    And I confirm the correct username "admin@beta.com" is listed
    And I confirm the correct logged in user key "4-1" is listed.
    And I confirm the working directory first line is correct
    And I confirm the report just created is listed
    And I select the Backup button
    And I select the confirm button
    And I confirm the backup was successful
    And I click the button to return to report list
    Then I confirm the only report listed is "<ReportName>"
    And I select the upload button
    And I select upload
    Then I confirm the upload has completed
    And I close the upload dialog


   Examples:
         | Datacapture          | ReportName                  | ReferenceText | ReportDate | DueDate | AddNotes           | item             |
         | Test All Controls RM | Report Items - Support Data | Reference     | TODAY      | ONEWEEK | Support Extra Notes | This is a Switch |