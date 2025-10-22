Feature: Validate the photos attached to the Multi Text RTF field

  Scenario Outline: Select the Multi Text RTF field and confirm attached images are correct

    Given I launch the mobile app
    And I select the cloned report "<ReportName>"
    And I select the item "This is Multi Text"
    And I select the photo grid
    And I confirm the correct photos are displayed



      Examples:
        | TargetReport                         | ReportName                                               | ReferenceText               | SelectInspectionDate | InspectionDate   | SelectDueDate | DueDate         | ExtraNotes                   | AddNotes | AddPhotos |
        | Cloning - Master - Multi Text Rating | Mobile - Reports - Clone Multi Text Rating - Photos Only | Reference Clone Photos Only | true                 | 14 February 2026 | true          | 31 October 2025 | Clone report with notes only | false    | true      |

