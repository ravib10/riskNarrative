@allTests
Feature: 5. Validate all the links on index page are clickable or not.

  Background:
    Given I open "chrome" browser
    And I am on the Home Page of test Website

  @test5
  Scenario: Validate all the links on index page are clickable.
    Then I click on "Return to index"
    And I verify all the links