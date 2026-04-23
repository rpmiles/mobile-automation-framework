Feature: Confirm a reports backup function works

  Scenario Outline: Checking Report Backup

    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    #Given I select a report
    When I select the back arrow
    And I select the context menu
    And I select the Backup Button
    And I select the confirm button
    And I close the backup dialog
    And I confirm the list of reports is displayed
    And I select the upload button
    And I select upload
    Then I confirm the upload has completed
    And I close the upload dialog
    And I select the context menu
    And I remove the report


    Examples:
      | Datacapture          | ReportName                | ReferenceText           | ReportDate | DueDate | AddNotes                  | item                     | AddNotes                  |
      | Test All Controls RM | Mobile - Reports - Backup | Report Backup Reference | TODAY      | ONEWEEK | Report Backup Extra Notes | This Has Baked In Tokens | Report Backups extra text |
