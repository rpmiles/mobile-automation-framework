Feature: Add/Remove photo's

  Scenario Outline: Add a photo, confirm the correct photo has been added then delete the photo

    Given I Create a Report "<Datacapture>", "<ReportName>", "<ReferenceText>", "<ReportDate>", "<DueDate>", "<AddNotes>"
    #Given I select a report
    When I select the item "<item>"
    And I select the gallery icon
    And I upload the image containing the description "<ImageDescription>"
    And I select the photo grid
    And I select the image
    And I confirm the image "addRemovePhotos.jpg" is correct for "<item>"
    And I wait 1 seconds
    And I close the image viewer
    And I select the image context menu
    And I delete the image
    And I confirm the photo grid is no longer present
    And I select the tick or done button
    And I select the back arrow
    And I confirm the list of reports is displayed
    And I select the upload button
    And I select upload
    Then I confirm the upload has completed
    And I close the upload dialog
    And I select the context menu
    And I remove the report


    Examples:
      | Datacapture          | ReportName                | ReferenceText                   | ReportDate |  DueDate |  AddNotes            | item               | ImageDescription                |
      | Test All Controls RM | Report Items - Add Images | Image Uploads Reference Details | TODAY      |  ONEWEEK |  Details Extra Notes | This is Multi Text | Photo taken on 9 Jan 2025 12:55 |