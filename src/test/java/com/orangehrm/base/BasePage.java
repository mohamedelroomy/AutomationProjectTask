package com.orangehrm.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    JavascriptExecutor js;

    public BasePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void insertIntoElement (WebElement element, String txt){
        element.sendKeys(txt);
    }

    public void click (WebElement element){
        element.click();
    }

    public void scrollDownUntilElementVisible(WebElement element){
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollToTheTopOfPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
    }

    public void scrollUpUntilElementVisible(WebElement element){
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);" + "window.scrollBy(0,-100);", element);
    }

    public void selectFromDropDownWithValue(WebElement dropDown, WebElement listBox ,String value) {
        click(dropDown);
        String spanPath = "//div[@role='option']//span[contains(text(), '"+value+"')]";
        try {
            WebElement  Span = listBox.findElement(By.xpath(spanPath));
            click(Span);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            e.getMessage();

        }
    }

}
