@allTests
Feature: 1. Validate Presence of all elements

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