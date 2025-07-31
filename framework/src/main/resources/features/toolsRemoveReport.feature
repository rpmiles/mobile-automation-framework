Feature: Remove a report on the homepage (copy paste instances for more than one delete)

  Scenario: Remove an uploaded report
    #1
    Given I select the context menu
    And I remove the report


  Scenario: Remove reports
    #1
    Given I select the context menu
    And I remove the report
    And I select a report
    And I select the back arrow
    #2
    And I select the context menu
    And I remove the report
    And I select a report
    And I select the back arrow
    #3
    And I select the context menu
    And I remove the report


