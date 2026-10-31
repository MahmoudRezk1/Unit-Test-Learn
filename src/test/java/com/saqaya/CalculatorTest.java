package com.saqaya;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math operations in Calculator class")
class CalculatorTest {
    Calculator calculator;

    @BeforeAll
    static void setup() {
        System.out.println("Executing @BeforeAll method.");
    }

    @AfterAll
    static void cleanup() {
        System.out.println("Executing @AfterAll method.");
    }

    @BeforeEach
    void beforeEachTestMethod() {
        calculator = new Calculator();
        System.out.println("Executing @BeforeEach method.");
    }

    @AfterEach
    void afterEachTestMethod() {
        System.out.println("Executing @AfterEach method.");
    }

    // tes<System Under Test>_<Condition or State Change>_<Expected Result>
    @DisplayName("Test 4/2 = 2")
    @Test
    void testIntegerDivision_WhenFourIsDividedByTwo_ShouldReturnTwo() {
        System.out.println("Running Test 4/2 = 2");
        // Arrange  // Given
        int dividend = 4;
        int divisor = 2;
        int expectedResult = 2;

        // Act  // When
        int actualResult = calculator.integerDivision(dividend, divisor);

        // Assert   // Then
        assertEquals(expectedResult, actualResult, "4/2 did not produce 2");
    }

    //@Disabled("TODO: Still need to work on it")
    @DisplayName("Division by zero")
    @Test
    void testIntegerDivision_WhenDividendIsDividedByZero_ShouldThrowArithmeticException() {
        System.out.println("Running Division by zero");

        // Arrange
        int dividend = 4;
        int divisor = 0;
        String expectedExceptionMessage = "/ by zero";

        // Act & Assert
        ArithmeticException actualException = assertThrows(ArithmeticException.class, () -> {
            // Act
            calculator.integerDivision(dividend, divisor);
        }, "Division by zero should have thrown an Arithmetic exception");

        // Assert
        assertEquals(expectedExceptionMessage, actualException.getMessage(), "Unexpected exception message");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Ahmed", "Mahmoud", "Ali"})
    void valueSourceDemonstration(String firstName){
        System.out.println(firstName);
        assertNotNull(firstName);
    }

    @DisplayName("Test integer subtraction [minuend, subtrahend, expectedResult]")
    @ParameterizedTest
    @CsvFileSource(resources = "/integerSubtraction.csv")
    void integerSubtraction(int minuend, int subtrahend, int expectedResult) {
        System.out.println("Running Test " + minuend + "-" + subtrahend + " = " + expectedResult);

        int actualResult = calculator.integerSubtraction(minuend, subtrahend);

        // write the error message in lambda expression to lazy load it (will be calculated only in error case)
        assertEquals(expectedResult, actualResult,
                () -> minuend + "-" + subtrahend + " did not produce " + expectedResult);
    }

    @DisplayName("Square root of a negative number")
    @Test
    void testSquareRoot_WhenNumberIsNegative_ShouldThrowIllegalArgumentException() {
        // Arrange
        double number = -9;
        String expectedMessage = "Cannot calculate square root of a negative number";

        // Act & Assert
        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class,
                () -> calculator.squareRoot(number),
                "Square root of negative number should throw IllegalArgumentException");

        // Assert
        assertEquals(expectedMessage, actualException.getMessage(), "Unexpected exception message");
    }
}