Feature: Sandbox feature for testing

  Scenario: Sandboxing
    #Given I login
    #Given the list of reports is displayed
    #When I select a report
    #And Export the preformatted text field in report view
    #And Export the single text field in report view
    #And Export the multi text field in report view
    #And Export the prefilled single field in report view
    #And Export the prefilled multi field in report view
    #And Export the date field in report view
    #And Export the switch field in report view
    #And Export the picklist field in report view
    #And Export the baked in tokens field in report view
    #And Export the predefined responses field in report view
    #And Export the numeric field in report view
    #And Export the enter bold field in report view
    #And Export the enter italics field in report view
    #And Export the enter underlined field in report view
    #And Export the enter multiformat field in report view
    #And Export the rating field in report view##

    Scenario Outline: Enter Text
      When I select a report
      And I select the item "This is Multi Text"
      And I delete all the text
      And I type
      And I copy all the text
      And I delete all the text
      And paste all the text into the notes field







    #And I select the item "Preformatted Text for Copy/Paste Tests"
    #And I select the tick or done button
    #And I select the item "Single Text"
    #And I select the tick or done button
    #And I select the item "This is Multi Text"
    #And I select the tick or done button
    #And I select the item "This is Prefilled Text (Single)"
    #And I select the tick or done button
    #And I select the item "Prefilled Text (Multi)"
    #And I select the tick or done button
    #And I select the item "This is a Date"
    #And I select the tick or done button
    #And I select the item "This is a Switch"
    #And I select the tick or done button
    #And I select the item "This is a Pick List"
    #And I select the tick or done button
    #And I select the item "This Has Baked In Tokens"
    #And I select the tick or done button
    #And I select the item "This is Predefined Responses"
    #And I select the tick or done button
    #And I select the item "This is a Numeric"
    #And I select the tick or done button
    #And I select the item "Enter Bold Text"
    #And I select the tick or done button
    #And I select the item "Enter Italics Text"
    #And I select the tick or done button
    #And I select the item "Enter Underlined Text"
    #And I select the tick or done button
    #And I select the item "Enter Multi Formatted Text"
    #And I select the tick or done button
    #And I select the item "This is a Rating"
    #And I select the tick or done button
    #And I select the item "Multi Sheet Databacked"
    #And I select the tick or done button
    #And I select the item "Motors"
    #And I select the tick or done button
    #And I select the item "Free Text Table"
    #And I select the tick or done button
    #And I select the back arrow

    #And I select the back arrow
    #And the list of reports is displayed
    #And I enter a Reference "Reference 1"
    #And I select an inspection date
    #And I select a due date
    #And I add some notes "Notes 1"
    #Given I select a report
    #And I select the back arrow


    Examples:
      | response2                                  | response3                             | response4                                        |
      | Multiple more entries are required to test | Third option specifically for testing | Text the same as the button for testing purposes |
