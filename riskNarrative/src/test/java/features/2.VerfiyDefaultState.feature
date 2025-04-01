@allTests
Feature: 1. Validate default state of all elements on homepage.

  Background:
    Given I open "chrome" browser
    And I am on the Home Page of test Website


  @test2
  Scenario: Validate default state of all the elements on the page.
    Then Verify following are appearing in correct state or not
      | Text input  | Blank |
      | Password    | Blank |
      | Date picker | Blank |
    And Verify "Disabled input" field is appearing disabled
    And Verify "Readonly input" field is appearing ReadOnly
    And Verify "Disabled input" field is displaying "Disabled input" value
    And Verify "Readonly input" field is displaying "Readonly input" value
    And Verify "Dropdown (select)" field is displaying "Open this select menu" value
    And Verify "Dropdown (datalist)" field is displaying "Type to search..." value
    And Verify if "Checked checkbox" option is appearing selected or not
    And Verify if "Default checkbox" option is appearing selected or not
    And Verify if "Checked radio" option is appearing selected or not
    And Verify if "Default radio" option is appearing selected or not