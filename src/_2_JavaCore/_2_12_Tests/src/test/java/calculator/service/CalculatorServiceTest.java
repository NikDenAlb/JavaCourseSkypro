package calculator.service;

import calculator.exception.CannotDivideByZeroException;
import calculator.service.impl.CalculatorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceTest {
    private CalculatorService calculatorService;

    @BeforeEach
    public void setUp() {
        calculatorService = new CalculatorServiceImpl();
    }

    @Test
    void plus() {
        String actual = calculatorService.plus(1, 2);
        String expected = 1 + "+" + 2 + "=" + 3;
        assertEquals(expected, actual);
    }

    @Test
    void minus() {
        String actual = calculatorService.minus(1, 2);
        String expected = 1 + "-" + 2 + "=" + -1;
        assertEquals(expected, actual);
    }

    @Test
    void multiply() {
        String actual = calculatorService.multiply(2, 3);
        String expected = 2 + "*" + 3 + "=" + 6;
        assertEquals(expected, actual);
    }

    @Test
    void divide() {
        String actual = calculatorService.divide(6, 4);
        String expected = 6 + "/" + 4 + "=" + 1.5;
        assertEquals(expected, actual);
    }

    @Test
    void willThrowDivideByZeroException() {
        assertThrows(CannotDivideByZeroException.class, () -> calculatorService.divide(1, 0));
    }

    static Stream<Arguments> argsForPlus() {
        int a1 = 8;
        int a2 = -5;
        int a3 = 3;
        int b1 = 12;
        int b2 = -9;
        int b3 = 3;
        int c1 = 21;
        int c2 = 28;
        int c3 = 49;
        return Stream.of(Arguments.of(a1, a2, a1 + "+" + a2 + "=" + a3),
                Arguments.of(b1, b2, b1 + "+" + b2 + "=" + b3),
                Arguments.of(c1, c2, c1 + "+" + c2 + "=" + c3));
    }

    @ParameterizedTest
    @MethodSource("argsForPlus")
    void plus(int num1, int num2, String expectedResult) {
        String actual = calculatorService.plus(num1, num2);
        assertEquals(expectedResult, actual);
    }

    static Stream<Arguments> argsForMinus() {
        int a1 = 11;
        int a2 = 7;
        int a3 = 4;
        int b1 = 6;
        int b2 = 2;
        int b3 = 4;
        int c1 = 13;
        int c2 = -1;
        int c3 = 14;
        return Stream.of(Arguments.of(a1, a2, a1 + "-" + a2 + "=" + a3),
                Arguments.of(b1, b2, b1 + "-" + b2 + "=" + b3),
                Arguments.of(c1, c2, c1 + "-" + c2 + "=" + c3));
    }

    @ParameterizedTest
    @MethodSource("argsForMinus")
    void minus(int num1, int num2, String expectedResult) {
        String actual = calculatorService.minus(num1, num2);
        assertEquals(expectedResult, actual);
    }

    static Stream<Arguments> argsForMultiply() {
        int a1 = 5;
        int a2 = 5;
        int a3 = 25;
        int b1 = 6;
        int b2 = -6;
        int b3 = -36;
        int c1 = 4;
        int c2 = 8;
        int c3 = 32;
        return Stream.of(Arguments.of(a1, a2, a1 + "*" + a2 + "=" + a3),
                Arguments.of(b1, b2, b1 + "*" + b2 + "=" + b3),
                Arguments.of(c1, c2, c1 + "*" + c2 + "=" + c3));
    }

    @ParameterizedTest
    @MethodSource("argsForMultiply")
    void multiply(int num1, int num2, String expectedResult) {
        String multiply = calculatorService.multiply(num1, num2);
        assertEquals(expectedResult, multiply);
    }

    static Stream<Arguments> argsForDivide() {
        int a1 = 8;
        int a2 = 3;
        double a3 = 2 + (double) 2 / 3;
        int b1 = 72;
        int b2 = 8;
        double b3 = 9;
        int c1 = 32;
        int c2 = -3;
        double c3 = -10 - (double) 2 / 3;
        return Stream.of(Arguments.of(a1, a2, a1 + "/" + a2 + "=" + a3),
                Arguments.of(b1, b2, b1 + "/" + b2 + "=" + b3),
                Arguments.of(c1, c2, c1 + "/" + c2 + "=" + c3));
    }

    @ParameterizedTest
    @MethodSource("argsForDivide")
    void divide(int num1, int num2, String expectedResult) {
        String divide = calculatorService.divide(num1, num2);
        assertEquals(expectedResult, divide);
    }
}
