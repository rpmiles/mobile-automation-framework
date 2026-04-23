Feature: Create 3 reports and search by Client

  Scenario Outline: Create 3 reports each with a different client
    Given I Create a full Report "<Datacapture>", "<ProjectRequired>", "<ProjectName>", "<ClientRequired>", "<ClientName>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    Then I select the back arrow


    Examples:
      | Datacapture          | ProjectRequired | ProjectName     | ClientRequired | ClientName | ReportName                             | ReferenceText           | ReportDate | DueDate | AddNotes                   |
      | Test All Controls RM | true            | Test Project 25 | false          |            | Mobile - Reports - Search by Project 1 | Project Search Reference | TODAY      | ONEWEEK | Project Search Extra Notes |
      | Test All Controls RM | true            | Test Project 26 | false          |            | Mobile - Reports - Search by Project 2 | Project Search Reference | TODAY      | ONEWEEK | Project Search Extra Notes |
      | Test All Controls RM | true            | Test Project 27 | false          |            | Mobile - Reports - Search by Project 3 | Project Search Reference | TODAY      | ONEWEEK | Project Search Extra Notes |


  Scenario Outline: Search by each different client and confirm only one result
    Given I search for the client "<ProjectName>"
    When I confirm the only listed report is "<ReportName>"
    Then I close the local search field


    Examples:
      | ProjectName     | ReportName                             |
      | Test Project 25 | Mobile - Reports - Search by Project 1 |
      | Test Project 26 | Mobile - Reports - Search by Project 2 |
      | Test Project 27 | Mobile - Reports - Search by Project 3 |


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

