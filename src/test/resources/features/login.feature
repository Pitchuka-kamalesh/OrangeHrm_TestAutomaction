Feature: Check the Login function

#  Background:
#    Given I am on the Orange HRM login page

  Scenario Outline: login with Valid or invalid or empty credentials
    Given I have enter "<username>" and "<password>"
    When I click on the login button
    Then It should show an error message indicating "<error>" and "<type>"

    Examples:
      |username|password|error|type|
      |    Admin    | admin123 | Dashboard |valid|
      |   admin     |    admin    |Invalid credentials   |invalid|
      |  Admin      |    admin      |  Invalid credentials    |invalid|
      |        |        |  Required   |invalid                        |
