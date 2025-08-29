@reportItems
Feature: Testing Predefined Responses

  Scenario Outline: Testing the Predefined Responses item

    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    #Given I select a report
    And I select the item "<item>"
    And I check navigation
    And I select a single response "<response>"
    And I select the tick or done button
    And I select the item "<item>"
    And confirm the previous entry is still present "<response>"
    And I select three more responses "<response2>", "<response3>", "<response4>"
    And I can delete some text "<response3>"
    And I confirm the text is deleted "<response3>"
    And I select the location crosshairs icon
    And I validate the location coordinates have been added
    And I send the cursor to the end of the text
    And I select the carriage return button
    And I enter some text "<text>"
    And I select the tick or done button
    And I select the item "<item>"
    And I confirm the previously entered Text "<text>"
    And I confirm notes are working correctly
    And I select the item "<item>"
    And I confirm all previously entered data is saved "<text>"
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
      | Datacapture          | ReportName                                   | ReferenceText | ReportDate | DueDate | AddNotes        | item                         | response                                           | response2                                  | response3                             | response4                                        | text                                    |
      | Test All Controls RM | Mobile - Report Items - Predefined Responses | PDR Reference | TODAY      | ONEWEEK | PDR Extra Notes | This is Predefined Responses | Another testing entry for testing multiple entries | Multiple more entries are required to test | Third option specifically for testing | Text the same as the button for testing purposes | Additional not predefined response text |