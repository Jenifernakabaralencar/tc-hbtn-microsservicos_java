package com.techcamp.MegaSenaAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/megasena")
public class MegaSenaController {
    @GetMapping("/simpleMessageWelcome")
    public String mensagemBoasVindas() {
           return "Bem vindo a API REST para geração de números para a loteria Mega Sena.";
    }


    @GetMapping("/getNumbers")
    public List<Integer> numerosMegaSena() {
        Random random = new Random();

        List<Integer> lista = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
           lista.add(random.nextInt(60));
        }
        return lista.stream().sorted().collect(Collectors.toList());
    }

   }
