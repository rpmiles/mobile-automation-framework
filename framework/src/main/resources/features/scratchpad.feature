Feature: Checking another one

  Scenario Outline: Scratchpad
    Given I visit the homepage
    And I open the report search
    And I search for the cloned report "<CloneReportName>"
    And I select the cloned report "<CloneReportName>"
    And I select the edit button


    Examples:
      | SearchReport          | CloneReportName               | Reference            | ReportDate | DueDate | AddNotes                          | item                    | text                                             |
      | Sorting Test - Master | Report Items - Sorting Tables | Table Reordering Ref | TODAY      | TODAY+1 | Single Text Prefilled Extra Notes | #this_is_prefilled_text | Newly added text to a prefilled multi text field |
