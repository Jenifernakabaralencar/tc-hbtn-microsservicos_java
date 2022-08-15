package com.example.calculator.controller;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void messageWelcome() throws Exception {
        RequestBuilder request = get("/calculator/welcome");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Bem vindo à CALCULATOR API REST.", result.getResponse().getContentAsString());
    }


    @Test
    void addNumbers() throws Exception {
        RequestBuilder request = get("/calculator/addNumbers")
                .param("number1", "5.0")
                .param("number2", "2.0");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("7.0", result.getResponse().getContentAsString());
    }

    @Test
    void subNumbers() throws Exception {
        RequestBuilder request = get("/calculator/subNumbers")
                .param("number1", "5.0")
                .param("number2", "2.0");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("3.0", result.getResponse().getContentAsString());
    }

    @Test
    void divideNumbers() throws Exception {
        RequestBuilder request = get("/calculator/divideNumbers")
                .param("number1", "10.0")
                .param("number2", "2.0");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("5.0", result.getResponse().getContentAsString());
    }

    @Test
    void factorial() throws Exception {
        RequestBuilder request = get("/calculator/factorial")
                .param("factorial", "3");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("6", result.getResponse().getContentAsString());
    }

    @Test
    void calculeDayBetweenDate() throws Exception {
        RequestBuilder request = get("/calculator/calculeDayBetweenDate")
                .param("localDate1", LocalDate.of(2020, 5, 15).format(DateTimeFormatter.ISO_DATE))
                .param("localDate2", LocalDate.of(2020, 5, 20).format(DateTimeFormatter.ISO_DATE));
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("5", result.getResponse().getContentAsString());
    }

    @Test
    void integerToBinary() throws Exception {
        RequestBuilder request = get("/calculator/integerToBinary")
                .param("number1", "5");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("101", result.getResponse().getContentAsString());
    }

    @Test
    void integerToHexadecimal() throws Exception {
        RequestBuilder request = get("/calculator/integerToHexadecimal")
                .param("number1", "12");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("C", result.getResponse().getContentAsString());
    }

}
