
Feature: Switch item testing
  @reportItems
  Scenario Outline: Confirming the Switch item functions as intended

    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    #Given I select a report
    And I select the item "<item>"
    When I select the option "<switch1>"
    And I confirm "<switch1>" is a selected option for "<item>"
    And I confirm "<switch2>" is not a selected option for "<item>"
    And I check navigation
    And I select the option "<switch2>"
    And I confirm "<switch2>" is a selected option for "<item>"
    And I confirm "<switch1>" is not a selected option for "<item>"
    And I select the option "<switch2>"
    And I confirm "<switch2>" is not a selected option for "<item>"
    And I confirm "<switch1>" is not a selected option for "<item>"
    And I select the option "<switch2>"
    And I confirm "<switch2>" is a selected option for "<item>"
    And I confirm "<switch1>" is not a selected option for "<item>"
    And I confirm notes are working correctly
    And I select the item "<item>"
    And I confirm the notes have saved
    And I confirm the value for "<item>", "<switch2>" is correct in report view
    And I select the back arrow
    And I confirm the list of reports is displayed
    And I select the upload button
    And I select upload
    Then I confirm the upload has completed
    And I close the upload dialog
    And I select the context menu
    And I remove the report

    Examples:
      | Datacapture          | ReportName                           | ReferenceText    | ReportDate | DueDate | AddNotes           | item             | switch1  | switch2  |
      | Test All Controls RM | Mobile - Report Items - Switch Tests | Switch Reference | TODAY      | ONEWEEK | Switch Extra Notes | This is a Switch | Switch 1 | Switch 2 |

