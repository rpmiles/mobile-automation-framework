Feature: Feature

  Scenario Outline: Scenario

    Given I search cloud reports for "Search"
    And I confirm the report "<ReportName>" is listed
    And I confirm the report "<ReportName2>" is listed
    And I confirm the report "<ReportName3>" is listed
    And I clear the cloud report search
    And I search cloud reports for "<ReportName>"
    And I confirm the only report listed is "<ReportName>"
    And I clear the cloud report search
    And I search cloud reports for "<DataCapture>"
    And I confirm a report exists with title "<ReportName2>" and reference "<DataCapture>"
    And I clear the cloud report search
    And I search cloud reports for "<ReferenceText>"
    And I confirm the only report listed is "<ReportName3>"


    Examples:
      | ReportName       | ReportName2       | ReportName3      | DataCapture                 | ReferenceText |
      | Search - Find Me | Search - Found Me | Search - Open Me | TABLE ROW EDITING & CLONING | Open Me       |