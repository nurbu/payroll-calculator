package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class EmployeeDirectory {
    // Reads employees.csv and prints their information
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            // Goes line by line of the csv file
            while ((line = bufferedReader.readLine()) != null) {
                // Takes the line and splits it and then places the info into an array.
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
