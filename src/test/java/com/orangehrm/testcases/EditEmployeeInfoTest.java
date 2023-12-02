package com.orangehrm.testcases;

import com.orangehrm.api.AddEmployeeApi;
import com.orangehrm.api.PersonalDetailsApi;
import com.orangehrm.base.BaseTest;
import com.orangehrm.data.Constant;
import com.orangehrm.data.JsonReader;
import com.orangehrm.pages.*;
import com.orangehrm.utils.FakeData;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditEmployeeInfoTest extends BaseTest {
    LoginPage loginPage;
    EmployeeListPage employeeListPage;
    PersonalDetailsPage personalDetailsPage;
    ContactDetailPage contactDetailPage;
    JobDetailPage jobDetailPage;
    FakeData fakeData;
    String employeeId;
    int employeeNumber;
    String loginCookie;


    @Test(priority = 2,description = "adding new employee using api",dependsOnMethods = "loginWithAdmin")
    public void addNewEmployee(){
        fakeData = new FakeData();
        Response response = new AddEmployeeApi().addEmployee(fakeData.getEmployee(),loginCookie);
        Assert.assertEquals(response.statusCode(),200);
        employeeId = response.path("data.employeeId");
        employeeNumber = response.path("data.empNumber");
    }

    @Test(priority = 3,description = "Edit Employee personal details using Api",dependsOnMethods = "addNewEmployee")
    public void editEmployeePersonalDetails(){
        Response response= new PersonalDetailsApi().editPersonalDetails(fakeData.getPersonalDetailEmployee(),employeeNumber,loginCookie);
        Assert.assertEquals(response.statusCode(),200);
        employeeId = response.path("data.employeeId");
        employeeNumber = response.path("data.empNumber");
    }

    @Test(priority = 1,description = "login as admin with valid username and password",groups = {"web automation"})
    public void loginWithAdmin(){
        loginPage = new LoginPage(driver);
        loginPage
                .login(Constant.loginUsername, Constant.loginPassword)
                .navigateToPIM();
        loginCookie= getCookie();
    }

    @Test(priority = 4 ,description = "user can search with the add employee by employee Id", groups = {"web automation"})
    public void canSearchAndEditTheAddedEmployee(){
        employeeListPage = new EmployeeListPage(driver);
        employeeListPage.searchForEmployeeById(employeeId);
        employeeListPage.editFirstEmployee();
    }

    @Test(priority = 5 ,description = "user filling contact details", groups = {"web automation"})
    public void userCanAddContactDetails() {
        personalDetailsPage = new PersonalDetailsPage(driver);
        personalDetailsPage.openContactDetails();
        contactDetailPage = new ContactDetailPage(driver);
        contactDetailPage.insertAddress(fakeData.generateRandomStreet()
                ,fakeData.generateRandomStreet()
                ,JsonReader.getValueOfKey("city")
                ,JsonReader.getValueOfKey("state")
                ,JsonReader.getValueOfKey("zip"));
        contactDetailPage.selectCountry(JsonReader.getValueOfKey("country"));
        contactDetailPage.insertTelephone(JsonReader.getValueOfKey("homeNumber")
                ,JsonReader.getValueOfKey("mobileNumber")
                ,JsonReader.getValueOfKey("workNumber"));
        contactDetailPage.insertEmails(JsonReader.getValueOfKey("workEmail"),JsonReader.getValueOfKey("otherEmail"));
        contactDetailPage.uploadAttachment();
        Assert.assertTrue(contactDetailPage.getSuccessToasterMessage().contains("Successfully Saved"));
        Assert.assertTrue(contactDetailPage.newRecordIsAdded());
        contactDetailPage.openJobDetails();
    }

    @Test(priority = 6 ,description = "user filling job details", groups = {"web automation"})
    public void userCanAddJobDetails(){
        jobDetailPage = new JobDetailPage(driver);
        jobDetailPage.fillJobDetails("15-06-2015"
                , "Software Engineer"
                , "Quality Assurance"
                ,"Texas R&D"
                , "Part-Time Internship");
        jobDetailPage.addContractDetails();
        Assert.assertTrue(jobDetailPage.getSuccessToasterMessage().contains("Successfully Updated"));
    }

}
