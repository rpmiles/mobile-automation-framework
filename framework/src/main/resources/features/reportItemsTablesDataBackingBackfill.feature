Feature: Data backing back filling

  Scenario Outline: Backfilling values in a data backed table

    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    #Given I select a report
    When I select the item "<item>"
    And I wait 1 seconds
    And I select Add to add a row
    And I wait 1 seconds
    And I select the tick or done button
    And I select the "console" field in row 1
    And I select the table field option "GameGear"
    And I select the tick or done button
    And I confirm field "form_factor" in row 1 is "Handheld"
    And I confirm field "manufacturer" in row 1 is "Sega"
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
      | Datacapture          | ReportName                             | ReferenceText | ReportDate | DueDate | AddNotes                   | item                   |
      | Test All Controls RM | Report Items - Data Backed Backfilling | Reference     | TODAY      | ONEWEEK | DB Backfilling Extra Notes | Multi Sheet Databacked |