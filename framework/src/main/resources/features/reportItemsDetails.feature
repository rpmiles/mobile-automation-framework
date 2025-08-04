Feature: Testing report details editing

  Scenario Outline: In depth testing of report details

    #Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    Given I select a report
    And I select the back arrow
    And I select the context menu
    And I select Report Settings
    And I delete the report name
    And I enter a Report Name "<ReportName>"
    And I enter a Reference " "
    And I select the logo
    And I select cancel
    And I flip the card
    And I select the context menu
    And I select Report Settings


    Examples:
      | Datacapture          | ReportName        | ReferenceText     |  ReportDate     | DueDate        |AddNotes            | item            | SpecialChars                  |
      | Test All Controls RM | Reports - Details | Reference Details |  05 August 2025 | 15 August 2025 |Details Extra Notes | Report Settings | !@£$%^&*()_+-={}][:'\?></.,~` |