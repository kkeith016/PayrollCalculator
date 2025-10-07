package com.pluralsight;

public class Employees {

    private int id;
    private String fullName;
    private double hours;
    private double payRate;

    public Employees(int id, String fullName, double hours, double payRate) {
        this.id = id;
        this.fullName = fullName;
        this.hours = hours;
        this.payRate = payRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }
    public double getGrossPay() {
        // Basic calculation: if hours > 40, overtime is 1.5x pay rate
        if (hours > 40) {
            double overtimeHours = hours - 40;
            return (40 * payRate) + (overtimeHours * payRate * 1.5);
        } else {
            return hours * payRate;
        }
    }
}