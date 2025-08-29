@reportItems
Feature: Report notes testing

  Scenario Outline: Complete indepth testing of an items notes

    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    #Given I select a report
    And I select the item "<item>"
    When I select all the text
    And I copy all the text
    And select the notes icon
    And paste all the text into the notes field
    And enter a specific text "<text>"
    And confirm the formatting has been retained
    And I delete all the text in the Multi Text Prefilled item
    And I select the tick or done button
    And I select the item "<item>"
    And select the notes icon
    And add unformatted text
    And I select all the text
    And I make it bold
    And confirm it is bold
    And I make it italics
    And confirm it's bold italics
    And I remove bold
    And I remove italics
    And I make it underlined
    And confirm it's underlined
    And I make it strikethrough
    And confirm it's underlined strikethrough
    And I delete all the text in the Multi Text Prefilled item
    And I select the numbered list button
    And I add three lines of text
    And I confirm it's in a numbered list
    And I select all the text
    And I select the bullet list button
    And I confirm it's in a bullet list
    And I select the tick or done button
    And I confirm all the correct text is listed in the report view
    And I select the back arrow
    And the list of reports is displayed
    And I select the upload button
    And I select upload
    Then I confirm the upload has completed
    And I close the upload dialog
    And I select the context menu
    And I remove the report

    Examples:
      | Datacapture          | ReportName                                     | ReferenceText           | ReportDate | DueDate | AddNotes                               | item                                   | text                       |
      | Test All Controls RM | Mobile - Report Items - Notes (ReleaseVersion) | Reference Notes Testing | TODAY      | ONEWEEK | Notes for each report item extra notes | Preformatted Text for Copy/Paste Tests | !@$%^&*()_+=-[]}{\?><,./~` |