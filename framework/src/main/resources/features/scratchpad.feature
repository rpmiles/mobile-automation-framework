Feature: Checking another one

  Scenario Outline: Troubleshooting why elements are not linking
    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<AddNotes>"
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
    And I select the item "<item>"
    And I confirm the notes have saved
    And I confirm the correct date is listed in the report view <reportDate>
    And I select the back arrow
    Then the list of reports is displayed


    Examples:
      | Datacapture          | ReportName                  | ReferenceText                                       | AddNotes         | item               | year   | month | day  | reportDate         |
      | Test All Controls RM | Report Items - Switch Tests | Reference                                           | Date Extra Notes | This is a Date     | "2017" | "NOV" | "26" | "26 November 2017" |
      | This is a Date       | Test All Controls RM        | "Report Items - Date - Leap Year(<ReleaseVersion>)" | Reference        | Date control notes | "2024" | "FEB" | "25" | "25 February 2024" |
