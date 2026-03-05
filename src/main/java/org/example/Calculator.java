package org.example;

public class Calculator {

    public static double squareRoot(double num) {
        if (num < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of negative number");
        }
        return Math.sqrt(num);
    }

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n > 20) {
            throw new IllegalArgumentException("Factorial too large (max supported: 20)");
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static double naturalLog(double num) {
        if (num <= 0) {
            throw new IllegalArgumentException("Cannot calculate natural log of non-positive number");
        }
        return Math.log(num);
    }

    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}

