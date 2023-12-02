package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class EmployeeListPage extends BasePage {
    public EmployeeListPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")
    WebElement employeeNameTXTField;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input")
    WebElement employeeIdTXTField;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")
    WebElement searchBtn;

    @FindBy (xpath = "(//button[@class='oxd-icon-button'])[2]")
    List<WebElement> ListOfEditBtn;

    @FindBy (className = "oxd-table-card")
    List<WebElement> listOfEmployees;


    public void searchForEmployeeById(String id){
        insertIntoElement(employeeIdTXTField, id);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(searchBtn));
        click(searchBtn);
    }

    public void searchForEmployeeByName(String name){
        insertIntoElement(employeeNameTXTField, name);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(searchBtn));
        click(searchBtn);
    }

    public void editFirstEmployee() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        try {
            new WebDriverWait(driver, Duration.ofSeconds(6)).until(ExpectedConditions.visibilityOf(listOfEmployees.get(0)));
            new WebDriverWait(driver, Duration.ofSeconds(6)).until(ExpectedConditions.stalenessOf(listOfEmployees.get(0)));
            scrollDownUntilElementVisible(listOfEmployees.get(0));
            click(listOfEmployees.get(0));
        }
        catch (Exception ex){
            click(searchBtn);
            List<WebElement> listOfEmployees = driver.findElements(By.className("oxd-table-card"));
            new WebDriverWait(driver, Duration.ofSeconds(6)).until(ExpectedConditions.visibilityOf(listOfEmployees.get(0)));
//            new WebDriverWait(driver, Duration.ofSeconds(6)).until(ExpectedConditions.stalenessOf(listOfEmployees.get(0)));
            scrollDownUntilElementVisible(listOfEmployees.get(0));
            click(listOfEmployees.get(0));
        }
    }



}
