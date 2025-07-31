@reportItems
Feature: Testing numeric item

  Scenario Outline: Testing the numeric item with data entry via keyboard entry only

    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<AddNotes>"
    #Given I select a report
    And I select the item "<item>"
    And I check navigation
    And I select the x at the end of the field
    And I enter the value "01"
    And I select the tick or done button
    And I select the item "<item>"
    And I confirm there is a decimal point "<valueDot>"
    And I enter the value "0.123456789000000"
    And I confirm the correct value is listed "0.123456789000000"
    And I select the tick or done button
    And I confirm the data has been saved and reformatted
    And I select the item "<item>"
    And I select the x at the end of the field
    And I enter the value "123456789000000000"
    And I confirm the correct value is listed "123,456,789,000,000,000"
    And I select the x at the end of the field
    And I enter the value "1.230.000"
    And I confirm I am unable to add another decimal point "1.23000"
    And I confirm notes are working correctly
    And I select the item "<item>"
    And I confirm the notes have saved
    And I confirm the correct value is listed in report view
    And I select the back arrow
    Then the list of reports is displayed




    Examples:
      | Datacapture          | ReportName                              | ReferenceText              | AddNotes                     | item              | value0 | value1 | value2 |  | value3 |  | value4 |  | value5 |  | value6 |  | value7 |  | value8 |  | value9 |  | value0 |  | value00 |  | value000 |  | value0000 |  | valueDot |
      | Test All Controls RM | Report Items - Numeric - Keyboard Entry | Numeric Keyboard Reference | Numeric Keyboard Extra Notes | This is a Numeric | 0      | 1      | 2      |  | 3      |  | 4      |  | 5      |  | 6      |  | 7      |  | 8      |  | 9      |  | 0      |  | 00      |  | 000      |  | 0000      |  | .        |