package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for file names
        System.out.print("Enter the name of the employee file to process: ");
        String employeeFile = scanner.nextLine();

        System.out.print("Enter the name of the payroll file to create: ");
        String payrollFile = scanner.nextLine();

        try {
            FileReader fileReader = new FileReader("src/main/resources/" + employeeFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine(); // skip header

            FileWriter fileWriter = new FileWriter("src/main/resources/" + payrollFile, true);
            fileWriter.write("id|name|gross pay\n"); // write header

            String input;
            while ((input = bufferedReader.readLine()) != null) {
                String[] parts = input.split("\\|");

                int id = Integer.parseInt(parts[0]);
                String fullName = parts[1];
                double hours = Double.parseDouble(parts[2]);
                double payRate = Double.parseDouble(parts[3]);

                Employees employee = new Employees(id, fullName, hours, payRate);

                // Write to payroll file
                String line = employee.getId() + "|" + employee.getFullName() + "|" + String.format("%.2f", employee.getGrossPay()) + "\n";
                fileWriter.write(line);

                // Optional: print to console
                System.out.println("------------Payroll Calculator--------------");
                System.out.println("Employee ID: " + employee.getId());
                System.out.println("Employee Full Name: " + employee.getFullName());
                System.out.println("Employee Hours: " + employee.getHours());
                System.out.println("Employee Pay Rate: " + employee.getPayRate());
                System.out.printf("Gross Pay: $%.2f%n", employee.getGrossPay());
                System.out.println("-----------------------------------------------");
            }

            bufferedReader.close();
            fileWriter.close();
            System.out.println("\nPayroll file created successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}