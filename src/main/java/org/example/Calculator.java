package org.example;

/**
 * Calculator class providing mathematical functions
 */
public class Calculator {

    /**
     * Calculates the square root of a number
     * @param num the number to get the square root of
     * @return the square root of num
     * @throws IllegalArgumentException if num is negative
     */
    public static double squareRoot(double num) {
        if (num < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of negative number");
        }
        return Math.sqrt(num);
    }

    /**
     * Calculates the factorial of a number
     * @param n the number to calculate factorial of
     * @return the factorial of n
     * @throws IllegalArgumentException if n is negative or greater than 20 (to prevent overflow)
     */
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

    /**
     * Calculates the natural logarithm (base e) of a number
     * @param num the number to get the natural logarithm of
     * @return the natural logarithm of num
     * @throws IllegalArgumentException if num is <= 0
     */
    public static double naturalLog(double num) {
        if (num <= 0) {
            throw new IllegalArgumentException("Cannot calculate natural log of non-positive number");
        }
        return Math.log(num);
    }

    /**
     * Calculates a number raised to a power
     * @param base the base number
     * @param exponent the power to raise base to
     * @return base raised to the power of exponent
     */
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}

