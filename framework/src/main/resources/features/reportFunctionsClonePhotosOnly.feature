Feature: Cloning Reports with all media

  Scenario Outline: Clone a report with all media

    Given I select Cloud Reports
    And I search cloud reports for "<TargetReport>"
    And I download the report
    And I close the local search field
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
    And I confirm the cloned value for "Preformatted Text for Copy/Paste Tests" in report view is correct
    And I confirm the cloned value for "This is Single Text" in report view is correct
    And I confirm the cloned value for "This is Multi Text" in report view is correct
    And I confirm the specific cloned rating "M" is displayed for This is Multi Text
    And I confirm the cloned value for "This is Prefilled Text (Single)" in report view is correct
    And I confirm the cloned value for "This is Prefilled Text (Multi)" in report view is correct
    And I confirm the cloned date "1 May 2025" for item "This is a Date" holds the correct value in report view
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
    And I select the item "This Is Single Text"
    And I select the notes button
    And I confirm there are no notes
    And I select the photo grid
    And I select the image
    And I confirm the image "thisIsSingleTextNotesClone.jpg" is correct for "This is Single Text"
    And I wait 1 seconds
    And I close the image viewer
    And I close the image list
    And I select the tick or done button
    And I select the item "This is Multi Text"
    And I confirm there is audio attached
    And I select the images grid
    And I select the image
    And I confirm the image "thisIsMultiTextClone.jpg" is correct for "This is Multi Text"
    And I close the image viewer
    And I close the image list
    And I select the tick or done button
    And I select the item "This is a Date"
    And I select the notes button
    And I confirm there are no notes
    And I select the images grid
    And I select the image
    And I confirm the image "thisIsDateNotesClone.jpg" is correct for "This is a Date"
    And I close the image viewer
    And I close the image list
    And I select the tick or done button
    And I select the back arrow
    And I select the upload button
    And I select upload
    And I confirm the upload has completed
    And I close the upload dialog
    And I select the context menu
    And I remove the report
    Then I select the context menu
    And I delete the master report

    Examples:
      | TargetReport           | ReportName                     | ReferenceText                  | SelectInspectionDate | InspectionDate   | SelectDueDate | DueDate         | ExtraNotes                   | AddNotes | AddPhotos |
      | Clone Testing - Master | Mobile - Reports - Clone - All | Reference Clone Multi Text All | true                 | 14 February 2026 | true          | 31 October 2025 | Clone report with notes only | false    | true      |


