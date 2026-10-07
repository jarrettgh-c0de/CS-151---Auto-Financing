/*
 * Name: Jarrett Howard
 * Course: CS 151
 * Assignment: Assignment #2 - Auto Financing
 * Date: September 2, 2026
 * Description:
 * This program asks the user for information about a car and its loan.
 * It calculates the monthly loan payment, yearly fuel cost, annual
 * vehicle expenses, total annual cost, and total monthly cost.
 */

import java.util.Scanner;

public class Assignment2 {

    public static void main(String[] args) {

        // Create a Scanner object for keyboard input
        Scanner input = new Scanner(System.in);

        // Constants for fixed vehicle expenses
        final double COST_PER_GALLON = 2.75;
        final double OIL_CHANGE_COST = 50.00;
        final int OIL_CHANGES_PER_YEAR = 4;
        final double BASIC_UPKEEP_PER_YEAR = 400.00;
        final double ANNUAL_PARKING_PASS = 306.00;

        // Variables for user input
        String carBrand;
        String carName;
        int carYear;
        double carCost;
        double downPayment;
        double yearlyInterestRate;
        int loanTermMonths;
        double carMPG;
        double yearlyMileage;

        // Variables for calculated values
        double principal;
        double monthlyInterestRate;
        double monthlyLoanPayment;
        double yearlyFuelCost;
        double annualOilChangeCost;
        double totalAnnualCost;
        double totalMonthlyCost;

        // Prompt for and read the car brand
        System.out.print("Enter the car brand (HONDA, FORD, CHEVY, ETC): ");
        carBrand = input.nextLine();

        // Prompt for and read the car name
        System.out.print("Enter the car name (FOCUS, CAMRY, CAMARO, ETC): ");
        carName = input.nextLine();

        // Prompt for and read the car year
        System.out.print("Enter the car year: ");
        carYear = input.nextInt();

        // Prompt for and read the car cost
        System.out.print("Enter the car cost (USD): ");
        carCost = input.nextDouble();

        // Prompt for and read the down payment
        System.out.print("Enter the down payment (USD): ");
        downPayment = input.nextDouble();

        // Prompt for and read the yearly interest rate
        System.out.print("Enter the yearly interest rate (%): ");
        yearlyInterestRate = input.nextDouble();

        // Prompt for and read the loan term
        System.out.print("Enter the term of the loan in months (36, 48, etc): ");
        loanTermMonths = input.nextInt();

        // Prompt for and read the car MPG
        System.out.print("Enter the car MPG: ");
        carMPG = input.nextDouble();

        // Prompt for and read the yearly mileage
        System.out.print("Enter the mileage used per year: ");
        yearlyMileage = input.nextDouble();

        // Calculate the principal amount being financed
        principal = carCost - downPayment;

        // Convert the yearly interest rate to a monthly decimal rate
        monthlyInterestRate = (yearlyInterestRate / 100.0) / 12.0;

        // Calculate the monthly loan payment
        monthlyLoanPayment =
                principal
                * (monthlyInterestRate
                * Math.pow(1 + monthlyInterestRate, loanTermMonths))
                / (Math.pow(1 + monthlyInterestRate, loanTermMonths) - 1);

        // Calculate the yearly fuel cost
        yearlyFuelCost =
                (yearlyMileage / carMPG) * COST_PER_GALLON;

        // Calculate the annual oil change cost
        annualOilChangeCost =
                OIL_CHANGE_COST * OIL_CHANGES_PER_YEAR;

        // Calculate the total annual cost
        totalAnnualCost =
                yearlyFuelCost
                + ANNUAL_PARKING_PASS
                + annualOilChangeCost
                + BASIC_UPKEEP_PER_YEAR
                + (monthlyLoanPayment * 12);

        // Calculate the total monthly cost
        totalMonthlyCost = totalAnnualCost / 12;

        // Display monthly interest rate
        System.out.println();
        System.out.println("r=" + monthlyInterestRate);
        System.out.println();

        // Display cost analysis
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        System.out.println();
        System.out.println("Cost Analysis");
        System.out.println();

        System.out.println(
                "Car Name: " + carYear + " " + carBrand + " " + carName);
        System.out.println();

        System.out.printf("Principle: $%.2f%n%n", principal);

        System.out.printf(
                "Interest Rate: %.2f %%%n%n",
                yearlyInterestRate);

        System.out.printf(
                "Loan Term: %d%n%n",
                loanTermMonths);

        System.out.printf(
                "Monthly Loan Payment: $%.2f%n%n",
                monthlyLoanPayment);

        System.out.printf(
                "Yearly Fuel Cost: $%.2f%n%n",
                yearlyFuelCost);

        System.out.printf(
                "Annual Maintenance Cost: $%.2f%n%n",
                BASIC_UPKEEP_PER_YEAR);

        System.out.printf(
                "Annual Oil Change Cost: $%.2f%n%n",
                annualOilChangeCost);

        System.out.printf(
                "Annual Parking Pass: $%.2f%n%n",
                ANNUAL_PARKING_PASS);

        System.out.printf(
                "Total Annual Cost: $%.2f%n%n",
                totalAnnualCost);

        System.out.printf(
                "Total Monthly Cost: $%.2f%n",
                totalMonthlyCost);

        // Close the Scanner
        input.close();
    }
}