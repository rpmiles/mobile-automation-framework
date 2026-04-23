@uploads
Feature: Cloning an uploaded report

  Scenario Outline: Test uploads by creating, uploading, downloading and confirming

    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    #Given I select a report
    And I select the item "Preformatted Text for Copy/Paste Tests"
    And I select all and delete from the multi text item
    And I select the numbered list button
    And I add three lines of text
    And I select the tick or done button
    And I select the item "Single Text"
    And I enter a single line of text "Single line of text entered into the single item text item"
    And I select the tick or done button
    And I select the back arrow
    And I edit the report
    And I select the "This is Multi Text" rating "3" in report view
    #And I select the item "This is Multi Text"
    And I enter multiformatted text
    And I select the tick or done button
    And I select the item "This is Prefilled Text (Single)"
    And I clear the single text field
    And I enter a single line of text "This item was previously prefilled but has now been replaced with this text"
    And I select the tick or done button
    And I select the back arrow
    And I edit the report
    And I select the item "This is Prefilled Text (Multi)"
    And I clear all the text in the Multi Text Prefilled item
    And I enter specific multi text
    And I select the tick or done button
    #And I select the confirm button
    And I select the back arrow
    #And I select the confirm button
    And I edit the report
    And I select the item "This is a Date"
    And I select the month and year at the top
    And I confirm I can move to previous and next year ranges
    And I select a year "2025"
    And I confirm I can move to previous and next year
    And I select a month "SEP"
    And I confirm I can move to previous and next month
    And I select a day "10"
    And I select the tick or done button
    And I select the item "This is a Switch"
    And I select the option "Switch 2"
    And I select the tick or done button
    And I select the item "Multi Select Pick List"
    And I select the option "Option 2"
    And I select the option "Option 3"
    And I select the tick or done button
    And I select the item "This Has Baked In Tokens"
    And I select the tick or done button
    And I select the item "This is Predefined Responses"
    And I select a single predefined response "<response2>"
    And I select the toolbar context menu on "<device>"
    And I select the carriage return button on "<device>"
    And I select a single predefined response "<response3>"
    And I select the toolbar context menu on "<device>"
    And I select the carriage return button on "<device>"
    And I select a single predefined response "<response4>"
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
    And I select the "This is a Rating" rating "N" in report view
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


    Examples:
      | Datacapture          | ReportName                                    | ReferenceText     | ReportDate | DueDate | AddNotes                 | response2                                  | response3                             | response4                                        | device |
      | Test All Controls RM | Mobile - Report Items - Upload tests (Tablet) | Uploads Reference | TODAY      | ONEWEEK | Upload items Extra Notes | Multiple more entries are required to test | Third option specifically for testing | Text the same as the button for testing purposes | tablet |


  Scenario Outline: Clone the uploaded report and confirm
    Given I select the context menu
    And I clone a report "<TargetReport>", "<ReportName>", "<ReferenceText>", "<SelectInspectionDate>", "<InspectionDate>", "<SelectDueDate>", "<DueDate>", "<ExtraNotes>", "<AddNotes>", "<AddPhotos>"
    And I select the back arrow
    And I select the cloned report "<ReportName>"
    And I select the item "Preformatted Text for Copy/Paste Tests"
    And I confirm the specific uploaded text is displayed for the multi text item "Preformatted Text for Copy/Paste Tests"
    And I select the tick or done button
    And I confirm the uploaded value for "Preformatted Text for Copy/Paste Tests" in report view is correct
    And I select the item "Single Text"
    And I confirm the specific uploaded text is displayed for the single text item "This is Single Text"
    And I select the tick or done button
    And I confirm the uploaded value for "This is Single Text" in report view is correct
    And I select the item "This is Multi Text"
    And I confirm the specific uploaded text is displayed for the multi text item "This is Multi Text"
    And I select the tick or done button
    And I confirm the uploaded value for "This is Multi Text" in report view is correct
    And I select the item "This is Multi Text"
    And I confirm the specific uploaded rating "3" is displayed for This is Multi Text
    And I select the tick or done button
    And I confirm the uploaded rating for This is Multi Text Rating holds the correct value in report view
    And I select the item "This is Prefilled Text (Single)"
    And I confirm the specific uploaded text is displayed for the single text item "This is Prefilled Text Single"
    And I select the tick or done button
    And I confirm the uploaded value for "This is Prefilled Text Single" in report view is correct
    And I select the item "This is Prefilled Text (Multi)"
    And I confirm the specific uploaded text is displayed for the multi text item "This is Prefilled Text (Multi)"
    And I select the tick or done button
    And I confirm the uploaded value for "This is Prefilled Text Multi" in report view is correct
    And I select the item "This is a Date"
    And I select the month and year at the top
    And I confirm the uploaded date option "year" is set to "2025"
    And I confirm the uploaded date option "month" is set to "SEP"
    And I confirm the uploaded date option "day" is set to "10"
    And I select the tick or done button
    And I select the item "This is a Switch"
    And I confirm the uploaded "Switch 2" is a selected option for "This is a Switch"
    And I confirm the uploaded "Switch 1" is not a selected option for "This is a Switch"
    And I select the tick or done button
    And I confirm the uploaded value for "This is a Switch" in report view is correct
    And I select the item "Multi Select Pick List"
    And I confirm the uploaded "Option 2" is a selected option for "Multi Select Pick List"
    And I confirm the uploaded "Option 3" is a selected option for "Multi Select Pick List"
    And I select the tick or done button
    And I confirm the uploaded value for "Multi Select Pick List" in report view is correct
    And I select the item "This Has Baked In Tokens"
    And I confirm the specific uploaded text is displayed for the multi text item "This Has Baked In Tokens"
    And I select the tick or done button
    And I confirm the uploaded value for "This Has Baked In Tokens" in report view is correct
    And I select the item "This is Predefined Responses"
    And I confirm the uploaded predefined responses are correct
    And I select the tick or done button
    And I confirm the uploaded value for "This is Predefined Responses" in report view is correct
    And I select the item "This is a Numeric"
    And I confirm the specific uploaded text is displayed for the single text item "This is a Numeric"
    And I select the tick or done button
    And I confirm the uploaded value for "This is a Numeric" in report view is correct
    And I select the item "Enter Bold Text"
    And I confirm the uploaded text in "Enter Bold Text" is correct and formatted correctly
    And I select the tick or done button
    And I confirm the uploaded report view text for "Enter Bold Text" is correct and formatted correctly
    And I select the item "Enter Italics Text"
    And I confirm the uploaded text in "Enter Italics Text" is correct and formatted correctly
    And I select the tick or done button
    And I confirm the uploaded report view text for "Enter Italics Text" is correct and formatted correctly
    And I select the item "Enter Underlined Text"
    And I confirm the uploaded text in "Enter Underlined Text" is correct and formatted correctly
    And I select the tick or done button
    And I confirm the uploaded report view text for "Enter Underlined Text" is correct and formatted correctly
    And I select the item "Enter Multi Formatted Text"
    And I confirm the uploaded text in "Enter Multi Formatted Text" is correct and formatted correctly
    And I confirm the text is correct and formatted correctly
    And I select the tick or done button
    And I confirm the uploaded report view text for "Enter Multi Formatted Text" is correct and formatted correctly
    And I select the item "This is a Rating"
    And I confirm for the uploaded "This is a Rating", "N" is selected
    And I select the tick or done button
    And I confirm the uploaded rating for This is a Rating holds the correct value in report view
    Then I select the back arrow
    And I select the upload button
    And I select upload
    And I confirm the upload has completed
    And I close the upload dialog

    Examples:
      | ReportName                               | ReferenceText           | SelectInspectionDate | InspectionDate   | SelectDueDate | DueDate         | ExtraNotes          | AddNotes | AddPhotos |
      | Mobile - Reports - Clone - Cloned Upload | Reference Cloned Upload | true                 | 14 February 2026 | true          | 31 October 2025 | Cloned upload notes | true     | true      |

