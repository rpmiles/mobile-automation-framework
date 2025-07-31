@reportItems
Feature: Single text prefilled item testing

  Scenario Outline: Confirming prefilled single text fields function correctly

    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<AddNotes>"
    #And I select a report
    When I select the item "<item>"
    And I check navigation
    And I confirm the field has the correct text
    And I select the x at the end of the field
    And I select the crosshairs icon
    Then I confirm the location coordinates have saved
    And I confirm notes are working correctly
    And I select the item "<item>"
    And I confirm the notes have saved
    And I select the back arrow
    And the list of reports is displayed


    Examples:
      | Datacapture          | ReportName                                 | ReferenceText | AddNotes                          | item                            |
      | Test All Controls RM | Report Items - Single Text Prefilled Tests | STP Reference | Single Text Prefilled Extra Notes | This is Prefilled Text (Single) |
