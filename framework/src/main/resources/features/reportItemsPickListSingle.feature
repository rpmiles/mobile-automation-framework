Feature: Testing picklists

  @reportItems
  Scenario Outline: Confirm single select picklists working correctly
    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    #Given I select a report
    And I select the item "<item>"
    And I check navigation
    And I select the option "<option1>"
    And I select the tick or done button
    And I confirm the value for "<item>", "<option1>" is correct in report view
    And I select the item "<item>"
    And I select the option "<option2>"
    And I select the tick or done button
    And I confirm the value for "<item>", "<option2>" is correct in report view
    And I select the item "<item>"
    And I select the option "<option3>"
    And I select the tick or done button
    And I select the item "<item>"
    And I confirm "<option3>" is a selected option for "<item>"
    And I confirm notes are working correctly
    And I select the item "<item>"
    And I confirm the notes have saved
    And I confirm the value for "<item>", "<option3>" is correct in report view
    And I select the back arrow
    And I confirm the list of reports is displayed
    And I select the upload button
    And I select upload
    Then I confirm the upload has completed
    And I close the upload dialog
    And I select the context menu
    And I remove the report

    Examples:
      | Datacapture          | ReportName                                     | ReferenceText       | ReportDate | DueDate | AddNotes             | item                    | option1  | option2  | option3  | reportView        |
      | Test All Controls RM | Mobile - Report Items - Single Select Picklist | Picklists Reference | TODAY      | ONEWEEK | Picklist Extra Notes | Single Select Pick List | Option 1 | Option 2 | Option 3 | Option 2,Option 3 |
