Feature: Create a report and assign a Client

  Scenario Outline: Create report and assign a Client
    Given I Create a full Report "<Datacapture>", "<ProjectRequired>", "<ProjectName>", "<ClientRequired>", "<ClientName>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    And I select the back arrow
    And I select the context menu
    And I select Report Settings
    And I confirm the correct client "<ClientName>" is displayed
    And I select cancel
    And I select the upload button
    And I select upload
    When I confirm the upload has completed
    And I close the upload dialog
    And I select the context menu
    Then I remove the report

    Examples:
      | Datacapture          | ProjectRequired | ProjectName         | ClientRequired | ClientName         | ReportName                                   | ReferenceText           | ReportDate | DueDate | AddNotes                  |
      | Test All Controls RM | false           | Smoke Tests Project | true           | Smoke Tests Client | Mobile - Reports - Create Report with Client | Create Report Reference | TODAY      | ONEWEEK | Create Report Extra Notes |




