Feature: Confirm creating and editing entries in a table works correctly

  Scenario Outline: Create the report
    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    Then I select the back arrow

    Examples:
      | Datacapture          | ReportName                          | ReferenceText    | ReportDate | DueDate | AddNotes           |
      | Test All Controls RM | Report Items - Tables Create & Edit | Tables Reference | TODAY      |         | Tables Extra Notes |


  Scenario Outline: Enter Rows
    Given I select a report
    When I select the item "Multi Sheet Databacked"
    And I wait 1 seconds
    And I select Add to add a row
    And I wait 1 seconds
    And I select the table field option "<Manufacturer>"
    And I select the table field option "<Form Factor>"
    And I select the table field option "<Console>"
    And I select the table field option "<Active>"
    And I select the table field option "<Franchise>"
    And I select the table field option "<Game>"
    And I select the table field option "<Remastered>"
    And I select the table field option "<Rebooted>"
    And I select the table field option "<Planned>"
    And I enter some text into the multi text item "<GameNotes>"
    And I close the row editor
    And I close the table
    Then I select the back arrow

    Examples:
      | Manufacturer | Form Factor | Console   | Active | Franchise       | Game                         | Remastered | Rebooted | Planned | GameNotes                    |
      | Sega         | Console     | Megadrive | No     | Sonic           | Sonic the Hedgehog           | No         | No       | None    | This is some text            |
      | Nintendo     | Handheld    | 3DS       | No     | Animal Crossing | Animal Crossing New Leaf     | No         | No       | Reboot  | Just Nintendo being Nintendo |
      | Sony         | Console     | PS5       | Yes    | Dead Space      | Dead Space                   | No         | Yes      | None    | Amazing                      |
      | Sony         | Console     | PS3       | No     | Call of Duty    | Call of Duty: Modern Warfare | No         | No       | Reboot  | Classic                      |


  Scenario Outline: Confirm the entered rows
    Given I select a report
    When I select the item "Multi Sheet Databacked"
    And I wait 1 seconds
    And I confirm field "manufacturer" in row <Row> is "<Manufacturer>"
    And I confirm field "form_factor" in row <Row> is "<Form Factor>"
    And I confirm field "console" in row <Row> is "<Console>"
    And I confirm field "active" in row <Row> is "<Active>"
    And I confirm field "franchise" in row <Row> is "<Franchise>"
    And I confirm field "game" in row <Row> is "<Game>"
    And I confirm field "remastered" in row <Row> is "<Remastered>"
    And I confirm field "rebooted" in row <Row> is "<Rebooted>"
    And I confirm field "planned" in row <Row> is "<Planned>"
    And I confirm field "game_notes" in row <Row> is "<GameNotes>"
    And I close the table
    Then I select the back arrow

    Examples:
      | Row | Manufacturer | Form Factor | Console   | Active | Franchise       | Game                         | Remastered | Rebooted | Planned | GameNotes                    |
      | 1   | Sega         | Console     | Megadrive | No     | Sonic           | Sonic the Hedgehog           | No         | No       | None    | This is some text            |
      | 2   | Nintendo     | Handheld    | 3DS       | No     | Animal Crossing | Animal Crossing New Leaf     | No         | No       | Reboot  | Just Nintendo being Nintendo |
      | 3   | Sony         | Console     | PS5       | Yes    | Dead Space      | Dead Space                   | No         | Yes      | None    | Amazing                      |
      | 4   | Sony         | Console     | PS3       | No     | Call of Duty    | Call of Duty: Modern Warfare | No         | No       | Reboot  | Classic                      |


  Scenario Outline: Add another row and confirm
    Given I select a report
    When I select the item "Multi Sheet Databacked"
    And I wait 1 seconds
    And I select Add to add a row
    And I wait 1 seconds
    And I select the table field option "<Manufacturer>"
    And I select the table field option "<Form Factor>"
    And I select the table field option "<Console>"
    And I select the table field option "<Active>"
    And I select the table field option "<Franchise>"
    And I select the table field option "<Game>"
    And I select the table field option "<Remastered>"
    And I select the table field option "<Rebooted>"
    And I select the table field option "<Planned>"
    And I enter some text into the multi text item "<GameNotes>"
    And I close the row editor
    And I close the table
    And I select the item "Multi Sheet Databacked"
    And I wait 1 seconds
    And I confirm field "manufacturer" in row <Row> is "<Manufacturer>"
    And I confirm field "form_factor" in row <Row> is "<Form Factor>"
    And I confirm field "console" in row <Row> is "<Console>"
    And I confirm field "active" in row <Row> is "<Active>"
    And I confirm field "franchise" in row <Row> is "<Franchise>"
    And I confirm field "game" in row <Row> is "<Game>"
    And I confirm field "remastered" in row <Row> is "<Remastered>"
    And I confirm field "rebooted" in row <Row> is "<Rebooted>"
    And I confirm field "planned" in row <Row> is "<Planned>"
    And I confirm field "game_notes" in row <Row> is "<GameNotes>"
    Then I select the checkbox for row 3
    And I select the checkbox for row 5
    And I clone the table rows
    And I wait 1 seconds
    And I close the table
    Then I select the back arrow

    Examples:
      | Row | Manufacturer | Form Factor | Console | Active | Franchise       | Game                             | Remastered | Rebooted | Planned | GameNotes            |
      | 5   | Nintendo     | Handheld    | 3DS     | No     | Legend of Zelda | Legend of Zelda: Ocarina of Time | Yes        | No       | None    | Best Zelda game made |


  Scenario Outline: Confirm the two cloned rows
    Given I select a report
    When I select the item "Multi Sheet Databacked"
    And I wait 1 seconds
    And I confirm field "manufacturer" in row <Row> is "<Manufacturer>"
    And I confirm field "form_factor" in row <Row> is "<Form Factor>"
    And I confirm field "console" in row <Row> is "<Console>"
    And I confirm field "active" in row <Row> is "<Active>"
    And I confirm field "franchise" in row <Row> is "<Franchise>"
    And I confirm field "game" in row <Row> is "<Game>"
    And I confirm field "remastered" in row <Row> is "<Remastered>"
    And I confirm field "rebooted" in row <Row> is "<Rebooted>"
    And I confirm field "planned" in row <Row> is "<Planned>"
    And I confirm field "game_notes" in row <Row> is "<GameNotes>"
    And I wait 1 seconds
    And I close the table
    Then I select the back arrow

    Examples:
      | Row | Manufacturer | Form Factor | Console | Active | Franchise       | Game                             | Remastered | Rebooted | Planned | GameNotes            |
      | 6   | Sony         | Console     | PS5     | Yes    | Dead Space      | Dead Space                       | No         | Yes      | None    | Amazing              |
      | 7   | Nintendo     | Handheld    | 3DS     | No     | Legend of Zelda | Legend of Zelda: Ocarina of Time | Yes        | No       | None    | Best Zelda game made |


  Scenario Outline: Delete a row and confirm deleted
    Given I select a report
    When I select the item "Multi Sheet Databacked"
    And I wait 1 seconds
    And I select the checkbox for row 6
    And I delete the row
    And I wait 2 seconds
    And I confirm field "manufacturer" in row <Row> is "<Manufacturer>"
    And I confirm field "form_factor" in row <Row> is "<Form Factor>"
    And I confirm field "console" in row <Row> is "<Console>"
    And I confirm field "active" in row <Row> is "<Active>"
    And I confirm field "franchise" in row <Row> is "<Franchise>"
    And I confirm field "game" in row <Row> is "<Game>"
    And I confirm field "remastered" in row <Row> is "<Remastered>"
    And I confirm field "rebooted" in row <Row> is "<Rebooted>"
    And I confirm field "planned" in row <Row> is "<Planned>"
    And I confirm field "game_notes" in row <Row> is "<GameNotes>"
    And I close the row editor
    Then I select the back arrow

    Examples:
      | Row | Manufacturer | Form Factor | Console | Active | Franchise       | Game                             | Remastered | Rebooted | Planned | GameNotes            |
      | 6   | Nintendo     | Handheld    | 3DS     | No     | Legend of Zelda | Legend of Zelda: Ocarina of Time | Yes        | No       | None    | Best Zelda game made |



  Scenario: Modify a row
    Given I select a report
    When I select the item "Multi Sheet Databacked"
    And I wait 2 seconds
    And I select the "console" field in row 3
    And I confirm "PS5" is a selected option for "Console"
    And I select the table field option "PS5"
    And I select the table field option "PS2"
    And I select the table field option "No"
    And I select the table field option "Dead Space"
    And I select the table field option "Dead Space"
    And I select the table field option "Dead Space 2"
    And I select the table field option "No"
    And I select the table field option "No"
    And I select the table field option "No"
    And I select the table field option "None"
    And I wait 1 seconds
    And I clear the text
    And I enter some text into the multi text item "If only this was on PS2 really"
    And I close the row editor
    And I close the table
    Then I select the back arrow



  Scenario Outline: Confirm the modified row has saved
    Given I select a report
    When I select the item "Multi Sheet Databacked"
    And I wait 1 seconds
    And I confirm field "manufacturer" in row <Row> is "<Manufacturer>"
    And I confirm field "form_factor" in row <Row> is "<Form Factor>"
    And I confirm field "console" in row <Row> is "<Console>"
    And I confirm field "active" in row <Row> is "<Active>"
    And I confirm field "franchise" in row <Row> is "<Franchise>"
    And I confirm field "game" in row <Row> is "<Game>"
    And I confirm field "remastered" in row <Row> is "<Remastered>"
    And I confirm field "rebooted" in row <Row> is "<Rebooted>"
    And I confirm field "planned" in row <Row> is "<Planned>"
    And I confirm field "game_notes" in row <Row> is "<GameNotes>"

    Examples:
      | Row | Manufacturer | Form Factor | Console | Active | Franchise  | Game         | Remastered | Rebooted | Planned | GameNotes                      |
      | 3   | Sony         | Console     | PS2     | No     | Dead Space | Dead Space 2 | No         | No       | None    | If only this was on PS2 really |

