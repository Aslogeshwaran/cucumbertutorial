Feature: Verifying the facebook Create Account functionality

  @create
  Scenario: Verifying create account with valid crediantails
    When User clicks the create new button
    Then User enters firstname and lastname
    And User enters emailid or mobilenumber
    And User enter password and confirm password
    And User clicks radio button
    Then User clicks the submit button
