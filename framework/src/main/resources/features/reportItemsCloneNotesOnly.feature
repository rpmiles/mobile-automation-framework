Feature: Cloning Reports

  Scenario Outline: Clone a report copying with notes only

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
    And I confirm Preformatted Text for Copy and Paste Tests holds the correct value
    And I confirm the cloned this is single text report view value is correct
    And I confirm the cloned text in Multi Text RTF report view
    And I confirm the cloned text in Single Text Prefilled is correct
    And I confirm the modified text in Multi Text Prefilled is correct
    #NEED MULTI TEXT RATING
    And I confirm the cloned date entry is correct "1 May 2025"
    And I confirm the cloned this is a switch is correct
    And I confirm the cloned single select pick list is correct
    And I confirm the cloned multi select pick list is correct
    And I confirm the cloned this has baked in tokens is correct
    And I confirm the cloned this is predefined responses is correct
    And I confirm the cloned this is a numeric is correct
    And I confirm the cloned enter bold text is correct
    And I confirm the cloned enter italics text is correct
    And I confirm the cloned enter underlined text is correct
    And I confirm the cloned multi formatted text is correct
    And I confirm the cloned this is a rating is correct

    Examples:
      | TargetReport     | ReportName                             | ReferenceText               | SelectInspectionDate | InspectionDate   | SelectDueDate | DueDate         | ExtraNotes                   | AddNotes | AddPhotos |
      | Cloning - Master | Mobile - Reports - Clone - Photos Only | Reference Clone Photos Only | true                 | 14 February 2026 | true          | 31 October 2025 | Clone report with notes only | false    | true      |


