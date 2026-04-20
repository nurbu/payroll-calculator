package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class EmployeeDirectory {
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] employeeData = line.split("\\|");
                int id = Integer.parseInt(employeeData[0]);
                String name = employeeData[1];
                double hoursWorked = Double.parseDouble(employeeData[2]);
                double payRate = Double.parseDouble(employeeData[3]);
                Employee employee = new Employee(id, name, hoursWorked, payRate);

                System.out.printf("Id: " + employee.getEmployeeId() + "\nName: " + employee.getName() + "\nGross Pay: " + employee.getGrossPay() + "\n");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
