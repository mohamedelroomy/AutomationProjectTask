package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalDetailsPage extends BasePage {
    public PersonalDetailsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Contact Details")
    WebElement contactDetailsBtn;

    public void openContactDetails(){
        click(contactDetailsBtn);
    }
}
