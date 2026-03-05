package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Test Suite")
public class CalculatorTest {

    @Test
    @DisplayName("Square root of 4 should return 2")
    void testSquareRootOfFour() {
        assertEquals(2.0, Calculator.squareRoot(4), 0.0001);
    }

    @Test
    @DisplayName("Square root of 16 should return 4")
    void testSquareRootOfSixteen() {
        assertEquals(4.0, Calculator.squareRoot(16), 0.0001);
    }

    @Test
    @DisplayName("Square root of 25 should return 5")
    void testSquareRootOfTwentyFive() {
        assertEquals(5.0, Calculator.squareRoot(25), 0.0001);
    }

    @Test
    @DisplayName("Square root of 0 should return 0")
    void testSquareRootOfZero() {
        assertEquals(0.0, Calculator.squareRoot(0), 0.0001);
    }

    @Test
    @DisplayName("Square root of 2 should return approximately 1.414")
    void testSquareRootOfTwo() {
        assertEquals(1.414213562, Calculator.squareRoot(2), 0.000001);
    }

    @ParameterizedTest
    @DisplayName("Square root of positive numbers")
    @ValueSource(doubles = {1.0, 9.0, 100.0, 0.25})
    void testSquareRootOfPositiveNumbers(double num) {
        assertTrue(Calculator.squareRoot(num) >= 0);
    }

    @Test
    @DisplayName("Square root of negative number should throw exception")
    void testSquareRootOfNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.squareRoot(-1));
    }

    @Test
    @DisplayName("Square root of negative number should throw specific message")
    void testSquareRootNegativeNumberMessage() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> Calculator.squareRoot(-5));
        assertEquals("Cannot calculate square root of negative number", exception.getMessage());
    }

    @Test
    @DisplayName("Factorial of 0 should return 1")
    void testFactorialOfZero() {
        assertEquals(1, Calculator.factorial(0));
    }

    @Test
    @DisplayName("Factorial of 1 should return 1")
    void testFactorialOfOne() {
        assertEquals(1, Calculator.factorial(1));
    }

    @Test
    @DisplayName("Factorial of 5 should return 120")
    void testFactorialOfFive() {
        assertEquals(120, Calculator.factorial(5));
    }

    @Test
    @DisplayName("Factorial of 10 should return 3628800")
    void testFactorialOfTen() {
        assertEquals(3628800, Calculator.factorial(10));
    }

    @Test
    @DisplayName("Factorial of 3 should return 6")
    void testFactorialOfThree() {
        assertEquals(6, Calculator.factorial(3));
    }

    @ParameterizedTest
    @DisplayName("Factorial of various numbers")
    @CsvSource({
        "2, 2",
        "4, 24",
        "6, 720",
        "7, 5040"
    })
    void testFactorialOfVariousNumbers(int num, long expected) {
        assertEquals(expected, Calculator.factorial(num));
    }

    @Test
    @DisplayName("Factorial of negative number should throw exception")
    void testFactorialOfNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.factorial(-1));
    }

    @Test
    @DisplayName("Factorial of negative number should throw specific message")
    void testFactorialNegativeNumberMessage() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> Calculator.factorial(-5));
        assertEquals("Factorial is not defined for negative numbers", exception.getMessage());
    }

    @Test
    @DisplayName("Factorial greater than 20 should throw exception")
    void testFactorialGreaterThanTwenty() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.factorial(21));
    }

    @Test
    @DisplayName("Factorial of 21 should throw specific message")
    void testFactorialTooLargeMessage() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> Calculator.factorial(21));
        assertEquals("Factorial too large (max supported: 20)", exception.getMessage());
    }

    @Test
    @DisplayName("Natural log of e should return 1")
    void testNaturalLogOfE() {
        assertEquals(1.0, Calculator.naturalLog(Math.E), 0.0001);
    }

    @Test
    @DisplayName("Natural log of 1 should return 0")
    void testNaturalLogOfOne() {
        assertEquals(0.0, Calculator.naturalLog(1), 0.0001);
    }

    @Test
    @DisplayName("Natural log of 10 should return approximately 2.303")
    void testNaturalLogOfTen() {
        assertEquals(2.302585093, Calculator.naturalLog(10), 0.000001);
    }

    @Test
    @DisplayName("Natural log of 2 should return approximately 0.693")
    void testNaturalLogOfTwo() {
        assertEquals(0.693147181, Calculator.naturalLog(2), 0.000001);
    }

    @ParameterizedTest
    @DisplayName("Natural log of positive numbers")
    @ValueSource(doubles = {0.5, 5.0, 100.0, 1000.0})
    void testNaturalLogOfPositiveNumbers(double num) {
        assertDoesNotThrow(() -> Calculator.naturalLog(num));
    }

    @Test
    @DisplayName("Natural log of 0 should throw exception")
    void testNaturalLogOfZero() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.naturalLog(0));
    }

    @Test
    @DisplayName("Natural log of negative number should throw exception")
    void testNaturalLogOfNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.naturalLog(-1));
    }

    @Test
    @DisplayName("Natural log of zero should throw specific message")
    void testNaturalLogZeroMessage() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> Calculator.naturalLog(0));
        assertEquals("Cannot calculate natural log of non-positive number", exception.getMessage());
    }

    @Test
    @DisplayName("Natural log of negative number should throw specific message")
    void testNaturalLogNegativeMessage() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> Calculator.naturalLog(-5));
        assertEquals("Cannot calculate natural log of non-positive number", exception.getMessage());
    }

    @Test
    @DisplayName("Power: 2 to the power 3 should return 8")
    void testPowerTwoToThree() {
        assertEquals(8.0, Calculator.power(2, 3), 0.0001);
    }

    @Test
    @DisplayName("Power: 5 to the power 2 should return 25")
    void testPowerFiveToTwo() {
        assertEquals(25.0, Calculator.power(5, 2), 0.0001);
    }

    @Test
    @DisplayName("Power: 10 to the power 0 should return 1")
    void testPowerToZero() {
        assertEquals(1.0, Calculator.power(10, 0), 0.0001);
    }

    @Test
    @DisplayName("Power: 2 to the power 8 should return 256")
    void testPowerTwoToEight() {
        assertEquals(256.0, Calculator.power(2, 8), 0.0001);
    }

    @Test
    @DisplayName("Power: 10 to the power 0.5 should return approximately 3.162")
    void testPowerFractionalExponent() {
        assertEquals(3.162277660, Calculator.power(10, 0.5), 0.000001);
    }

    @Test
    @DisplayName("Power: 2 to the power -1 should return 0.5")
    void testPowerNegativeExponent() {
        assertEquals(0.5, Calculator.power(2, -1), 0.0001);
    }

    @Test
    @DisplayName("Power: 0 to the power 5 should return 0")
    void testPowerZeroBase() {
        assertEquals(0.0, Calculator.power(0, 5), 0.0001);
    }

    @Test
    @DisplayName("Power: 1 to the power any exponent should return 1")
    void testPowerOneBase() {
        assertEquals(1.0, Calculator.power(1, 100), 0.0001);
    }

    @ParameterizedTest
    @DisplayName("Power with various bases and exponents")
    @CsvSource({
        "2, 4, 16",
        "3, 3, 27",
        "5, 3, 125",
        "7, 2, 49"
    })
    void testPowerVariousCombinations(double base, double exponent, double expected) {
        assertEquals(expected, Calculator.power(base, exponent), 0.0001);
    }
}

