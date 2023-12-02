package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class ContactDetailPage extends BasePage {

    public ContactDetailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[1]/div/div[2]/input")
    WebElement street1TxtField;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[2]/div/div[2]/input")
    WebElement street2TxtField;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[3]/div/div[2]/input")
    WebElement cityTxtField;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[4]/div/div[2]/input")
    WebElement stateTxtField;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[5]/div/div[2]/input")
    WebElement zipTxtField;

    @FindBy (css = "div.oxd-select-wrapper")
    WebElement countryDDL;

    @FindBy (css = "div[role='listbox']")
    WebElement listBox;

    @FindBy (css = "div[role='option']")
    List<WebElement> listOptions;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[1]/div/div[2]/input")
    WebElement homeNumberTxtField;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[2]/div/div[2]/input")
    WebElement mobileNumberTxtField;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[3]/div/div[2]/input")
    WebElement workNumberTxtField;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div/div[1]/div/div[2]/input")
    WebElement workEmailTxtField;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div/div[2]/div/div[2]/input")
    WebElement otherEmailTxtField;

    @FindBy (css = "button[type='submit']")
    WebElement saveBtn;

    @FindBy (xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/button")
    WebElement addBtn;

    @FindBy (css = "input[type='file']")
    WebElement uploadFileElement;

    @FindBy (xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/form/div[3]/button[2]")
    WebElement saveAttachmentBtn;

    @FindBy (css = "div[role='row']")
    WebElement uploadedRows;

    @FindBy(id = "oxd-toaster_1")
    WebElement successToaster;

    @FindBy(xpath = "//*[@id=\"oxd-toaster_1\"]/div/div[1]/div[2]/p[1]")
    WebElement successParagraph;

    @FindBy (linkText = "Job")
    WebElement jobDetailsBtn;

    public void insertAddress(String street1, String street2, String city, String state, String zip){
        insertIntoElement(street1TxtField,street1);
        insertIntoElement(street2TxtField,street2);
        insertIntoElement(cityTxtField,city);
        insertIntoElement(stateTxtField,state);
        insertIntoElement(zipTxtField,zip);
    }

    public void selectCountry(String country) {
//        click(countryDDL);
//        Thread.sleep(2000);
//        click(listOptions.get(3));
        selectFromDropDownWithValue(countryDDL,listBox,country);
        }
    public void insertTelephone(String homeNumber, String mobileNumber, String workNumber){
        insertIntoElement(homeNumberTxtField,homeNumber);
        insertIntoElement(mobileNumberTxtField,mobileNumber);
        insertIntoElement(workNumberTxtField,workNumber);
    }

    public void insertEmails(String workEmail, String otherEmail){
        insertIntoElement(workEmailTxtField,workEmail);
        insertIntoElement(otherEmailTxtField,otherEmail);
    }

    public void uploadAttachment() {
        scrollDownUntilElementVisible(addBtn);
        click(addBtn);
        File uploadFile = new File("src/test/resources/photo.jpg");
        insertIntoElement(uploadFileElement,uploadFile.getAbsolutePath());
        click(saveAttachmentBtn);
    }
    public boolean newRecordIsAdded() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return uploadedRows.isDisplayed();
    }

    public String getSuccessToasterMessage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(successParagraph));
        return successToaster.getText();
    }

    public void openJobDetails(){
        scrollToTheTopOfPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        click(jobDetailsBtn);
    }

}



