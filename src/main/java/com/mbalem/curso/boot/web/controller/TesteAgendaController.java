package com.mbalem.curso.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Cadastrar")
public class TesteAgendaController {

        @GetMapping("/Horarios")
        public String Agenda(){
            return "/MeuTeste/Agenda";
        }

}
