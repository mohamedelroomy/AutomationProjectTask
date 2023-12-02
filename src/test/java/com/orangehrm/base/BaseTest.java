package com.orangehrm.base;

import com.orangehrm.data.Constant;
import com.orangehrm.factory.DriverFactory;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BaseTest {

    protected WebDriver driver;


    @BeforeClass
    public void setup(){
        driver = new DriverFactory().initializeDriver();
        driver.get(Constant.BaseURL);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @AfterMethod
    public void takeScreenShot(ITestResult result){
        String testCaseName = result.getMethod().getMethodName();
        File destFile = new File("target", File.separator+"screenshots"+File.separator+testCaseName+".png");
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,destFile);
            InputStream inputStream = new FileInputStream(destFile);
            Allure.addAttachment("screenshot",inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String getCookie(){

        return driver.manage().getCookieNamed("orangehrm").getValue();
    }
}
