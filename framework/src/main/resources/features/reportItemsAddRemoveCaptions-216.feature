Feature: Adding and removing captions

  Scenario Outline: Upload a photo and add a caption on the image list screen
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
    And And I enter the caption "<Message>"
    And I close the image list
    And I select the photo grid
#    And I confirm the correct caption "<Message>" is displayed in the image list
#    And I delete the caption in the image list
#    And I close the image list
#    And I select the photo grid
    And I confirm the caption has been deleted from the image list
    And I close the image list
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
      | Datacapture          | ReportName                                          | ReferenceText | ReportDate | DueDate | AddNotes             | item               | ImageDescription                | Message           |
      | Test All Controls RM | Report Items - Add and Delete Captions (Image List) | Reference     | TODAY      | ONEWEEK | Captions Extra Notes | This is Multi Text | Photo taken on 9 Jan 2025 12:55 | Entered a caption |


  Scenario Outline: Upload and select a photo then add a caption from the full screen image
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
    And I select the image
    And I select the caption link
    And I enter the caption "<Message>" in the caption box
    And I close the image viewer
    And I confirm the correct caption "<Message>" is displayed in the image list
    And I close the image list
    And I select the photo grid
    And I confirm the correct caption "<Message>" is displayed in the image list
    And I select the image
    And I select the caption link
    And I delete the caption in the caption box
    And I close the image viewer
    And I confirm the caption has been deleted from the image list
    And I close the image list
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
      | Datacapture          | ReportName                                             | ReferenceText | ReportDate | DueDate | AddNotes             | item               | ImageDescription                | Message           |
      | Test All Controls RM | Report Items - Add and Delete Captions (Image Display) | Reference     | TODAY      | ONEWEEK | Captions Extra Notes | This is Multi Text | Photo taken on 9 Jan 2025 12:55 | Entered a caption |
