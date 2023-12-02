package com.orangehrm.data;

public class Constant {
    public static final String BaseURL = PropertyReader.getProperty("Url","GuiConfig.properties");
    public static final String loginUsername = PropertyReader.getProperty("username","GuiConfig.properties");
    public static final String loginPassword = PropertyReader.getProperty("password","GuiConfig.properties");

    public static final String ApiUrl = PropertyReader.getProperty("ApiUrl", "ApiConfig.properties");
    public static final String employeeEndPoint = PropertyReader.getProperty("employeeEndPoint", "ApiConfig.properties");
    public static final String personalDetailsEndPoint = PropertyReader.getProperty("personalDetailsEndPoint", "ApiConfig.properties");


}
