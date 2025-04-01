package steps;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;


public class stepDefination extends BaseStep {
    Properties properties1 = new Properties();
    FileInputStream fs;
    String siteUrl;
    String submitPageUrl;
    String returnToIndexPageUrl;
    HomePage home;

    Scenario scenario;

    @Before
    public void before(Scenario scenario1) {
        this.scenario = scenario1;
    }

    public void initialise() {
        String fileSeperator = System.getProperty("file.separator");
        try {
            fs = new FileInputStream("." + fileSeperator + "src" + fileSeperator + "test" + fileSeperator + "resources" + fileSeperator + "cucumber.properties");
            properties1.load(fs);
            siteUrl = properties1.getProperty("siteUrl");
            submitPageUrl = properties1.getProperty("submitPageUrl");
            returnToIndexPageUrl = properties1.getProperty("returnToIndex");

        } catch (Exception e) {
            System.out.println("Reached in caught exception");
        }

        home = new HomePage();

    }

    @After
    public static void tearDown(Scenario scenario) {

        WebDriver driver = BaseStep.getDriver();
        if (scenario.isFailed()) {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotBytes, "image/png", "snapshotName");
        }
        tearDown();
    }


    @And("I am on the Home Page of test Website")
    public void iAmOnTheHomePageOfTestWebsite() {
        openUrl(siteUrl);
    }

    @And("Verify following are appearing on the page or not")
    public void verifyFollowingAppearingOnThePage(List<String> fieldName) throws Throwable {
        int fieldCount = fieldName.size();
        for (int i = 0; i < fieldCount; i++) {
            Assert.assertTrue(fieldName + " field is not appearing on the page", home.validateFieldsPresence(fieldName.get(i)));

        }
    }

    @And("Verify following radio buttons are appearing on the page or not")
    public void verifyFollowingRadioButtonsAppearingOnThePage(List<String> radioButtons) throws Throwable {
        int fieldCount = radioButtons.size();
        for (int i = 0; i < fieldCount; i++) {
            Assert.assertTrue(radioButtons + " field is not appearing on the page", home.validateRadioCheckboxButtonPresence(radioButtons.get(i)));

        }
    }

    @And("Verify following check box buttons are appearing on the page or not")
    public void verifyFollowingCheckBoxButtonsAppearingOnThePage(List<String> checkBoxButtons) throws Throwable {
        int fieldCount = checkBoxButtons.size();
        for (int i = 0; i < fieldCount; i++) {
            Assert.assertTrue(checkBoxButtons + " field is not appearing on the page", home.validateRadioCheckboxButtonPresence(checkBoxButtons.get(i)));

        }
    }

    @Then("Verify if {string} link is appearing")
    public void verifyIfLinkIsAppearing(String linkName) {
        Assert.assertTrue(home.validateLinkPresence(linkName));

    }



    @And("Verify if {string} button is appearing")
    public void verifyIfButtonIsAppearing(String buttonName) {
        Assert.assertTrue(home.validateFieldsPresence(buttonName));
    }

    @Given("I open {string} browser")
    public void iOpenBrowser(String browser) {
        openBrowser(browser);
        initialise();

    }


    @Then("Verify following are appearing in correct state or not")
    public void verifyFollowingAreAppearingInCorrectStateOrNot(DataTable state) {

        List<List<String>> state1 = state.asLists();
        for (int row = 0; row < state1.size(); row++) {
            for (int column = 1; column < state1.get(0).size(); column++) {
                Assert.assertTrue(state1.get(0).get(0) + " field is not in correct state.", home.validateFieldsState(state1.get(row).get(column - 1).toString(), state1.get(row).get(column).toString()));
            }
        }

    }

    @And("Verify {string} field is appearing disabled")
    public void verifyFieldIsAppearingDisabled(String fieldName) {
        Assert.assertTrue(fieldName + " is not in correct state", home.isEnabled(fieldName));
    }

    @And("Verify {string} field is appearing ReadOnly")
    public void verifyFieldIsAppearingReadOnly(String fieldName) {
        Assert.assertTrue(fieldName + " is not in correct state", home.isReadOnly(fieldName));
    }

    @And("Verify {string} field is displaying {string} value")
    public void verifyFieldIsDisplayingValue(String fieldName, String value) {
        Assert.assertTrue("Incorrect value is appearing in " + fieldName + " field.", home.defaultValue(fieldName, value));
    }

    @And("Verify if {string} option is appearing selected or not")
    public void verifyIfOptionIsAppearingSelectedOrNot(String selectedOptionName) {
        Assert.assertTrue(home.isSelected(selectedOptionName));
    }


    @Then("I click on {string}")
    public void iClickOn(String elementName) {
        Assert.assertTrue(home.click(elementName));
    }

    @And("Verify {string} is appearing on the page")
    public void verifyIsAppearingOnThePage(String text) {
        Assert.assertTrue(text + " text is not appearing on the page", home.validateFieldsPresence(text));

    }

    @And("Validate the URL of the {string} page")
    public void validateTheURLOfThePage(String pageName) {
        if (pageName.contains("Submit"))
            Assert.assertTrue(home.validateURL(submitPageUrl));
        else if (pageName.contains("Return to index"))
            Assert.assertTrue(home.validateURL(returnToIndexPageUrl));
    }

    @And("Verify title of the page is {string}")
    public void verifyTitleOfThePageIs(String title) {
        Assert.assertTrue(home.validateTitle(title));
    }

    @And("Verify {int} links are appearing on the page")
    public void verifyLinksAreAppearingOnThePage(int linkCount) {
        Assert.assertTrue(home.linkCount(linkCount));
    }

    @And("I verify all the links")
    public void iVerifyAllTheLinks() {
        Assert.assertTrue(home.linkValidation());
    }

    @Then("I enter {string} in {string} field")
    public void iEnterInField(String value, String fieldName) {
        Assert.assertTrue(home.enterValue(value,fieldName));
    }

    @Then("I select {string} from {string} dropdown")
    public void iSelectFromDropdown(String value, String dropDownName) {
        Assert.assertTrue(home.selectValueFromDropDown(value,dropDownName));
    }

    @And("I upload sample file")
    public void iUploadSampleFile() {
        Assert.assertTrue(home.uploadSampleFile());
    }

    @Then("I select date {int} days in future")
    public void iSelectDateDaysInFuture(int daysAhead) {
        Assert.assertTrue(home.dateSelection(daysAhead));
    }
}