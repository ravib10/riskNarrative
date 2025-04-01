@allTests
Feature: 1. Validate functionality of Submit button on homepage

  Background:
    Given I open "chrome" browser
    And I am on the Home Page of test Website

  @test3
  Scenario: Validate Clicking on Submit button is working.
    Then I click on "Submit"
    And Verify "Form submitted" is appearing on the page
    And Verify "Received!" is appearing on the page
    And Validate the URL of the "Submit" page