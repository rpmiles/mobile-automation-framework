@reportItems
Feature: Multi Text Rich Formatting Item Testing

  Scenario Outline: Confirming multi text fields function correctly
    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<AddNotes>"
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
    Then the list of reports is displayed

    Examples:
      | Datacapture          | ReportName                    | ReferenceText            | AddNotes                   | item               | text                                          |
      | Test All Controls RM | Report Items - Multi Text RTF | Multi Item RTF Reference | Multi Item RTF Extra Notes | This is Multi Text | Specific text entered for validation purposes |


    

