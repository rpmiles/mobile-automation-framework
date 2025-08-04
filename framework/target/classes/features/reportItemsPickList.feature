@reportItems
Feature: Testing picklists

  Scenario Outline: Confirm picklists working correctly
    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    #Given I select a report
    And I select the item "<item>"
    And I check navigation
    And I select option one "<option1>"
    And I select the tick or done button
    And I select the item "<item>"
    And I select option two "<option2>"
    And I select the tick or done button
    And I select the item "<item>"
    And I deselect the first option "<option1>"
    And I select the tick or done button
    And I select the item "<item>"
    And I select option three "<option3>"
    And I select the tick or done button
    And I select the item "<item>"
    And I confirm the previous options are selected "<option1>", "<option2>", "<option3>"
    And I confirm notes are working correctly
    And I select the item "<item>"
    And I confirm the notes have saved
    And I confirm the options displayed in report view are correct "<option1>", "<option2>", "<option3>"
    And I select the back arrow
    And the list of reports is displayed
    And I select the upload button
    And I select upload
    Then I confirm the upload has completed
    And I close the upload dialog
    And I select the context menu
    And I remove the report

    Examples:
      | Datacapture          | ReportName                    | ReferenceText       | ReportDate | DueDate | AddNotes             | item                | option1  | option2  | option3  |
      | Test All Controls RM | Report Items - Picklist Tests | Picklists Reference |  TODAY      | ONEWEEK |Picklist Extra Notes | This is a Pick List | Option 1 | Option 2 | Option 3 |
