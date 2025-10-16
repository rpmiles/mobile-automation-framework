Feature: Deleting a report on the homepage (copy paste instances for more than one delete)

    Scenario: Delete a non uploaded report
    #1
    Given I select the context menu
    And I delete the report


  Scenario: Delete non uploaded reports
    #1
    Given I select the context menu
    And I delete the report
    And I select a report
    And I select the back arrow

    #2
    And I select the context menu
    And I delete the report
    And I select a report
    And I select the back arrow

    And I select the context menu
    And I delete the report
    And I select a report
    And I select the back arrow

    And I select the context menu
    And I delete the report
    And I select a report
    And I select the back arrow

    And I select the context menu
    And I delete the report
    And I select a report
    And I select the back arrow

    And I select the context menu
    And I delete the report
    And I select a report
    And I select the back arrow
    #3
    And I select the context menu
    And I delete the report



