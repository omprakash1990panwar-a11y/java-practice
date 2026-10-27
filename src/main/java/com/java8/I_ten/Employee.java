package com.java8.I_ten;

public class Employee {
    int empId;
    String empName;
    double dailyWages;
    double salary;

    public Employee(int empId, String empName, double dailyWages, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.dailyWages = dailyWages;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", dailyWages=" + dailyWages +
                ", salary=" + salary +
                '}';
    }
}
