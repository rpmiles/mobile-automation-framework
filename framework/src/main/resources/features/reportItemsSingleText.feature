Feature: Single text item testing

  @reportItems
  Scenario Outline: Test 'Single Text' item
    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    #Given I select a report
    When I select the item "<item>"
    And I check navigation
    And I select the x at the end of the single text field
    And I enter a single line of text "<SampleText>"
    And I select the tick or done button
    And I select the item "<item>"
    And I confirm the single text field contains "<SampleText>"
    And I select the x at the end of the single text field
    And I select the location icon
    And I return to the report
    And I select the item "<item>"
    And I confirm the location coordinates have saved
    And I confirm notes are working correctly
    And I select the item "<item>"
    And I confirm the notes have saved
    And I select the back arrow
    And I confirm the list of reports is displayed
    And I select the upload button
    And I select upload
    Then I confirm the upload has completed
    And I close the upload dialog
    And I select the context menu
    And I remove the report

    Examples:
      | Datacapture          | ReportName                                  | ReferenceText                 | ReportDate | DueDate | AddNotes                        | item                | SampleText |
      | Test All Controls RM | Mobile - Report Items - Single Text Feature | Single Text Feature Reference | TODAY      | ONEWEEK | Single Text Feature Extra Notes | This Is Single Text | Single text string to check normal field usage |

       #https://nominatim.openstreetmap.org/reverse?format=jsonv2&lat=50.9034045&lon=--3.4871714
