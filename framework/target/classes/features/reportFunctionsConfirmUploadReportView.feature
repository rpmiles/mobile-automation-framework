@uploads
Feature: Confirm the previously uploaded report has been received and processed successfully

  Scenario: Confirm successful upload

    Given I select the profile menu
    And I select sync
    And I download a specific report with name "Mobile - Report Items - Upload tests"
    And I close the local search field
    And I edit the report
    And I confirm the uploaded text for Preformatted Text for Copy and Paste Tests in report view are correct
    And I confirm the uploaded text for This is Single Text holds the correct value in report view
    And I confirm the uploaded text for This is Multi Text holds the correct value in report view
    And I confirm the uploaded rating for This is Multi Text Rating holds the correct value in report view
    And I confirm the uploaded text for This is Prefilled Text Single holds the correct value in report view
    And I confirm the uploaded text for This is Prefilled Text Multi holds the correct value in report view
    #And I confirm the uploaded date for This is a Date holds the correct value in report view
    And I confirm the uploaded switch for This is a Switch holds the correct value in report view
    And I confirm the uploaded options for Multi Select Pick List holds the correct value in report view
    And I confirm This Has Baked In Tokens holds the correct value
    And I confirm the uploaded predefined responses for This is Predefined Responses holds the correct value in report view
    And I confirm the uploaded number for This is a Numeric holds the correct value in report view
    And I confirm the uploaded text for Enter Bold Text holds the correct value in report view
    And I confirm the uploaded text for Enter Italics Text holds the correct value in report view
    And I confirm the uploaded text for Enter Underlined Text holds the correct value in report view
    And I confirm the uploaded text for Enter Multi Formatted Text holds the correct value in report view
    And I confirm the uploaded rating for This is a Rating holds the correct value in report view
    And I select the back arrow
    And I select the context menu
    And I delete the report
