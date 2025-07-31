@reportItems
Feature: Switch item testing

  Scenario Outline: Confirming the Switch item functions as intended

    #Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<AddNotes>"
    Given I select a report
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
    #And I select the tick or done button
    Then Switch 2 is displayed as the selected option in report view
    And I select the back arrow
    And the list of reports is displayed

    Examples:
      | Datacapture          | ReportName                  | ReferenceText    | AddNotes           | item             | switch1  | switch2  |
      | Test All Controls RM | Report Items - Switch Tests | Switch Reference | Switch Extra Notes | This is a Switch | Switch 1 | Switch 2 |

