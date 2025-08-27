Feature: Login tests except for Initial login

  Scenario: Login screen is displayed and required fields highlighted
    Given I try and sign in I can't because the sign in button is disabled
    When I select the email address field
    And I select the password field
    And a warning is displayed saying required email
    And I select the email address field
    Then a warning is displayed saying password is required

  Scenario: Email field is validated as an email
    Given I do not enter an email in the email address field
    And I select the password field
    And I am displayed a message saying only emails valid
    And I enter an email in the email address field
    Then I do not get the error saying only emails are valid

  Scenario: If an invalid email is entered with any password a message is displayed
    Given I enter an email without an account as the username
    And I enter a password
    When I select the sign-in button
    Then an error message is displayed saying unable to login

  Scenario: An invalid password is provided with a correct email
    Given I enter a username
    And I enter an incorrect password
    When I select the sign-in button
    Then an error message is displayed saying unable to login

  Scenario: A link will be shown to take the user to an information page on how to sign up with GoReport
    Given I launch the mobile app
    When I select the contact-us page
    Then I am taken to the contact-us page

  Scenario: Successful login and logout
    Given I enter a username
    And I enter a password
    And I select the sign-in button

    And I am met with the Mobile Portal homepage
    And I select the profile menu
    And I sign out
    And I confirm the sign out
    Then I receive a confirmation