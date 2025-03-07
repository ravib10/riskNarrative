How to execute test:
Following mvn command will run all the test scenarios ::
mvn clean test -D"cucumber.filter.tags=@allTests"

How to check the reports:
Report is available at following folder -->target-->positive-->cucumber.html

Following scenarios can also be tested if time permits
1. Verify all the resptive fields on the page are accepting the valid values and Displayig proper error for invalid values.
2. Validate functionality of each page, which appeares on clicking the links on indext.html page.
