@reportItems
Feature: Testing report details editing

  Scenario Outline: In depth testing of report details

    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    #Given I select a report
    And I select the back arrow
    And I select the context menu
    And I select Report Settings
    And I delete the report name
    And I enter a report name "<SpecialChars>"
    And I select the logo
    And I select cancel
    And I flip the card
    And I select the context menu
    And I select Report Settings
    And I confirm the report name has not changed "<ReportName>"
    And I delete the report name
    And I enter a report name "<SpecialChars>"
    And I delete the reference
    And I enter "<SpecialChars>" as the report reference
    And I select cancel
    And I confirm the report name has not changed "<ReportName>"
    And I confirm the reference is "<ReferenceText>"
    And I select cancel
    And I flip the card
    And I select the context menu
    And I select Report Settings
    And I delete the report name
    And I enter a report name "<SpecialChars>"
    And I delete the reference
    And I enter a Reference "<SpecialChars>"
    And I select update
    And I flip the card
    And I confirm the reports list report name is "<SpecialChars>"
    And I confirm the reports list reference is "<SpecialChars>"
    And I select the context menu
    And I select Report Settings
    And I confirm the reports list report name is "<SpecialChars>"
    And I confirm the reports list reference is "<SpecialChars>"
    And I enter an invalid inspection date "29 February 2031"
    And I select the reference field
    And I confirm the inspection date is marked as invalid
    And I select an inspection date
    And I enter an invalid due date "29 Feburary 2031"
    And I select the reference field
    And I confirm the due date is marked as invalid
    And I select a due date
    And I clear the report notes field
    And I enter some report notes "<ExtraNotes>"
    And I select update
    And I select Report Settings
    And I confirm the report name has not changed "<SpecialChars>"
    And I confirm the reference is "<SpecialChars>"
    And I confirm the report details inspection date are correct "<ReportDate>"
    And I confirm the report details due date are correct "TWOWEEK"
    And I confirm the report details notes are correct "<ExtraNotes>"
    And I delete the report name
    And I enter a Name "<ReportName>"
    And I select update
    And I flip the card
    And I select the upload button
    And I select upload
    Then I confirm the upload has completed
    And I close the upload dialog
    And I select the context menu
    And I remove the report





    Examples:
      | Datacapture          | ReportName        | ReferenceText     | ReportDate | DueDate | AddNotes            | item            | SpecialChars                  | ExtraNotes                                       |
      | Test All Controls RM | Reports - Details | Reference Details | TODAY      | ONEWEEK | Details Extra Notes | Report Settings | !@£$%^&*()_+-={}][:'\?></.,~` | Extra notes as part of document creation testing |