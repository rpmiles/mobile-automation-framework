Feature: Confirm bulk editing in data backed tables works correctly

  Scenario Outline: Clone Table bulk editing (data backed) report
    Given I select Cloud Reports
    And I search cloud reports for "<TargetReport>"
    And I download the report
    And I wait 1 seconds
    And I select the context menu
    And I clone a report "<TargetReport>", "<ReportName>", "<ReferenceText>", "<SelectInspectionDate>", "<InspectionDate>", "<SelectDueDate>", "<DueDate>", "<ExtraNotes>", "<AddNotes>", "<AddPhotos>"
    And I select the back arrow
    And I close the local search field

    Examples:
      | TargetReport                        | ReportName                                                                   | ReferenceText       | SelectInspectionDate | InspectionDate   | SelectDueDate | DueDate          | ExtraNotes             | AddNotes | AddPhotos |
      | Tables - Bulk Edit Testing - Master | Mobile - Report Items - Tables - Bulk Edit - Non-Databacked (ReleaseVersion) | Bulk edit reference | true                 | 14 February 2029 | true          | 15 February 2029 | Bulk edit tables notes | false    | false     |


  Scenario Outline: Bulk edit two rows for items single text, multi text, multi pick list and switch
    Given I select a specific report "<ReportName>"
    And I select the item "<Item>"
    And I select the checkbox for row 2
    And I select the checkbox for row 3
    And I bulk edit the rows
    And I confirm the bulk edit
    And I select the option "<SingleText>"
    And I scroll to the next field
    And I enter some text into the multi text item "<MultiText>"
    And I scroll to the next field
    And I scroll to the next field
    And I scroll to the next field
    And I select the option "<MultiPickList1>"
    And I select the option "<MultiPickList2>"
    And I scroll to the next field
    And I select the option "<Switch>"
    And I select the tick or done button


    Examples:
      | ReportName                                                                   | Item                          | SingleText | MultiText           | MultiPickList1 | MultiPickList2 | Switch |
      | Mobile - Report Items - Tables - Bulk Edit - Non-Databacked (ReleaseVersion) | All Controls (not databacked) | Single 6   | This is a bulk edit | Option 1       | Option 3       | Yes    |


  Scenario Outline: Confirm the bulk edited fields
    Given I select a specific report "Mobile - Report Items - Tables - Bulk Edit - Non-Databacked (ReleaseVersion)"
    And I select the item "<Item>"
    And I confirm field "single_text" in row <Row> is "<SingleText>"
    And I confirm field "multi_text" in row <Row> is "<MultiText>"
    And I confirm field "pick_list" in row <Row> is "<MultiPickList1>"
    And I confirm field "pick_list" in row <Row> is "<MultiPickList2>"
    And I confirm field "switch" in row <Row> is "<Switch>"
    And I select the tick or done button
    And I select the back arrow

    Examples:
      | Item                          | Row | SingleText | MultiText           | MultiPickList1 | MultiPickList2 | Switch |
      | All Controls (not databacked) | 2   | Single 6   | This is a bulk edit | Option 1       | Option 3       | Yes    |
      | All Controls (not databacked) | 3   | Single 6   | This is a bulk edit | Option 1       | Option 3       | Yes    |


  Scenario Outline: Bulk edit the other columns for the remaining items date, numeric and rating
    Given I select a specific report "<ReportName>"
    And I select the item "<Item>"
    And I select the checkbox for row 1
    And I select the checkbox for row 4
    And I select the checkbox for row 5
    And I bulk edit the rows
    And I confirm the bulk edit
    And I scroll to the next field
    And I scroll to the next field
    And I select the month and year at the top
    And I select a year "<Year>"
    And I confirm I can move to previous and next year
    And I select a month "<Month>"
    And I confirm I can move to previous and next month
    And I select a day "<Day>"
    And I scroll to the next field
    And I select the numeric value "<Numeric>"
    And I select the numeric value "<Numeric>"
    And I select the numeric value "<Numeric>"
    And I scroll to the next field
    And I scroll to the next field
    And I scroll to the next field
    And I select the "Bulk Edit - Rating" rating "<Rating>>"
    And I select the tick or done button
    Then I select the back arrow

    Examples:
      | ReportName                                                                   | Item                          | Year | Month | Day | Numeric | Rating |
      | Mobile - Report Items - Tables - Bulk Edit - Non-Databacked (ReleaseVersion) | All Controls (not databacked) | 2027 | AUG   | 23  | 6       | B      |


  Scenario Outline: Confirm the second bulk edited fields
    Given I select a specific report "Mobile - Report Items - Tables - Bulk Edit - Non-Databacked (ReleaseVersion)"
    And I select the item "<Item>"
    And I confirm field "date" in row <Row> is "<Date>"
    And I confirm field "numeric" in row <Row> is "<Numeric>"
    And I confirm field "rating" in row <Row> is "<Rating>"
    And I select the tick or done button
    And I select the back arrow


    Examples:
      | Item                          | Row | Date           | Numeric | Rating |
      | All Controls (not databacked) | 1   | 23 August 2027 | 666     | B      |
      | All Controls (not databacked) | 4   | 23 August 2027 | 666     | B      |
      | All Controls (not databacked) | 5   | 23 August 2027 | 666     | B      |

