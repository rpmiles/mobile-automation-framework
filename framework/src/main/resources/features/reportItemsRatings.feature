Feature: Ratings testing
  @reportItems
  Scenario Outline: Confirm ratings are working correctly

    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    #Given I select a report
    When I select the "<item>" rating "<option1>" in report view
    And I confirm for "<item>" there is now a "<option1>" at the end of the row in report view
    And I select the item "<item>"
    And I confirm for "<item>" the "<option1>" is selected
    And I select the "<item>" rating "<option1>"
    And I confirm all the "<item>" ratings are deselected "<option1>", "<option2>", "<option3>"
    And I select the tick or done button
    And I select the "<item>" rating "<option2>" in report view
    And I confirm for "<item>" there is now a "<option2>" at the end of the row in report view
    And I select the item "<item>"
    And I confirm for "<item>" the "<option2>" is selected
    And I select the "<item>" rating "<option2>"
    And I confirm all the "<item>" ratings are deselected "<option1>", "<option2>", "<option3>"
    And I select the tick or done button
    And I select the "<item>" rating "<option3>" in report view
    And I confirm for "<item>" there is now a "<option3>" at the end of the row in report view
    And I select the item "<item>"
    And I confirm for "<item>" the "<option3>" is selected
    And I select the "<item>" rating "<option3>"
    And I confirm all the "<item>" ratings are deselected "<option1>", "<option2>", "<option3>"
    And I check navigation
    And I select the item "<item>"
    And I select the "<item>" rating "<option1>"
    And I confirm the "<item>" rating "<option2>" is deselected
    And I confirm the "<item>" rating "<option3>" is deselected
    And I select the "<item>" rating "<option3>"
    And I confirm the "<item>" rating "<option1>" is deselected
    And I confirm the "<item>" rating "<option2>" is deselected
    And I select the "<item>" rating "<option2>"
    And I confirm the "<item>" rating "<option1>" is deselected
    And I confirm the "<item>" rating "<option3>" is deselected
    And I confirm notes are working correctly
    And I select the item "<item>"
    And I confirm the notes have saved
    And I select the back arrow
    And the list of reports is displayed
    And I select the upload button
    And I select upload
    Then I confirm the upload has completed
    And I close the upload dialog
    And I select the context menu
    And I remove the report

    Examples:
      | Datacapture          | ReportName                                   | ReferenceText     | ReportDate | DueDate | AddNotes            | item               | option1 | option2 | option3 |
      | Test All Controls RM | Mobile - Report Items - Ratings              | Ratings Reference | TODAY      | ONEWEEK | Ratings Extra Notes | This is a Rating   | Y       | N       | M       |
      #| Test All Controls RM | Mobile - Report Items - Ratings (Multi-Text) | Ratings Reference | TODAY      | ONEWEEK | Ratings Extra Notes | This is Multi Text | 1       | 2       | 3       |