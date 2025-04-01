package pages;

import Constants.constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import steps.BaseStep;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HomePage {

    @FindBy(name = "my-text")
    WebElement textInput;
    @FindBy(name = "my-password")
    WebElement password;
    @FindBy(name = "my-textarea")
    WebElement textarea;
    @FindBy(name = "my-disabled")
    WebElement disabledInput;
    @FindBy(name = "my-readonly")
    WebElement readonlyInput;

    @FindBy(name = "my-select")
    WebElement dropdownSelect;
    @FindBy(name = "my-datalist")
    WebElement dropdownDatalist;
    @FindBy(name = "my-file")
    WebElement fileInput;

    @FindBy(name = "my-date")
    WebElement datePicker;
    @FindBy(id = "my-check-1")
    WebElement checkedCheckBox;
    @FindBy(id = "my-check-2")
    WebElement unCheckedCheckBox;
    @FindBy(id = "my-radio-1")
    WebElement checkedRadioButton;
    @FindBy(id = "my-radio-2")
    WebElement unCheckedRadioButton;
    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submit;
    @FindBy(partialLinkText = "Return to index")
    WebElement returnToIndex;

    @FindBy(tagName = "a")
    List<WebElement> allLinks;

    WebDriver driver = BaseStep.getDriver();
    boolean isElementPresent = false;
    boolean isElementInCorrectState = false;

    public HomePage() {
        PageFactory.initElements(BaseStep.getDriver(), this);

    }

    public boolean validateFieldsPresence(String fieldName) {
        isElementPresent = false;
        if (driver.findElement(By.xpath("//*[contains(text(),'" + fieldName + "')]")).isDisplayed())
            isElementPresent = true;
        return isElementPresent;

    }

    public boolean validateRadioCheckboxButtonPresence(String name) {
        if (driver.findElement(By.xpath("//label[normalize-space()='Checked radio']")).isDisplayed())
            isElementPresent = true;
        return isElementPresent;

    }

    public boolean validateLinkPresence(String linkName) {
        if (driver.findElement(By.partialLinkText(linkName)).isDisplayed())
            isElementPresent = true;
        return isElementPresent;

    }

    public boolean validateFieldsState(String fieldName, String fieldState) {
        isElementInCorrectState = false;
        if (fieldState.equalsIgnoreCase(constant.blank)) {
            if (driver.findElement(By.xpath("//*[contains(text(),'" + fieldName + "')]/input")).getText().equalsIgnoreCase("")) {
                isElementInCorrectState = true;
            }

        } else if (fieldState.equalsIgnoreCase(constant.blankTextArea)) {
            if (driver.findElement(By.xpath("//*[contains(text(),'" + fieldName + "')]/textarea")).getText().equalsIgnoreCase("")) {
                isElementInCorrectState = true;
            }
        }
        return isElementInCorrectState;
    }

    public boolean isEnabled(String fieldName) {
        if (fieldName.equalsIgnoreCase(constant.disabledInput)) {
            if (!disabledInput.isEnabled()) {
                isElementInCorrectState = true;
            }
        }
        return isElementInCorrectState;
    }

    public boolean isReadOnly(String fieldName) {
        if (fieldName.equalsIgnoreCase(constant.readOnlyInput)) {
            String attribute = readonlyInput.getDomAttribute("readonly");
            if (Boolean.valueOf(attribute)) {
                isElementInCorrectState = true;
            }
        }
        return isElementInCorrectState;
    }

    public boolean defaultValue(String fieldName, String value) {
        boolean correctValue = false;
        if (fieldName.equalsIgnoreCase(constant.readOnlyInput)) {
            String defaultValue = readonlyInput.getDomAttribute("value");
            if (defaultValue.equalsIgnoreCase(value)) {
                correctValue = true;
            }
        } else if (fieldName.equalsIgnoreCase(constant.disabledInput)) {
            String defaultValue = disabledInput.getDomAttribute("placeholder");
            if (defaultValue.equalsIgnoreCase(value)) {
                correctValue = true;
            }
        } else if (fieldName.equalsIgnoreCase(constant.drapDownSelect)) {
            String defaultValue = dropdownSelect.findElement(By.xpath("//option[1]")).getDomAttribute("selected");
            if (Boolean.valueOf(defaultValue)) {
                correctValue = true;
            }
        } else if (fieldName.equalsIgnoreCase(constant.dropDownDataList)) {
            String defaultValue = dropdownDatalist.getDomAttribute("placeholder");
            if (defaultValue.equalsIgnoreCase(value)) {
                correctValue = true;
            }
        }
        return correctValue;
    }

    public boolean isSelected(String selectedOptionName) {
        boolean isSelected = false;
        if (selectedOptionName.equalsIgnoreCase("Checked checkbox"))
            isSelected = checkedCheckBox.isSelected();
        else if (selectedOptionName.equalsIgnoreCase("Default checkbox")) {
            if (!unCheckedCheckBox.isSelected())
                isSelected = true;
        }
            else if (selectedOptionName.equalsIgnoreCase("Checked radio"))
                isSelected = checkedRadioButton.isSelected();
            else if (selectedOptionName.equalsIgnoreCase("Default radio")) {
            if (!unCheckedRadioButton.isSelected())
                isSelected = true;
        }

        return isSelected;
    }

    public boolean isHeightChangeable(String fieldName) {
        boolean isHeightChangeable = false;
        if (fieldName.equalsIgnoreCase("Textarea")) {
            isHeightChangeable = textarea.getDomAttribute("style").contains("height");
        }
        return isHeightChangeable;
    }

    public boolean click(String elementName) {
        boolean elementClicked = false;
        if (elementName.contains("Submit")) {
            submit.click();
            elementClicked = true;
        } else if (elementName.contains("Return to index")) {
            returnToIndex.click();
            elementClicked = true;
        }

        return elementClicked;

    }

    public boolean validateURL(String url) {
        boolean isPageCorrect = false;
        if (driver.getCurrentUrl().contains(url))
            isPageCorrect = true;
        return isPageCorrect;
    }

    public boolean validateTitle(String title) {
        boolean isTitleCorrect = false;
        if (driver.getTitle().equalsIgnoreCase(title))
            isTitleCorrect = true;
        return isTitleCorrect;
    }

    public boolean linkCount(int linkCount) {
        boolean count = false;
        if (allLinks.size() == linkCount)
            count = true;
        return count;
    }

    public boolean linkValidation() {
        boolean allLiksClicable = false;
        for (int i = 0; i < allLinks.size(); i++) {
            if (allLinks.get(i).getText().contains("index.html"))
                continue;
            else if (allLinks.get(i).getText().contains("pageWithOnLoad.html")) {
                allLinks.get(i).click();
                driver.switchTo().alert().accept();
                driver.navigate().back();
            } else {
                allLinks.get(i).click();
                driver.navigate().back();
            }
        }
        allLiksClicable = true;
        return allLiksClicable;
    }

    public boolean enterValue(String value, String fieldName) {
        if (fieldName.contains(constant.textInput))
            textInput.sendKeys(value);
        else if (fieldName.contains(constant.password))
            password.sendKeys(value);
        else if (fieldName.contains(constant.textArea))
            textarea.sendKeys(value);
        return true;
    }

    public boolean selectValueFromDropDown(String value, String dropDownName) {
        boolean valueSelected = false;
        Select s;
        if (dropDownName.contains(constant.drapDownSelect)) {
            s = new Select(dropdownSelect);
            s.selectByVisibleText(value);
            valueSelected = true;
        } else if (dropDownName.contains(constant.dropDownDataList)) {
            dropdownDatalist.sendKeys(value);
            valueSelected = true;
        }
        return valueSelected;
    }

    public boolean uploadSampleFile() {
        String fileSeperator = System.getProperty("file.separator");
        File file = new File("." + fileSeperator + "Sample.xlsx");
        fileInput.sendKeys(file.getAbsolutePath());

        return true;
    }

    public boolean dateSelection(int daysAhead) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();
        String todate = dateFormat.format(date);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, +daysAhead);
        Date todate1 = cal.getTime();
        String fromdate = dateFormat.format(todate1);
        datePicker.sendKeys(fromdate.split("-")[1] + "/" + fromdate.split("-")[2] + "/" + fromdate.split("-")[0]);

        return true;
    }
}
