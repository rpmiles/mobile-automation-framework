@reportItems
Feature: Multi text prefilled item testing

  Scenario Outline: Confirming prefilled multi text fields function correctly

    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<AddNotes>"
    #Given I select a report
    When I select the item "<item>"
    And I check navigation
    And I confirm the multi field has the correct text
    And I add some extra text "<ExtraText>"
    And I select the tick or done button
    Then I select the item "<item>"
    And I confirm the extra text has been saved "<ExtraText>"
    And I confirm notes are working correctly
    And I select the item "<item>"
    And I confirm the notes have saved
    And I select the back arrow
    And the list of reports is displayed

    Examples:
      | Datacapture          | ReportName                          | ReferenceText                  | AddNotes                         | item                           | ExtraText                                 |
      | Test All Controls RM | Report Items - Multi Text Prefilled | Multi Text Prefilled Reference | Multi Text Prefilled Extra Notes | This is Prefilled Text (Multi) | This was edited and should be normal text |