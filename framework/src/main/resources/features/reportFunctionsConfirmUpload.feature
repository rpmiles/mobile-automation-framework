@uploads
Feature: Confirm the previously uploaded report has been received and processed successfully

  Scenario Outline: Confirm successful upload

    #Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    #Given I select report
    #Given I select the profile menu
    #And I select sync
    Given I select Cloud Reports
    When I download a specific report with name "Mobile - Report Items - Upload tests"
    And I close the search field
    And I edit the report
    And I select the item "Preformatted Text for Copy/Paste Tests"
    And I confirm it's in a numbered list
    And I select the tick or done button
    And I confirm Preformatted Text for Copy and Paste Tests holds the correct value
    And I select the item "Single Text"
    And I confirm the previously entered Single Text "Single line of text entered into the single item text item"
    And I select the tick or done button
    And I confirm This is Single Text holds the correct value
    And I select the item "This is Multi Text"
    And I confirm all the multi text has been retained
    And I select the tick or done button
    And I confirm This is Multi Text holds the correct value
    And I select the item "This is Multi Text"
    And I confirm for "This is Multi Text" the "3" rating is selected
    And I select the tick or done button
    And I confirm This is Multi Text Rating holds the correct value
    And I select the item "This is Prefilled Text (Single)"
    And I confirm the single text "This item was previously prefilled but has now been replaced with this text" is present
    And I select the tick or done button
    And I confirm This is Prefilled Text (Single) holds the correct value
    And I select the item "This is Prefilled Text (Multi)"
    And I confirm the specific uploaded text is displayed
    And I select the tick or done button
    And I confirm This is Prefilled Text (Multi) holds the correct value
    And I select the item "This is a Date"
    And I select the tick or done button
    And I confirm This is a Date holds the correct value
    #And I select the item "This is a Switch"
    #And I confirm switch "Switch 2" is selected
    #And I confirm switch "Switch 1" is not selected
    #And I select the tick or done button
    And I confirm This is a Switch holds the correct value
    #And I select the item "This is a Pick List"
    #And I confirm option "Option 2" is selected
    #And I confirm option "Option 3" is selected
    #And I select the tick or done button
    #And I confirm This is a Pick List holds the correct value
    And I select the item "This Has Baked In Tokens"
    And I confirm the Baked In Tokens Text
    And I select the tick or done button
    And I confirm This Has Baked In Tokens holds the correct value
    And I select the item "This is Predefined Responses"
    And I confirm the predefined responses are correct
    And I select the tick or done button
    And I confirm This is Predefined Responses holds the correct value
    And I select the item "This is a Numeric"
    And I confirm the correct number is listed
    And I select the tick or done button
    And I confirm This is a Numeric holds the correct value
    And I select the item "Enter Bold Text"
    And I confirm the text is correct and formatted in bold
    And I select the tick or done button
    And I confirm Enter Bold Text holds the correct value
    And I select the item "Enter Italics Text"
    And I confirm the text is correct and formatted in italics
    And I select the tick or done button
    And I confirm Enter Italics Text holds the correct value
    And I select the item "Enter Underlined Text"
    And I confirm the text is correct and formatted in underlined
    And I select the tick or done button
    And I confirm Enter Underlined Text holds the correct value
    And I select the item "Enter Multi Formatted Text"
    And I confirm the text is correct and formatted correctly
    And I select the tick or done button
    And I confirm Enter Multi Formatted Text holds the correct value
    And I select the item "This is a Rating"
    And I confirm for "This is a Rating" the "N" is selected
    And I select the tick or done button
    And I select the back arrow
    And I select the context menu
    And I delete the report



    #And I confirm the entry is the same in report view "Single line of text entered into the single item text item"
    #And I confirm the entered text matches in report view
    ###And I confirm the modified value is displayed in report view "This item was previously prefilled but has now been replaced with this text"
    #And I confirm the specific text is showing in report view
    #And I confirm the correct date is listed in the report view "10 July 2025"
    #And Switch 2 is displayed as the selected option in report view
    #And I confirm the previous option is selected "Option 2"
    #And I confirm the previous option is selected "Option 3"
    #And I confirm the data for predefined responses is correct in report view
    #And I confirm the correct value is listed in report view - simple
    #And I confirm the correct bold text is displayed
    #And I confirm the correct italics text is displayed
    #And I confirm the correct underlined text is displayed
    #And I confirm the correct multiformatted text is displayed
    #And I select the item "<item>"


    Examples:
      | Datacapture          | ReportName                    | ReferenceText | ReportDate | DueDate | AddNotes           | item             |
      | Test All Controls RM | Report Items - Confirm Upload | Reference     | TODAY      | ONEWEEK | Switch Extra Notes | This is a Switch |