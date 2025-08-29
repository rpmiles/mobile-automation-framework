Feature: Cloning Reports

  Scenario Outline: Clone a report copying including all media

    Given I clone a report "<TargetReport>", "<ReportName>", "<ReferenceText>", "<SelectInspectionDate>", "<InspectionDate>", "<SelectDueDate>", "<DueDate>", "<ExtraNotes>", "<AddNotes>", "<AddPhotos>"
    #And I perform an initial sync
    #Then I am met with the Mobile Portal homepage

    Examples:
      | TargetReport       | ReportName                            | ReferenceText              | SelectInspectionDate | InspectionDate   | SelectDueDate | DueDate         | ExtraNotes                   | AddNotes | AddPhotos |
      | Cloning - Template | Mobile - Reports - Clone - Notes Only | Reference Clone Notes Only | true                 | 14 February 2026 | true          | 31 October 2025 | Clone report with notes only | true     | false     |


