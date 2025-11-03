Feature: Cloning Reports

  Scenario Outline: Clone a report copying with notes only and including rating in multi text item

    Given I launch the mobile app
    #And I select Cloud Reports
    #And I search cloud reports for "<TargetReport>"
    #And I download the report
    #And I close the local search field
    #And I select the profile menu
    #And I sign out
    #And I confirm the sign out
    #And I enter a username
    #And I enter a password
    #And I select the sign-in button
    #And I select the context menu
    #And I clone a report "<TargetReport>", "<ReportName>", "<ReferenceText>", "<SelectInspectionDate>", "<InspectionDate>", "<SelectDueDate>", "<DueDate>", "<ExtraNotes>", "<AddNotes>", "<AddPhotos>"
    #And I select the back arrow
    And I select the cloned report "<ReportName>"
    And I confirm the cloned value for "Preformatted Text for Copy/Paste Tests" in report view is correct
    And I confirm the cloned value for "This is Single Text" in report view is correct
    And I confirm the cloned value for "This is Multi Text" in report view is correct
    And I confirm the specific cloned rating "M" is displayed for This is Multi Text
    And I confirm the cloned value for "This is Prefilled Text (Single)" in report view is correct
    And I confirm the cloned value for "This is Prefilled Text (Multi)" in report view is correct
    #And I confirm the cloned date entry is correct "1 May 2025" in report view
    And I confirm the cloned value for "This is a Switch" in report view is correct
    And I confirm the cloned value for "Single Select Pick List" in report view is correct
    And I confirm the cloned value for "Multi Select Pick List" in report view is correct
    And I confirm the cloned value for "This Has Baked In Tokens" in report view is correct
    And I confirm the cloned value for "This is Predefined Responses" in report view is correct
    And I confirm the cloned value for "This is a Numeric" in report view is correct
    And I confirm the cloned report view text for "Enter Bold Text" is correct and formatted correctly
    And I confirm the cloned report view text for "Enter Italics Text" is correct and formatted correctly
    And I confirm the cloned report view text for "Enter Underlined Text" is correct and formatted correctly
    And I confirm the cloned report view text for "Enter Multi Formatted Text" is correct and formatted correctly
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
      And I confirm the specific cloned text is displayed for the multi text item "Preformatted Text for Copy/Paste Tests"
      And I select the tick or done button
      And I select the item "Single Text"
      And I confirm the specific cloned text is displayed for the single text item "This is Single Text"
      And I select the tick or done button
      And I select the item "This is Multi Text"
      And I confirm the specific cloned text is displayed for the multi text item "This is Multi Text"
      And I select the tick or done button
      And I select the item "This is Multi Text"
      And I confirm the specific cloned rating "M" is displayed for This is Multi Text
      And I select the tick or done button
      And I select the item "This is Prefilled Text (Single)"
      And I confirm the specific cloned text is displayed for the single text item "This is Prefilled Text (Single)"
      And I select the tick or done button
      And I select the item "This is Prefilled Text (Multi)"
      And I confirm the specific cloned text is displayed for the multi text item "This is Prefilled Text (Multi)"
      And I select the tick or done button
      #And I select the item "This is a Date"
      #And I confirm the cloned date entry is correct "1 May 2025"
      #And I select the tick or done button
      And I select the item "This is a Switch"
      And I confirm switch "Switch 2" is selected
      And I confirm switch "Switch 1" is not selected
      And I select the tick or done button
      And I select the item "Multi Select Pick List"
      And I confirm option "Option 3" is selected
      And I confirm option "Option 4" is selected
      And I select the tick or done button
      And I select the item "This Has Baked In Tokens"
      And I confirm the specific cloned text is displayed for the multi text item "This Has Baked In Tokens"
      And I select the tick or done button
      And I select the item "This is Predefined Responses"
      And I confirm the specific cloned text is displayed for the multi text item "This is Predefined Responses"
      And I select the tick or done button
      And I select the item "This is a Numeric"
      And I confirm the specific cloned text is displayed for the single text item "This is a Numeric"
      And I select the tick or done button
      And I select the item "Enter Bold Text"
      And I confirm the cloned text in "Enter Bold Text" is correct and formatted correctly
      And I select the tick or done button
      And I select the item "Enter Italics Text"
      And I confirm the cloned text in "Enter Italics Text" is correct and formatted correctly
      And I select the tick or done button
      And I select the item "Enter Underlined Text"
      And I confirm the cloned text in "Enter Underlined Text" is correct and formatted correctly
      And I select the tick or done button
      And I select the item "Enter Multi Formatted Text"
      And I confirm the cloned text in "Enter Multi Formatted Text" is correct and formatted correctly
      And I select the tick or done button
      And I select the item "This is a Rating"
      And I confirm the cloned rating "M" is correct for "This is a Rating"
      And I select the tick or done button
      And I select the back arrow

      Examples:
        | TargetReport     | ReportName                              | ReferenceText                | SelectInspectionDate | InspectionDate   | SelectDueDate | DueDate         | ExtraNotes                     | AddNotes | AddPhotos |
        | Cloning - Master | Mobile - Reports - Clone - Content Only | Reference Clone Content Only | true                 | 14 February 2026 | true          | 31 October 2025 | Clone report with content only | false    | false     |


