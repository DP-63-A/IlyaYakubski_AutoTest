Feature: Customer Care testing

  Scenario Outline: Verify functionality of Customer Care page
    Given I am on the Login page
    Then I should see the Envelope button
    And I click the Envelope button
    Then I should see the SEND TO CUSTOMER CARE button
    And I click the SEND TO CUSTOMER CARE button
    Then I should see four error messages
    Then I click the Envelope button again
    And I should see no error messages
    Then I click on the site logo
    Then I should be redirected to the home page

    Examples:
      | message           |
      | Name is required. |