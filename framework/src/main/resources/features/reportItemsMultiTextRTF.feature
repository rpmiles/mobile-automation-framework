@reportItems
Feature: Multi Text Rich Formatting Item Testing

  Scenario Outline: Confirming multi text fields function correctly
    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    #Given I select a report
    When I select the item "<item>"
    And I check navigation
    And I enter specific text
    And I select the tick or done button
    And I select the back arrow
    And the list of reports is displayed
    And I reselect the report
    And I select the item "<item>"
    And I confirm all the multi text has been retained
    And I delete all the text
    And I select the tick or done button
    And I select the back arrow
    And I reselect the report
    And I select the item "<item>"
    And I enter a single line of multiformatted text
    And I select the tick or done button
    And I select the back arrow
    And I reselect the report
    And I select the item "<item>"
    And I confirm the previously entered multiformatted text has saved
    And I delete all the text
    And I create a bullet list of three entries
    And I select the tick or done button
    And I select the back arrow
    And I reselect the report
    And I select the item "<item>"
    And I confirm the bullet list has saved
    And I change the bullet list to a number list.
    And I confirm notes are working correctly
    And I select the item "<item>"
    And I confirm the notes have saved
    And I select the back arrow
    And the list of reports is displayed
    And I select the upload button
    And I select upload
    Then I confirm the upload has completed
    And I close the upload dialog
    And I select the context menu
    And I remove the report

    Examples:
      | Datacapture          | ReportName                             | ReferenceText            | ReportDate | DueDate | AddNotes                   | item               | text                                          |
      | Test All Controls RM | Mobile - Report Items - Multi Text RTF | Multi Item RTF Reference | TODAY      | ONEWEEK | Multi Item RTF Extra Notes | This is Multi Text | Specific text entered for validation purposes |


    

