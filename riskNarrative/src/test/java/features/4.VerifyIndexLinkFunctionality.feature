@allTests
Feature: 4. Validate Return to index link is active and showing the correct count

  Background:
    Given I open "chrome" browser
    And I am on the Home Page of test Website

  @test4
  Scenario: Validate Clicking on Return to index link is working.
    Then I click on "Return to index"
    And Validate the URL of the "Return to index" page
    And Verify title of the page is "Index of Available Pages"
    And Verify 233 links are appearing on the page