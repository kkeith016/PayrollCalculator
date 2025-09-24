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

    }
}
