@uploads
Feature: Confirm the previously uploaded report has been received and processed successfully

  Scenario: Confirm successful upload
    Given I select Cloud Reports
    When I download a specific report with name "Mobile - Report Items - Upload tests"
    And I close the local search field
    And I edit the report
    And I select the item "Preformatted Text for Copy/Paste Tests"
    And I confirm the specific uploaded text is displayed for the multi text item "Preformatted Text for Copy/Paste Tests"
    And I select the tick or done button
    And I confirm the uploaded text for Preformatted Text for Copy and Paste Tests in report view are correct
    And I select the item "Single Text"
    And I confirm the specific uploaded text is displayed for the single text item "This is Single Text"
    And I select the tick or done button
    And I confirm the uploaded text for This is Single Text holds the correct value in report view
    And I select the item "This is Multi Text"
    And I confirm the specific uploaded text is displayed for the multi text item "This is Multi Text"
    And I select the tick or done button
    And I confirm the uploaded text for This is Multi Text holds the correct value in report view
    And I select the item "This is Multi Text"
    And I confirm the specific uploaded rating "3" is displayed for This is Multi Text
    And I select the tick or done button
    And I confirm the uploaded rating for This is Multi Text Rating holds the correct value in report view
    And I select the item "This is Prefilled Text (Single)"
    And I confirm the specific uploaded text is displayed for the single text item "This is Prefilled Text Single"
    And I select the tick or done button
    And I confirm the uploaded text for This is Prefilled Text Single holds the correct value in report view
    And I select the item "This is Prefilled Text (Multi)"
    And I confirm the specific uploaded text is displayed for the multi text item "This is Prefilled Text (Multi)"
    And I select the tick or done button
    And I confirm the uploaded text for This is Prefilled Text Multi holds the correct value in report view
    #And I select the item "This is a Date"
    #And I select the tick or done button
    #And I confirm This is a Date holds the correct value in report view
    And I select the item "This is a Switch"
    And I confirm switch "Switch 2" is selected
    And I confirm switch "Switch 1" is not selected
    And I select the tick or done button
    And I confirm the uploaded switch for This is a Switch holds the correct value in report view
    And I select the item "Multi Select Pick List"
    And I confirm option "Option 2" is selected
    And I confirm option "Option 3" is selected
    And I select the tick or done button
    And I confirm the uploaded options for Multi Select Pick List holds the correct value in report view
    And I select the item "This Has Baked In Tokens"
    And I confirm the specific uploaded text is displayed for the multi text item "This is Baked in Tokens"
    And I select the tick or done button
    And I confirm the uploaded options for Baked in Tokens holds the correct value in report view
    And I select the item "This is Predefined Responses"
    And I confirm the uploaded predefined responses are correct
    And I select the tick or done button
    And I confirm the uploaded predefined responses for This is Predefined Responses holds the correct value in report view
    And I select the item "This is a Numeric"
    And I confirm the specific uploaded text is displayed for the single text item "This is a Numeric"
    And I select the tick or done button
    And I confirm the uploaded number for This is a Numeric holds the correct value in report view
    And I select the item "Enter Bold Text"
    And I confirm the uploaded text in "Enter Bold Text" is correct and formatted correctly
    And I select the tick or done button
    And I confirm the uploaded text for Enter Bold Text holds the correct value in report view
    And I select the item "Enter Italics Text"
    And I confirm the uploaded text in "Enter Italics Text" is correct and formatted correctly
    And I select the tick or done button
    And I confirm the uploaded text for Enter Italics Text holds the correct value in report view
    And I select the item "Enter Underlined Text"
    And I confirm the uploaded text in "Enter Underlined Text" is correct and formatted correctly
    And I select the tick or done button
    And I confirm the uploaded text for Enter Underlined Text holds the correct value in report view
    And I select the item "Enter Multi Formatted Text"
    And I confirm the uploaded text in "Enter Multi Formatted Text" is correct and formatted correctly
    And I confirm the text is correct and formatted correctly
    And I select the tick or done button
    And I confirm the uploaded text for Enter Multi Formatted Text holds the correct value in report view
    And I select the item "This is a Rating"
    And I confirm for "This is a Rating", "N" is selected
    And I select the tick or done button
    And I confirm the uploaded rating for This is a Rating holds the correct value in report view
    And I select the back arrow
    And I select the context menu
    And I delete the report
