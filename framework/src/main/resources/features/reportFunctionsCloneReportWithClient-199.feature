Feature: Create a report and assign a Client and when cloning modify the Client

  Scenario Outline: Create report and assign a Client
    Given I Create a full Report "<Datacapture>", "<ProjectRequired>", "<ProjectName>", "<ClientRequired>", "<ClientName>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    And I select the back arrow
    And I select the context menu
    And I select Report Settings
    And I confirm the correct client "<ClientName>" is displayed
    And I select cancel


    Examples:
      | Datacapture          | ProjectRequired | ProjectName         | ClientRequired | ClientName    | ReportName                                               | ReferenceText          | ReportDate | DueDate | AddNotes                 |
      | Test All Controls RM | false           | Smoke Tests Project | true           | Source Client | Mobile - Reports - Modify Client during cloning (Source) | Client Clone Reference | TODAY      | ONEWEEK | Client Clone Extra Notes |


  Scenario Outline: Clone the report selecting a different Client
    Given I select the context menu
    When I clone a report with client and project "<TargetReport>", "<ProjectRequired>", "<ProjectName>", "<ClientRequired>", "<ClientName>", "<ReportName>", "<ReferenceText>", "<SelectInspectionDate>", "<InspectionDate>", "<SelectDueDate>", "<DueDate>", "<ExtraNotes>", "<AddNotes>", "<AddPhotos>"
    And I select the back arrow
    And I select the context menu
    And I delete the report
    And I select the context menu
    And I select Report Settings
    Then I confirm the correct client "<ClientName>" is displayed
    And I select cancel
    And I select the upload button
    And I select upload
    And I confirm the upload has completed
    And I close the upload dialog
    And I select the context menu
    And I remove the report

    Examples:
      | TargetReport                                             | ProjectRequired | ProjectName | ClientRequired | ClientName    | ReportName                                               | ReferenceText                | SelectInspectionDate | InspectionDate   | SelectDueDate | DueDate         | ExtraNotes                        | AddNotes | AddPhotos |
      | Mobile - Reports - Modify Client during cloning (Source) | false           |             | true           | Cloned Client | Mobile - Reports - Modify Client during cloning (Cloned) | Reference Clone Content Only | true                 | 14 February 2026 | true          | 31 October 2026 | Clone report with modified client | false    | false     |


