Feature: Create a report with Project and Client

  Scenario Outline: Create with Project and Client
    Given I Create a full Report "<Datacapture>", "<ProjectRequired>", "<ProjectName>", "<ClientRequired>", "<ClientName>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    And I select the back arrow
    And I select the context menu
    And I select Report Settings
    And I confirm the correct project "<ProjectName>" is displayed
    And I confirm the correct client "<ClientName>" is displayed
    And I select cancel
    And I select the upload button
    And I select upload
    When I confirm the upload has completed
    And I close the upload dialog
    And I select the context menu
    Then I remove the report

    Examples:
      | Datacapture          | ProjectRequired | ProjectName         | ClientRequired | ClientName         | ReportName                                               | ReferenceText           | ReportDate | DueDate | AddNotes                  | response2                                  | response3                             | response4                                        | device |
      | Test All Controls RM | true            | Smoke Tests Project | true           | Smoke Tests Client | Mobile - Reports - Create Report with Project and Client | Create Report Reference | TODAY      | ONEWEEK | Create Report Extra Notes | Multiple more entries are required to test | Third option specifically for testing | Text the same as the button for testing purposes | tablet |




