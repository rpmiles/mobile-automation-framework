@reportItems
Feature: Single text item testing

  Scenario Outline: Test 'Single Text' item
    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<AddNotes>"
    #Given I select a report
    When I select the item "<item>"
    And I check navigation
    And I select the crosshairs icon
    And I return to the report
    And I select the item "<item>"
    And I confirm the location coordinates have saved
    And I confirm notes are working correctly
    And I select the item "<item>"
    And I confirm the notes have saved
    And I select the back arrow
    Then the list of reports is displayed


    Examples:
      | Datacapture          | ReportName                         | ReferenceText                 | AddNotes                        | item                |
      | Test All Controls RM | Report Items - Single Text Feature | Single Text Feature Reference | Single Text Feature Extra Notes | This is Single Text |

  #https://nominatim.openstreetmap.org/reverse?format=jsonv2&lat=50.9034045&lon=--3.4871714
