Feature: Login Form

  Scenario: Verify availability of LOG IN button
    Given I am on the Login page
    Then I should see the LOG IN button

  Scenario Outline: Login with different credentials
    Given I am on the Login page
    When I enter "<username>" and "<password>"
    And I click the LOG IN button
    Then I should see "<message>"
    And I log out

    Examples:
      | username     | password    | message                                          |
      | OyashiroSama | Humiharahara|                                                  |
      | Fish         | invalid     | The username and password could not be verified. |
      |              |             | Please enter a username and password.            |