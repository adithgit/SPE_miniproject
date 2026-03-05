package org.example;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   Welcome to Interactive Calculator   ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        boolean running = true;
        while (running) {
            displayMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    handleSquareRoot();
                    break;
                case "2":
                    handleFactorial();
                    break;
                case "3":
                    handleNaturalLog();
                    break;
                case "4":
                    handlePower();
                    break;
                case "5":
                    running = exitApplication();
                    break;
                default:
                    System.out.println("❌ Invalid choice. Please select 1-5.\n");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Select an operation:");
        System.out.println("1. Square Root");
        System.out.println("2. Factorial");
        System.out.println("3. Natural Logarithm (ln)");
        System.out.println("4. Power (base^exponent)");
        System.out.println("5. Exit");
        System.out.print("Enter your choice (1-5): ");
    }

    private static void handleSquareRoot() {
        try {
            System.out.print("Enter a number: ");
            double num = parseDouble(scanner.nextLine());
            double result = Calculator.squareRoot(num);
            System.out.println("✓ √" + num + " = " + result + "\n");
        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Invalid input. Please enter a valid number.\n");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage() + "\n");
        }
    }

    private static void handleFactorial() {
        try {
            System.out.print("Enter a non-negative integer: ");
            int num = parseInt(scanner.nextLine());
            long result = Calculator.factorial(num);
            System.out.println("✓ " + num + "! = " + result + "\n");
        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Invalid input. Please enter a valid integer.\n");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage() + "\n");
        }
    }

    private static void handleNaturalLog() {
        try {
            System.out.print("Enter a positive number: ");
            double num = parseDouble(scanner.nextLine());
            double result = Calculator.naturalLog(num);
            System.out.println("✓ ln(" + num + ") = " + result + "\n");
        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Invalid input. Please enter a valid number.\n");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage() + "\n");
        }
    }

    private static void handlePower() {
        try {
            System.out.print("Enter the base: ");
            double base = parseDouble(scanner.nextLine());
            System.out.print("Enter the exponent: ");
            double exponent = parseDouble(scanner.nextLine());
            double result = Calculator.power(base, exponent);
            System.out.println("✓ " + base + "^" + exponent + " = " + result + "\n");
        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Invalid input. Please enter valid numbers.\n");
        }
    }

    private static boolean exitApplication() {
        System.out.println("\nThank you for using the Calculator!");
        System.out.println("═════════════════════════════════════════");
        return false;
    }

    private static double parseDouble(String input) {
        return Double.parseDouble(input.trim());
    }

    private static int parseInt(String input) {
        return Integer.parseInt(input.trim());
    }
}