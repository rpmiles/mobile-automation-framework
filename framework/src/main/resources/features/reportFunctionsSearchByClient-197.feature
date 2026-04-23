Feature: Create 3 reports and search by Client

  Scenario Outline: Create 3 reports each with a different client
    Given I Create a full Report "<Datacapture>", "<ProjectRequired>", "<ProjectName>", "<ClientRequired>", "<ClientName>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    Then I select the back arrow


    Examples:
      | Datacapture          | ProjectRequired | ProjectName | ClientRequired | ClientName         | ReportName                            | ReferenceText           | ReportDate | DueDate | AddNotes                  |
      | Test All Controls RM | false           |             | true           | B - Test Client 12 | Mobile - Reports - Search by Client 1 | Client Search Reference | TODAY      | ONEWEEK | Client Search Extra Notes |
      | Test All Controls RM | false           |             | true           | B - Test Client 13 | Mobile - Reports - Search by Client 2 | Client Search Reference | TODAY      | ONEWEEK | Client Search Extra Notes |
      | Test All Controls RM | false           |             | true           | B - Test Client 15 | Mobile - Reports - Search by Client 3 | Client Search Reference | TODAY      | ONEWEEK | Client Search Extra Notes |


  Scenario Outline: Search by each different client and confirm only one result
    Given I search for the client "<ClientName>"
    When I confirm the only listed report is "<ReportName>"
    Then I close the local search field


    Examples:
      | ClientName         | ReportName                            |
      | B - Test Client 12 | Mobile - Reports - Search by Client 1 |
      | B - Test Client 13 | Mobile - Reports - Search by Client 2 |
      | B - Test Client 15 | Mobile - Reports - Search by Client 3 |


  Scenario: Upload each report
    Given I select the upload button
    And I select upload
    Then I confirm the upload has completed
    And I close the upload dialog
    And I select the context menu
    And I remove the report
    Given I select the upload button
    And I select upload
    Then I confirm the upload has completed
    And I close the upload dialog
    And I select the context menu
    And I remove the report
    Given I select the upload button
    And I select upload
    Then I confirm the upload has completed
    And I close the upload dialog
    And I select the context menu
    And I remove the report

