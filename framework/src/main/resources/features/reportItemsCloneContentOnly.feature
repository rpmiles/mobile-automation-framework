Feature: Cloning Reports

  Scenario Outline: Clone a report copying with notes only and including rating in multi text item

    Given I launch the mobile app
    And I select Cloud Reports
    And I search cloud reports for "<TargetReport>"
    And I download the report
    And I close the search field
    And I select the profile menu
    And I sign out
    And I confirm the sign out
    And I enter a username
    And I enter a password
    And I select the sign-in button
    And I select the context menu
    And I clone a report "<TargetReport>", "<ReportName>", "<ReferenceText>", "<SelectInspectionDate>", "<InspectionDate>", "<SelectDueDate>", "<DueDate>", "<ExtraNotes>", "<AddNotes>", "<AddPhotos>"
    And I select the back arrow
    And I select the cloned report "<ReportName>"
    And I confirm the cloned text for Preformatted Text for Copy and Paste Tests in report view are correct
    And I confirm the cloned text in this is single text report view is correct
    And I confirm the cloned text in Multi Text RTF report view is correct
    And I confirm the cloned text in Single Text Prefilled is correct
    And I confirm the modified text in Multi Text Prefilled is correct in report view
    And I confirm the cloned date entry is correct "1 May 2025" in report view
    And I confirm the cloned this is a switch is correct in report view
    And I confirm the cloned single select pick list is correct
    And I confirm the cloned multi select pick list is correct
    And I confirm the cloned this has baked in tokens is correct in report view
    And I confirm the cloned this is predefined responses is correct in report view
    And I confirm the cloned this is a numeric is correct in report view
    And I confirm the cloned enter bold text is correct in report view
    And I confirm the cloned enter italics text is correct in report view
    And I confirm the cloned enter underlined text is correct in report view
    And I confirm the cloned multi formatted text is correct in report view
    And I confirm the cloned this is a rating is correct in report view
    And I select the back arrow
    #And I select the upload button
    #And I select upload
    #And I confirm the upload has completed
    #And I close the upload dialog
    #And I select the context menu
    #And I remove the report
    #Then I select the context menu
    #And I delete the master report


    Examples:
      | TargetReport     | ReportName                              | ReferenceText                | SelectInspectionDate | InspectionDate   | SelectDueDate | DueDate         | ExtraNotes                     | AddNotes | AddPhotos |
      | Cloning - Master | Mobile - Reports - Clone - Content Only | Reference Clone Content Only | true                 | 14 February 2026 | true          | 31 October 2025 | Clone report with content only | false    | false     |



    Scenario Outline: Confirm each cloned item value is correct

      Given I launch the mobile app
      And I edit the report
      And I select the item "Preformatted Text for Copy/Paste Tests"
      And I confirm the cloned text for Preformatted Text for Copy and Paste Tests is correct
      And I select the tick or done button
      And I select the item "Single Text"
      And I confirm the cloned text in this is single text is correct
      And I select the tick or done button
      And I select the item "This is Multi Text"
      And I confirm the cloned text in the item Multi Text RTF is correct
      And I select the tick or done button
      And I select the item "This is Multi Text"
      And I confirm for "This is Multi Text" the "3" rating is selected
      And I select the tick or done button
      And I select the item "This is Prefilled Text (Single)"
      And I confirm the cloned text in the item this is prefilled text single is correct
      And I select the tick or done button
      And I select the item "This is Prefilled Text (Multi)"
      And I confirm the cloned text in the item Multi Text Prefilled is correct
      And I select the tick or done button
      #And I select the item "This is a Date"
      #And I confirm the cloned date entry is correct "1 May 2025"
      #And I select the tick or done button
    #And I select the item "This is a Switch"
    #And I confirm switch "Switch 2" is selected
    #And I confirm switch "Switch 1" is not selected
    #And I select the tick or done button
     # And I confirm the cloned item this is a switch is correct
    #And I select the item "This is a Pick List"
    #And I confirm option "Option 2" is selected
    #And I confirm option "Option 3" is selected
    #And I select the tick or done button
    #And I confirm This is a Pick List holds the correct value
      And I select the item "This Has Baked In Tokens"
      And I confirm the cloned this has baked in tokens is correct
      And I select the tick or done button
      And I select the item "This is Predefined Responses"
      And I confirm the cloned item this is predefined responses is correct
      And I select the tick or done button
      And I select the item "This is a Numeric"
      And I confirm the cloned item this is a numeric is correct
      And I select the tick or done button
      And I select the item "Enter Bold Text"
      And I confirm the cloned item enter bold text is correct
      And I select the tick or done button
      And I select the item "Enter Italics Text"
      And I confirm the cloned item enter italics text is correct
      And I select the tick or done button
      And I select the item "Enter Underlined Text"
      And I confirm the cloned item enter underlined text is correct
      And I select the tick or done button
      And I select the item "Enter Multi Formatted Text"
      And I confirm the cloned item enter multi formatted text is correct
      And I select the tick or done button
      And I select the item "This is a Rating"
      And I confirm the cloned item this is a rating is correct
      And I select the tick or done button
      And I select the back arrow

      Examples:
        | TargetReport     | ReportName                              | ReferenceText                | SelectInspectionDate | InspectionDate   | SelectDueDate | DueDate         | ExtraNotes                     | AddNotes | AddPhotos |
        | Cloning - Master | Mobile - Reports - Clone - Content Only | Reference Clone Content Only | true                 | 14 February 2026 | true          | 31 October 2025 | Clone report with content only | false    | false     |


