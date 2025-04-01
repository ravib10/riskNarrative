@allTests
Feature: 6. Validate All the fields on homepage is accepting the values.

  Background:
    Given I open "chrome" browser
    And I am on the Home Page of test Website

  @test6
  Scenario: Validate user can enter the values in respective fields
    Then I enter "textField" in "Text input" field
    Then I enter "password" in "Password" field
    Then I enter "TextArea" in "Textarea" field
    Then I select "One" from "Dropdown (select)" dropdown
    Then I select "New York" from "Dropdown (datalist)" dropdown
    And I upload sample file
    Then I select date 7 days in future
    Then I click on "Submit"
