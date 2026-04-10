Feature: Create, upload then remove a report

  Scenario Outline: Remove an uploaded report
    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    And I select the back arrow
    When I select the upload button
    And I select upload
    And I confirm the upload has completed
    And I close the upload dialog
    And I select the context menu
    And I remove the report
    Then there are no reports listed

    Examples:
      | Datacapture          | ReportName                                   | ReferenceText           | ReportDate | DueDate | AddNotes                  | response2                                  | response3                             | response4                                        | device |
      | Test All Controls RM | Mobile - Reports - Remove an uploaded report | Remove Report Reference | TODAY      | ONEWEEK | Create Report Extra Notes | Multiple more entries are required to test | Third option specifically for testing | Text the same as the button for testing purposes | tablet |




