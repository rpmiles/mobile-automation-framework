@uploads
Feature: Testing report uploads

  Scenario Outline: Test uploads by creating, uploading, downloading and confirming

    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    #Given I select a report
    And I select the item "Preformatted Text for Copy/Paste Tests"
    And I select all and delete
    And I select the numbered list button
    And I add three lines of text
    And I select the tick or done button
    And I select the item "Single Text"
    And I enter a single line of text "Single line of text entered into the single item text item"
    And I select the tick or done button
    And I select the back arrow
    And I edit the report
    And I select the item "This is Multi Text"
    And I select the "This is Multi Text" rating "3"
    And I enter specific text
    And I select the tick or done button
    And I select the item "This is Prefilled Text (Single)"
    And I select the x at the end of the single text field
    And I enter a single line of text "This item was previously prefilled but has now been replaced with this text"
    And I select the tick or done button
    And I select the back arrow
    And I edit the report
    And I select the item "This is Prefilled Text (Multi)"
    And I clear all the text in the Multi Text Prefilled item
    And I enter specific multi text
    And I select the tick or done button
    And I select the back arrow
    And I edit the report
    And I select the item "This is a Date"
    And I select a day "10"
    And I select the tick or done button
    And I select the item "This is a Switch"
    And I select switch "Switch 2"
    And I select the tick or done button
    And I select the item "Multi Select Pick List"
    And I select option two "Option 2"
    And I select option two "Option 3"
    And I select the tick or done button
    And I select the item "This Has Baked In Tokens"
    And I select the tick or done button
    And I select the item "This is Predefined Responses"
    And I select three more predefined responses "<response2>", "<response3>", "<response4>"
    And I select the tick or done button
    And I select the item "This is a Numeric"
    And I enter the numeric value "123456789000000000"
    And I select the tick or done button
    And I select the item "Enter Bold Text"
    And I enter the bold text "Entering some bold text to confirm form uploads correctly"
    And I select the tick or done button
    And I select the item "Enter Italics Text"
    And I enter the italics text "Entering some italics text to confirm form uploads correctly"
    And I select the tick or done button
    And I select the item "Enter Underlined Text"
    And I enter the underlined text "Entering some underlined text to confirm form uploads correctly"
    And I select the tick or done button
    And I select the item "Enter Multi Formatted Text"
    And I enter a single line of multiformatted text
    And I select the tick or done button
    And I select the item "This is a Rating"
    And I select the "This is a Rating" rating "N"
    And I select the tick or done button
    And I select the item "Multi Sheet Databacked"
    And I select the tick or done button
    And I select the item "Motors"
    And I select the tick or done button
    And I select the item "Free Text Table"
    And I select the tick or done button
    And I select the back arrow
    And I select the upload button
    And I select upload
    Then I confirm the upload has completed
    And I close the upload dialog
    And I select the context menu
    And I remove the report


    Examples:
      | Datacapture          | ReportName                           | ReferenceText     | ReportDate | DueDate | AddNotes                 | response2                                  | response3                             | response4                                        |
      | Test All Controls RM | Mobile - Report Items - Upload tests | Uploads Reference | TODAY      | ONEWEEK | Upload items Extra Notes | Multiple more entries are required to test | Third option specifically for testing | Text the same as the button for testing purposes |