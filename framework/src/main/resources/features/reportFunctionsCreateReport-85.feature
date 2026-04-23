Feature: Create and upload a report

  Scenario Outline: Create and upload a report
    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    And I select the back arrow
    And I select the upload button
    And I select upload
    When I confirm the upload has completed
    And I close the upload dialog
    And I select the context menu
    Then I remove the report

    Examples:
      | Datacapture          | ReportName                       | ReferenceText           | ReportDate | DueDate | AddNotes                  | response2                                  | response3                             | response4                                        | device |
      | Test All Controls RM | Mobile - Reports - Create Report | Create Report Reference | TODAY      | ONEWEEK | Create Report Extra Notes | Multiple more entries are required to test | Third option specifically for testing | Text the same as the button for testing purposes | tablet |




