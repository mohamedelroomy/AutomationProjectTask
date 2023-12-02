package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = "input[name='username']")
    WebElement userNameInput;

    @FindBy (css = "input[name='password']")
    WebElement passwordInput;

    @FindBy (css = "button.oxd-button")
    WebElement loginBtn;


    public DashboardPage login(String username, String password){
        insertIntoElement(userNameInput,username);
        insertIntoElement(passwordInput,password);
        click(loginBtn);
        return new DashboardPage(driver);
    }

}
