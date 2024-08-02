package com.mca.recyclertwo;

public class EmployeeInfo {
    private String employeeName;
    private String employeeContactNumber;
    private String employeeAddress;
    public EmployeeInfo() {

    }

    public EmployeeInfo(String name, String phone, String address) {
        employeeName=name;
        employeeContactNumber=phone;
        employeeAddress=address;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeContactNumber() {
        return employeeContactNumber;
    }

    public void setEmployeeContactNumber(String employeeContactNumber) {
        this.employeeContactNumber = employeeContactNumber;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }
}

