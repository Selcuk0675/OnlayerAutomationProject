Feature: Demoform
  @Demo
  Scenario: User submits the contact form successfully

    Given I navigate to the homepage
    When I click on the "Demo" button
    And I wait for the page to load
    And I accept the popup by clicking the "Accept All" button
    And I fill in the form fields with data from the properties file:
      | D_Name       | D_Last Name   | D_Work Email    | D_Message  |
    And I select "Turkey" from the country dropdown
    And I click on the "Submit" button
    And I wait for the submission to process
    Then I should see the message "Thanks for submit" at the top of the page