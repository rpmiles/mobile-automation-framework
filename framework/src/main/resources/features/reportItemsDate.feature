@reportItems
Feature: Date item testing

  Scenario Outline: Confirming date fields function correctly
    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    #Given I select a report
    And I select the item "<item>"
    And I check navigation
    And I confirm I can move to previous and next month
    And I select the month and year at the top
    And I confirm I can move to previous and next year ranges
    And I select a year <year>
    And I confirm I can move to previous and next year
    And I select a month <month>
    And I confirm I can move to previous and next month
    And I select a day <day>
    And I select the tick or done button
    And I select the item "<item>"
    And I confirm notes are working correctly
    And I select the item "<item>"
    And I confirm the notes have saved
    And I confirm the correct date is listed in the report view <reportDate>
    And I select the back arrow
    And the list of reports is displayed
    And I select the upload button
    And I select upload
    Then I confirm the upload has completed
    And I close the upload dialog
    And I select the context menu
    And I remove the report


    Examples:
      | Datacapture          | ReportName                      | ReferenceText                      | ReportDate | DueDate | AddNotes                             | item           | year   | month | day  | reportDate         |
      | Test All Controls RM | Report Items - Date             | Reference Date Testing             | TODAY      | ONEWEEK | Date Testing Extra Notes             | This is a Date | "2017" | "NOV" | "26" | "26 November 2017" |
      | Test All Controls RM | Report Items - Date - Leap Year | Reference Date Testing (Leap Year) | TODAY      | ONEWEEK | Date Testing (Leap Year) Extra Notes | This is a Date | "2024" | "FEB" | "25" | "25 February 2024" |
