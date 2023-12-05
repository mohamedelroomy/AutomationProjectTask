package com.orangehrm.models;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {


        private String firstName;
        private String middleName;
        private String lastName;
        private Object empPicture;
        private String employeeId;
        private String otherId;
        private String drivingLicenseNo;
        private String drivingLicenseExpiredDate;
        private String gender;
        private String maritalStatus;
        private String birthday;
        private Integer nationalityId;
        private String sinNumber;

    public Employee(String firstName, String middleName, String lastName, Object empPicture, String employeeId) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.empPicture = empPicture;
        this.employeeId = employeeId;
    }



    public String getOtherId() {
        return otherId;
    }
    public void setOtherId(String otherId) {
        this.otherId = otherId;
    }
    public String getDrivingLicenseNo() {
        return drivingLicenseNo;
    }
    public void setDrivingLicenseNo(String drivingLicenseNo) {
        this.drivingLicenseNo = drivingLicenseNo;
    }
    public String getDrivingLicenseExpiredDate() {
        return drivingLicenseExpiredDate;
    }
    public void setDrivingLicenseExpiredDate(String drivingLicenseExpiredDate) {
        this.drivingLicenseExpiredDate = drivingLicenseExpiredDate;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getMaritalStatus() {
        return maritalStatus;
    }
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public Integer getNationalityId() {
        return nationalityId;
    }
    public void setNationalityId(Integer nationalityId) {
        this.nationalityId = nationalityId;
    }
    public String getSinNumber() {
        return sinNumber;
    }
    public void setSinNumber(String sinNumber) {
        this.sinNumber = sinNumber;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
    public String getMiddleName() {
            return middleName;
        }
    public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }
    public String getLastName() {
            return lastName;
        }
    public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    public Object getEmpPicture() {
            return empPicture;
        }
    public void setEmpPicture(Object empPicture) {
            this.empPicture = empPicture;
        }
    public String getEmployeeId() {
            return employeeId;
        }
    public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }
    }



