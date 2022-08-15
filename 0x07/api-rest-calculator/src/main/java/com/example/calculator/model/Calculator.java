package com.example.calculator.model;

import java.time.LocalDate;
import java.time.Period;


public class Calculator {

    public Double sum(Double number1, Double number2) {
        if (number1 == null) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
        if (number2 == null) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
        double result = number1 + number2;
        return result;

    }

    public Double sub(Double number1, Double number2) {
        if (number1 == null) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
        if (number2 == null) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
        double result = number1 - number2;
        return result;

    }

    public Double divide(Double number1, Double number2) {
        if (number1 == null) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
        if (number2 == null) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }if (number2 == 0){
            throw new ArithmeticException("Divisão por zero não é permitido.");
        }
        double result = number1 / number2;
        return result;

    }

    public Integer factorial(Integer factorial) {
        if (factorial == null){
            throw new NullPointerException("Número é obrigatório.");
        }
        if (factorial == 0) {
            return 1;
        }
        int total = 1;
        for (int i = factorial; i > 1; i--) {
            total *= i;
        }
        return total;

    }

    // Exemplos:
    // Integer = 1 -> Binary = 1
    // Integer = 5 -> Binary = 101
    // Integer = 20 -> Binary = 10100
    public Integer integerToBinary(Integer integer) {
        int binario = 0;
        int base = 10;
        int exp = 0;
        while (integer > 0) {
            int digBin = integer % 2;
            binario = (digBin * (int) Math.pow(base, exp)) + binario;
            exp++;
            integer /= 2;
        }
        return binario;
    }

    // Exemplos:
    // Integer = 1 -> Hexadecimal = "1"
    // Integer = 5 -> Hexadecimal = "37"
    // Integer = 170 -> Binary = "AA"
    public String integerToHexadecimal(Integer integer) {
        String hexNumber = Integer.toHexString(integer);
        hexNumber = hexNumber.toUpperCase();
        return hexNumber;
    }

    // Exemplos
    // Date 1 = LocalDate.of(2020, 3, 15);
    // Date 2 = LocalDate.of(2020, 3, 29)
    // Total de dias = 14
    public int calculeDayBetweenDate(LocalDate date1, LocalDate date2) {
        Period period = Period.between(date1, date2);
        int years = Math.abs(period.getDays());
        return years;
    }

}
