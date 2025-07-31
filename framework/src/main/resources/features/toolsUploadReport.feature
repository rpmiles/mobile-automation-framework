Feature: Testing report uploads

  Scenario: Test uploads by creating, uploading, downloading and confirming

    Given I select the upload button
    And I select upload
    Then I confirm the upload has completed
    And I close the upload dialog

