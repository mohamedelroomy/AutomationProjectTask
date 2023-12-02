package com.orangehrm.api;

import com.orangehrm.data.Constant;
import com.orangehrm.models.Employee;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PersonalDetailsApi {

    public Response editPersonalDetails(Employee emp, int employeeNumber,String cookie){
//        Employee employeeTwo = new Employee(firstName,middleName,lastName,employeeId,otherId,drivingLicenseNo,drivingLicenseExpiredDate,gender,"Single",birthday,55,"01452144");
        return  given()
                .baseUri(Constant.ApiUrl)
                .contentType(ContentType.JSON)
                .header("Cookie","orangehrm="+cookie)
                .body(emp)
                .when()
                .put(Constant.employeeEndPoint+"/"+employeeNumber+Constant.personalDetailsEndPoint)
                .then()
                .log().all()
                .extract().response();
    }

}
