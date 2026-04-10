Feature: Create, then delete a report

  Scenario Outline: Create and delete a report
    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    And I select the back arrow
    When I select the context menu
    And I delete the report
    Then there are no reports listed

    Examples:
      | Datacapture          | ReportName                | ReferenceText           | ReportDate | DueDate | AddNotes                  | response2                                  | response3                             | response4                                        | device |
      | Test All Controls RM | Mobile - Reports - Create | Create Report Reference | TODAY      | ONEWEEK | Create Report Extra Notes | Multiple more entries are required to test | Third option specifically for testing | Text the same as the button for testing purposes | tablet |




