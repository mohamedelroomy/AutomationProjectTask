package com.orangehrm.utils;

import com.github.javafaker.Faker;
import com.orangehrm.models.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FakeData {
    private final String firstName = new Faker().name().firstName();
    private final String middleName = new Faker().name().name();
    private final String lastName = new Faker().name().lastName();;
    private final String employeeId = new Faker().number().digits(4);;
    private Employee employee;
    //private Employee personalDetailEmployee;
    private String otherId;
    private String drivingLicenseNo;
    private String drivingLicenseExpiryDate;
    private String gender;
    private String birthday;

    public Employee getEmployee(){
        this.employee =new Employee(firstName,middleName,lastName,null,employeeId);
        return employee;
    }

    public Employee getPersonalDetailEmployee(){
        this.employee = getEmployee();
        this.otherId= getOtherId();
        this.drivingLicenseNo= getDrivingLicenseNo();
        this.drivingLicenseExpiryDate = getDrivingLicenseExpiryDate();
        this.gender=getGender();
        this.birthday = getBirthday();
        this.employee.setOtherId(this.otherId);
        this.employee.setDrivingLicenseNo(this.drivingLicenseNo);
        this.employee.setDrivingLicenseExpiredDate(this.drivingLicenseExpiryDate);
        this.employee.setGender(this.gender);
        this.employee.setBirthday(this.birthday);
        this.employee.setMaritalStatus("Single");
        this.employee.setNationalityId(55);
        this.employee.setSinNumber("01452144");
        return employee;
    }

    public String getOtherId(){
        return this.otherId = new Faker().number().digits(4);
    }
    public String getDrivingLicenseNo() {
        return this.drivingLicenseNo = new Faker().number().digits(4);
    }

    public String getDrivingLicenseExpiryDate() {

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate oneYearFromNow = today.plusYears(3);
        return this.drivingLicenseExpiryDate = oneYearFromNow.format(formatter);
    }

    public String getGender() {
        return this.gender = String.valueOf(new Faker().number().numberBetween(1,2));
    }

    public String getBirthday() {
        return this.birthday = "1999-11-30";
    }

    public String generateRandomStreet(){
        return new Faker().address().streetAddress();
    }

}
