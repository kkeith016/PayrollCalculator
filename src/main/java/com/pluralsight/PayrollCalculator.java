package com.pluralsight;

import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Employee Name
        System.out.println("Enter your Name");
        String name = scan.nextLine();

        //Hours Worked
        System.out.println("Enter your Hours");
        int hoursWorked = scan.nextInt();

        //Payrate

        System.out.println("Enter your Hourly Rate");
        double hourlyRate = scan.nextDouble();

        double grossPay =  hoursWorked * hourlyRate;

        if (hoursWorked > 40) {
            double regularPay = 40 * hourlyRate;
            double overtimePay = (hoursWorked - 40) * hourlyRate * 1.5;
            grossPay = regularPay + overtimePay;
        } else {
            grossPay = hoursWorked * hourlyRate;
        }
        //Print Results
        System.out.println("\n--- Payroll Summary ---");
        System.out.println("Employee Name: " + name);
        System.out.printf("Gross Pay: $%.2f%n", grossPay);

    }
}
