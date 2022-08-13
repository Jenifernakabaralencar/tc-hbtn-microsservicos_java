package com.example.user.controller;

import com.example.user.exception.CPFException;
import com.example.user.exception.UserIdException;
import com.example.user.exception.UserNameException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @GetMapping("/user-id/{id}")
    public String findById(@PathVariable int id) {
        if (id > 0 && id < 100) {
            return "You have entered valid ID";
        } else {
            throw new UserIdException(id);
        }
    }

    @GetMapping("/user-name/{userName}")
    public String findUserByName(@PathVariable String userName) {

        String msg = "";
        int quantidadeChar = userName.length();
        if (quantidadeChar > 3 && quantidadeChar < 15) {
            msg = "You have entered valid USERNAME";
        } else {
            throw new UserNameException(userName);
        }

        return msg;
    }

    @GetMapping("/user-cpf/{cpf}")
    public String findUserByCPF(@PathVariable String cpf) {

        String msg = "";
        boolean isCPFValid = isCPF(cpf);
        if (isCPFValid) {
            msg = "You have entered valid CPF";
        } else {
            throw new CPFException(cpf);
        }
        return msg;

    }

    public boolean isCPF(String CPF) {
        int quantidadeChar = CPF.length();
        if (quantidadeChar > 3 && quantidadeChar < 15) {
            return true;
        } else {
            return false;
        }
    }

}