package com.example.calculator.controller;

import com.example.calculator.model.Calculator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {

    private Calculator calculator;

    CalculatorController(){
        this.calculator = new Calculator();
    }


    @GetMapping("/welcome")
    public String messageWelcome() {
        return "Bem vindo à CALCULATOR API REST.";
    }

    @GetMapping("/addNumbers")
    public String addNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
        Double sum = calculator.sum(n1, n2);
        String result = String.valueOf(sum);
        return result;
    }

    @GetMapping("/subNumbers")
    public String subNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
        Double sub = calculator.sub(n1, n2);
        String result = String.valueOf(sub);
        return result;
    }

    @GetMapping("/divideNumbers")
    public String divideNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
        Double divide = calculator.divide(n1, n2);
        String result = String.valueOf(divide);
        return result;
    }

    @GetMapping("/factorial")
    public String factorial(@RequestParam(name = "factorial") Integer factorial) {
        Integer factorial1 = calculator.factorial(factorial);
        String result = String.valueOf(factorial1);
        return result;
    }

    @GetMapping("/calculeDayBetweenDate")
    public String calculeDayBetweenDate(
            @RequestParam("localDate1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate1,
            @RequestParam("localDate2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate2) {
        int date = calculator.calculeDayBetweenDate(localDate1, localDate2);
        String result = String.valueOf(date);
        return result;
    }

    @GetMapping("/integerToBinary")
    public String integerToBinary(@RequestParam(name = "number1") Integer n1) {
        Integer bin = calculator.integerToBinary(n1);
        String result = String.valueOf(bin);
        return result;
    }

    @GetMapping("/integerToHexadecimal")
    public String integerToHexadecimal(@RequestParam(name = "number1") Integer n1) {
        String hex = calculator.integerToHexadecimal(n1);
        String result = String.valueOf(hex);
        return result;

    }
}
