@uploads
Feature: Confirm the values provided are displayed correctly in report view

  Scenario: Confirm report view displaying correctly

    Given I launch the mobile app
    And I edit the report
    And I confirm the value for "Preformatted Text for Copy/Paste Tests", "" is correct in report view
    And I confirm the value for "This is Single Text", "" is correct in report view
    And I confirm the value for "This is Multi Text", "" is correct in report view
    And I confirm the rating "" is displayed for "This is Multi Text" in report view
    And I confirm the value for "This is Prefilled Text Single", "" is correct in report view
    And I confirm the value for "This is Prefilled Text Multi", "" is correct in report view
    And I confirm the date "" for item "This is a Date" holds the correct value in report view
    And I confirm the value for "This is a Switch", "" is correct in report view
    And I confirm the value for "Multi Select Pick List", "" is correct in report view
    And I confirm the value for "This Has Baked In Tokens", "" is correct in report view
    And I confirm the value for "This is Predefined Responses", "" is correct in report view
    And I confirm the value for "This is a Numeric", "" is correct in report view
    And I confirm the text in "Enter Bold Text", "" is correct and formatted correctly in report view
    And I confirm the text in "Enter Italics Text", "" is correct and formatted correctly in report view
    And I confirm the text in "Enter Underlined Text", "" is correct and formatted correctly in report view
    And I confirm the text in "Enter Multi Formatted Text", "" is correct and formatted correctly in report view
    And I confirm the rating "" is displayed in report view for "This is a Rating"
    And I select the back arrow
    And I select the context menu
    And I delete the report
