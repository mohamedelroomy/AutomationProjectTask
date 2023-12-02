package com.orangehrm.api;

import com.orangehrm.data.Constant;
import com.orangehrm.models.Employee;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AddEmployeeApi {

    private String employeeId;
    private int empNumber;

    public String getEmployeeId() {
        return employeeId;
    }

    public int getEmpNumber() {
        return empNumber;
    }


    public Response addEmployee(Employee emp,String cookie){
        Response response=  given()
                .baseUri(Constant.ApiUrl)
                .contentType(ContentType.JSON)
                .header("Cookie","orangehrm="+cookie)
                .body(emp)
        .when()
                .post(Constant.employeeEndPoint)
        .then()
                .log().all()
                .extract().response();
        this.employeeId = response.path("data.employeeId");
        this.empNumber = response.path("data.empNumber");
        return response;
    }
}
