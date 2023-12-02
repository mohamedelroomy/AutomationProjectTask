package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JobDetailPage extends BasePage {
    public JobDetailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "(//input[@placeholder='yyyy-mm-dd'])[1]")
    WebElement joinedDatePicker;

    @FindBy (xpath = "(//div[@class='oxd-select-wrapper'])[1]")
    WebElement jobTitleDDL;

    @FindBy (xpath = "(//div[@class='oxd-select-wrapper'])[3]")
    WebElement subUnitDDL;

    @FindBy (xpath = "(//div[@class='oxd-select-wrapper'])[4]")
    WebElement locationDDL;

    @FindBy (xpath = "(//div[@class='oxd-select-wrapper'])[5]")
    WebElement employmentStatusDDL;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/label/span")
    WebElement includeEmploymentToggle;

    @FindBy (xpath = "(//input[@placeholder='yyyy-mm-dd'])[2]")
    WebElement contractStartDatePicker;

    @FindBy (xpath = "(//input[@placeholder='yyyy-mm-dd'])[3]")
    WebElement contractEndDatePicker;

    @FindBy (css = "div[role='listbox']")
    WebElement listBox;

    @FindBy(id = "oxd-toaster_1")
    WebElement successToaster;

    @FindBy (xpath = "//*[@id=\"oxd-toaster_1\"]/div/div[1]/div[2]/p[1]")
    WebElement successParagraph;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[5]/button")
    WebElement saveAttachmentBtn;

    public void fillJobDetails (String joinedDate, String JobTitle, String subUnit, String location, String empStatus){
        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(jobTitleDDL));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        insertIntoElement(joinedDatePicker,convertDateToYearFirst(joinedDate));
        selectFromDropDownWithValue(jobTitleDDL,listBox,JobTitle);
        selectFromDropDownWithValue(subUnitDDL,listBox,subUnit);
        selectFromDropDownWithValue(locationDDL,listBox,location);
        selectFromDropDownWithValue(employmentStatusDDL,listBox,empStatus);
    }
    private String convertDateToYearFirst(String insertedDate){
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fixedDate = LocalDate.parse(insertedDate, inputFormatter);
        // Convert the LocalDate object back to a string with yyyy-MM-dd format
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return fixedDate.format(outputFormatter);
    }

    public void addContractDetails(){
        click(includeEmploymentToggle);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        insertIntoElement(contractStartDatePicker,getTodayDate());
        insertIntoElement(contractEndDatePicker,getOneYearFromNow());
        scrollDownUntilElementVisible(saveAttachmentBtn);
        click(saveAttachmentBtn);
    }

    private String getTodayDate(){
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return today.format(formatter);
    }

    private String getOneYearFromNow(){
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate oneYearFromNow = today.plusYears(1);
        return oneYearFromNow.format(formatter);
    }

    public String getSuccessToasterMessage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(successParagraph));
        return successToaster.getText();
    }

}
