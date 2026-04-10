@uploads
Feature: Confirm the report items have correct values

  Scenario: Confirm report items

    Given I edit the report
    And I select the item "Preformatted Text for Copy/Paste Tests"
    And I confirm the text "" is displayed for the multi text item "Preformatted Text for Copy/Paste Tests"
    And I select the tick or done button
    And I select the item "Single Text"
    And I confirm the text "" is displayed for the single text item "This is Single Text"
    And I select the tick or done button
    And I select the item "This is Multi Text"
    And I confirm the text "" is displayed for the multi text item "This is Multi Text"
    And I select the tick or done button
    And I select the item "This is Multi Text"
    And I confirm the specific rating "" is displayed for "This is Multi Text"
    And I select the tick or done button
    And I select the item "This is Prefilled Text (Single)"
    And I confirm the text "" is displayed for the single text item "This is Prefilled Text Single"
    And I select the tick or done button
    And I select the item "This is Prefilled Text (Multi)"
    And I confirm the text "" is displayed for the multi text item "This is Prefilled Text (Multi)"
    And I select the tick or done button
    And I select the item "This is a Date"
    And I select the month and year at the top
    And I confirm the date option "year" is set to ""
    And I confirm the date option "month" is set to ""
    And I confirm the date option "day" is set to ""
    And I select the tick or done button
    And I select the item "This is a Switch"
    And I confirm "" is a selected option for "This is a Switch"
    And I confirm "" is not a selected option for "This is a Switch"
    And I select the tick or done button
    And I select the item "Multi Select Pick List"
    And I confirm "" is a selected option for "Multi Select Pick List"
    And I confirm "" is a selected option for "Multi Select Pick List"
    And I select the tick or done button
    And I select the item "This Has Baked In Tokens"
    And I confirm the text "" is displayed for the multi text item "This Has Baked In Tokens"
    And I select the tick or done button
    And I select the item "This is Predefined Responses"
    And I confirm the text "" is displayed for the multi text item "This is Predefined Responses"
    And I select the tick or done button
    And I select the item "This is a Numeric"
    And I confirm the text "" is displayed for the single text item "This is a Numeric"
    And I select the tick or done button
    And I select the item "Enter Bold Text"
    And I confirm the text "" in item "Enter Bold Text" is correct and formatted correctly
    And I select the tick or done button
    And I select the item "Enter Italics Text"
    And I confirm the text "" in item "Enter Italics Text" is correct and formatted correctly
    And I select the tick or done button
    And I select the item "Enter Underlined Text"
    And I confirm the text "" in item "Enter Underlined Text" is correct and formatted correctly
    And I select the tick or done button
    And I select the item "Enter Multi Formatted Text"
    And I confirm the text "" in item "Enter Multi Formatted Text" is correct and formatted correctly
    And I select the tick or done button
    And I select the item "This is a Rating"
    And I confirm the specific rating "" is displayed for "This is a Rating"
    And I select the tick or done button
    And I select the back arrow
    And I select the context menu
    And I delete the report