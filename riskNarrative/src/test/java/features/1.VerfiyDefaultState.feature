@allTests
Feature: 1. Validate the functionality on homePage

  Background:
    Given I open "chrome" browser
    And I am on the Home Page of test Website


  @test1
  Scenario: Validate all fields,checkboxes, radio buttons, Submit button and hyperlinks are appearing on the page.
    Then Verify following are appearing on the page or not
      | Text input          |
      | Password            |
      | Textarea            |
      | Disabled input      |
      | Readonly input      |
      | Dropdown (select)   |
      | Dropdown (datalist) |
      | File input          |
      | Color picker        |
      | Date picker         |
      | Example range       |
    And Verify following radio buttons are appearing on the page or not
      | Checked checkbox |
      | Default checkbox |
    And Verify following check box buttons are appearing on the page or not
      | Checked radio |
      | Default radio |
    And Verify if "Submit" button is appearing
    And Verify if "Return to index" link is appearing

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

  @test3
  Scenario: Validate Clicking on Submit button is working.
    Then I click on "Submit"
    And Verify "Form submitted" is appearing on the page
    And Verify "Received!" is appearing on the page
    And Validate the URL of the "Submit" page

  @test4
  Scenario: Validate Clicking on Return to index link is working.
    Then I click on "Return to index"
    And Validate the URL of the "Return to index" page
    And Verify title of the page is "Index of Available Pages"
    And Verify 232 links are appearing on the page

  @test5
  Scenario: Validate all the links on index page are clicable.
    Then I click on "Return to index"
    And I verify all the links

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
