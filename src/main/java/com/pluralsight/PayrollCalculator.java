package com.pluralsight;


import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import static java.lang.Integer.parseInt;

public class PayrollCalculator {
    public static void main(String[] args) {

        try {

            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine(); //eats the first line of the CSV.

            String input;
            while ((input = bufferedReader.readLine()) != null) {
                String[] parts = input.split("\\|"); //Splits at the |

                int id = Integer.parseInt(parts[0]);
                String fullName = parts[1];
                double hours = Double.parseDouble(parts[2]);
                double payRate = Double.parseDouble(parts[3]);

                Employees employee = new Employees(id, fullName, hours, payRate);

                //Print out everything
                System.out.println("------------Payroll Calculator--------------");
                System.out.println("Employee ID: " + employee.getId());
                System.out.println("Employee Full Name: " + employee.getFullName());
                System.out.println("Employee Hours: " + employee.getHours());
                System.out.println("Employee Pay Rate: " + employee.getPayRate());
                System.out.printf("Gross Pay: $%.2f%n", employee.getGrossPay());
                System.out.println("-----------------------------------------------");
            }
            bufferedReader.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
        }
    }
