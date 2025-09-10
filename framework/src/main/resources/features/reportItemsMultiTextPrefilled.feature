Feature: Multi text prefilled item testing
  @reportItems
  Scenario Outline: Confirming prefilled multi text fields function correctly

    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    #Given I select a report
    When I select the item "<item>"
    And I check navigation
    And I confirm the multi field has the correct text
    And I add some extra text "<ExtraText>"
    And I select the tick or done button
    And I select the item "<item>"
    And I confirm the extra text has been saved "<ExtraText>"
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
      | Datacapture          | ReportName                                   | ReferenceText                  | ReportDate | DueDate | AddNotes                         | item                           | ExtraText                                 |
      | Test All Controls RM | Mobile - Report Items - Multi Text Prefilled | Multi Text Prefilled Reference | TODAY      | ONEWEEK | Multi Text Prefilled Extra Notes | This is Prefilled Text (Multi) | This was edited and should be normal text |