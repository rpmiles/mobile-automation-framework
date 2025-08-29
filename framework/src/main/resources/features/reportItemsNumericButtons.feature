@reportItems
Feature: Testing numeric item

  Scenario Outline: Testing the numeric item with data entry via the gui buttons only

    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    #Given I select a report
    And I select the item "<item>"
    And I check navigation
    And I select the x at the end of the field
    And I select the value "<value0>"
    And I select the value "<value1>"
    And I select the tick or done button
    And I select the item "<item>"
    And I confirm there is a decimal point "<valueDot>"
    And I select the value "<value2>"
    And I select the value "<value3>"
    And I select the value "<value4>"
    And I select the value "<value5>"
    And I select the value "<value6>"
    And I select the value "<value7>"
    And I select the value "<value8>"
    And I select the value "<value9>"
    And I select the value "<value00>"
    And I select the value "<value000>"
    And I select the value "<value0000>"
    And I confirm the correct amount is listed "<value0>", "<valueDot>", "<value1>", "<value2>", "<value3>", "<value4>", "<value5>", "<value6>", "<value7>", "<value8>", "<value9>", "<value00>", "<value000>"
    And I select the tick or done button
    And I confirm the data has been saved and reformatted
    And I select the item "<item>"
    And I select the x at the end of the field
    And I select the value "<value1>"
    And I select the value "<value2>"
    And I select the value "<value3>"
    And I select the value "<value4>"
    And I select the value "<value5>"
    And I select the value "<value6>"
    And I select the value "<value7>"
    And I select the value "<value8>"
    And I select the value "<value9>"
    And I select the value "<value00>"
    And I select the value "<value000>"
    And I select the value "<value0000>"
    And I confirm the correct value is listed "123,456,789,000,000,000"
    And I select the x at the end of the field
    And I select the value "<value1>"
    And I select the decimal point "<valueDot>"
    And I select the value "<value2>"
    And I select the value "<value3>"
    And I select the value "<value0000>"
    And I confirm the correct number is listed "<value1>", "<valueDot>", "<value2>", "<value3>", "<value0000>"
    And I select the decimal point "<valueDot>"
    And I confirm another decimal point has not been entered "<value1>", "<valueDot>", "<value2>", "<value3>", "<value0000>"
    And I confirm notes are working correctly
    And I select the item "<item>"
    And I confirm the notes have saved
    And I confirm the correct value is listed in report view
    And I select the back arrow
    And the list of reports is displayed
    And I select the upload button
    And I select upload
    Then I confirm the upload has completed
    And I close the upload dialog
    And I select the context menu
    And I remove the report

    Examples:
      | Datacapture          | ReportName                                           | ReferenceText             | ReportDate | DueDate | AddNotes                    | item              | value0 | value1 | value2 |  | value3 |  | value4 |  | value5 |  | value6 |  | value7 |  | value8 |  | value9 |  | value0 |  | value00 |  | value000 |  | value0000 |  | valueDot |
      | Test All Controls RM | Mobile - Report Items - Numeric - Item Buttons Entry | Numeric Buttons Reference | TODAY      | ONEWEEK | Numeric Buttons Extra Notes | This is a Numeric | 0      | 1      | 2      |  | 3      |  | 4      |  | 5      |  | 6      |  | 7      |  | 8      |  | 9      |  | 0      |  | 00      |  | 000      |  | 0000      |  | .        |

