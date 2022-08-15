package com.example.calculator.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    void sumTest() {
        double a = 5;
        double b = 5;
        Double result = calculator.sum(a, b);
        assertEquals(result,10);

    }

    @Test
    public void numbersNullSumTest() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            double sum = calculator.sum(1.0, null);
        });

        Assertions.assertEquals("Número 1 e número 2 são obrigatórios.", thrown.getMessage());

    }

    @Test
    void subTest() {
        double a = 10;
        double b = 7;
        Double result = calculator.sub(a, b);
        assertEquals(result,3);
    }

    @Test
    void divideTest() {
        double a = 10;
        double b = 2;
        Double result = calculator.divide(a, b);
        assertEquals(result, 5);

    }

    @Test()
    public void divisionByZeroTest() {
        double a = 10;
        double b = 0;
        Exception thrown = Assertions.assertThrows(Exception.class, () ->{
            Double divide = calculator.divide(a, b);
        });

    }

    @Test
    public void factorialTest() {
        Integer a = 5;
        Integer result = calculator.factorial(a);
        assertEquals(result, 120);

    }

    @Test
    void integerToBinaryTest() {
       Integer a = 14;
        Integer result = calculator.integerToBinary(a);
        assertEquals(result, 1110);
    }

    @Test
    void integerToHexadecimalTest() {
        Integer a = 500;
        String Result = calculator.integerToHexadecimal(a);
        assertEquals(Result, "1F4");

    }

    @Test
    void calculeDayBetweenDateTest() {
        LocalDate a = LocalDate.of(2020, 03, 16);
        LocalDate b = LocalDate.of(2020, 03, 31 );
        int result = calculator.calculeDayBetweenDate(a, b);
        assertEquals(result, 15);

    }
}
