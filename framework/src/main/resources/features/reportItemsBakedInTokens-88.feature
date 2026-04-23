Feature: Confirm Baked In Tokens created when report is

  Scenario Outline: Checking Baked In Tokens

    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    #Given I select a report
    When I select the item "<item>"
    And I check navigation
    Then I confirm the Baked In Tokens are displayed correctly
    And I select the tick or done button
    And I select the back arrow
    And I confirm the list of reports is displayed
    And I select the upload button
    And I select upload
    Then I confirm the upload has completed
    And I close the upload dialog
    And I select the context menu
    And I remove the report


    Examples:
      | Datacapture          | ReportName                              | ReferenceText | ReportDate | DueDate | AddNotes        | item                     | AddNotes       |
      | Test All Controls RM | Mobile - Report Items - Baked In Tokens | BIT Reference | TODAY      | ONEWEEK | BIT Extra Notes | This Has Baked In Tokens | BIT extra text |
