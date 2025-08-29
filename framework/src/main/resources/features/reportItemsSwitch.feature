@reportItems
Feature: Switch item testing

  Scenario Outline: Confirming the Switch item functions as intended

    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    #Given I select a report
    And I select the item "<item>"
    When I select switch "<switch1>"
    And switch "<switch1>" is highlighted
    And switch "<switch2>" is not highlighted
    And I check navigation
    And I select switch "<switch2>"
    And switch "<switch2>" is highlighted
    And switch "<switch1>" is not highlighted
    And I select switch "<switch2>"
    And Neither "<switch1>" or "<switch2>" is highlighted
    And I select switch "<switch2>"
    And switch "<switch2>" is highlighted
    And switch "<switch1>" is not highlighted
    And I confirm notes are working correctly
    And I select the item "<item>"
    And I confirm the notes have saved
    And Switch 2 is displayed as the selected option in report view
    And I select the back arrow
    And the list of reports is displayed
    And I select the upload button
    And I select upload
    Then I confirm the upload has completed
    And I close the upload dialog
    And I select the context menu
    And I remove the report

    Examples:
      | Datacapture          | ReportName                           | ReferenceText    | ReportDate | DueDate | AddNotes           | item             | switch1  | switch2  |
      | Test All Controls RM | Mobile - Report Items - Switch Tests | Switch Reference | TODAY      | ONEWEEK | Switch Extra Notes | This is a Switch | Switch 1 | Switch 2 |

