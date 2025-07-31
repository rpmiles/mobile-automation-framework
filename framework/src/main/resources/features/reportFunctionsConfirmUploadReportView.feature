Feature: Confirm the previously uploaded report has been received and processed successfully

  Scenario: Confirm successful upload

    Given I select the profile menu
    And I select sync
    And I download a specific report with name "Report Items"
    And I select the report which the title contains "Report Items"
    And I confirm Preformatted Text for Copy and Paste Tests holds the correct value
    And I select the Preformatted Text for Copy and Paste Tests field
    And I confirm This is Single Text holds the correct value
    And I confirm This is Multi Text holds the correct value
    And I confirm This is Multi Text Rating holds the correct value
    And I confirm This is Prefilled Text (Single) holds the correct value
    And I confirm This is Prefilled Text (Multi) holds the correct value
    And I confirm This is a Date holds the correct value
    And I confirm This is a Switch holds the correct value
    And I confirm This is a Pick List holds the correct value
    And I confirm This Has Baked In Tokens holds the correct value
    And I confirm This is Predefined Responses holds the correct value
    And I confirm This is a Numeric holds the correct value
    And I confirm Enter Bold Text holds the correct value
    And I confirm Enter Italics Text holds the correct value
    And I confirm Enter Underlined Text holds the correct value
    And I confirm Enter Multi Formatted Text holds the correct value
    And I confirm This is a Rating holds the correct value

