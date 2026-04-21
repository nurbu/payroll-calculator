package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class EmployeeDirectory {
    // Reads employees.csv and prints their information
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the employee file to process: ");
        String employeeFilePath = scanner.nextLine();
        System.out.print("\nEnter the name of the payroll file to create: ");
        String payrollFilePath = scanner.nextLine();
        try {
            FileReader fileReader = new FileReader(employeeFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(payrollFilePath));
            // Goes line by line of the csv file
            while ((line = bufferedReader.readLine()) != null) {
                // Takes the line and splits it and then places the info into an array.
                String[] employeeData = line.split("\\|");
                int id = Integer.parseInt(employeeData[0]);
                String name = employeeData[1];
                double hoursWorked = Double.parseDouble(employeeData[2]);
                double payRate = Double.parseDouble(employeeData[3]);
                Employee employee = new Employee(id, name, hoursWorked, payRate);

                
                // System.out.printf("Id: " + employee.getEmployeeId() + "\nName: " + employee.getName() + "\nGross Pay: " + employee.getGrossPay() + "\n");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
