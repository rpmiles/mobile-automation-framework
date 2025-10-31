Feature: Testing Predefined Responses

  @reportItems
  Scenario Outline: Testing the Predefined Responses item

    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    #Given I select a report
    And I select the item "<item>"
    And I check navigation
    And I select a single predefined response "<response>"
    And I select the tick or done button
    And I select the item "<item>"
    And I confirm the previous predefined response is still present "<response>"
    And I select three more predefined responses "<response2>", "<response3>", "<response4>"
    And I delete a predefined response "<response3>"
    And I confirm the text is deleted "<response3>"
    And I select the location crosshairs icon
    And I validate the location coordinates have been added
    And I send the cursor to the end of the text
    And I select the carriage return button
    And I enter some text into the multi text item "<text>"
    And I select the tick or done button
    And I select the item "<item>"
    And I confirm the previously entered Text "<text>"
    And I confirm notes are working correctly
    And I select the item "<item>"
    And I confirm all previously entered data is saved "<text>"
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
      | Datacapture          | ReportName                                   | ReferenceText | ReportDate | DueDate | AddNotes        | item                         | response                                         | response2                                  | response3                                            | response4          | text                                    |
      | Test All Controls RM | Mobile - Report Items - Predefined Responses | PDR Reference | TODAY      | ONEWEEK | PDR Extra Notes | This is Predefined Responses | Text the same as the button for testing purposes | Multiple more entries are required to test | Entering more options to confirm multiple selections | Testing this entry | Additional not predefined response text |