Feature: Editing reports

  Scenario Outline: Download and Edit, and create

    Given I select Cloud Reports
    And I search cloud reports for "<TargetReport>"
    And I download the report
    And I close the local search field
    And I select a report
    And I confirm the report edit
    And I select the back arrow
    And I select the context menu
    And I delete the report
    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    And I select the item "<item>"
    And I enter a single line of text "<text>>"
    And I select the tick or done button
    And I select the back arrow
    And I select a report
    And I confirm the report edit
    And I select the back arrow
    And I confirm the list of reports is displayed
    And I select the upload button
    And I select upload
    Then I confirm the upload has completed
    And I close the upload dialog
    And I select the context menu
    And I remove the report



    Examples:
      | TargetReport            | Datacapture          | ReportName              | ReferenceText  | ReportDate | DueDate | AddNotes             | item                | text                       |
      | Reports - Edit - Master | Test All Controls RM | Mobile - Reports - Edit | Reports - Edit | TODAY      | ONEWEEK | Reports - Edit Notes | This Is Single Text | This is to confirm an edit |

