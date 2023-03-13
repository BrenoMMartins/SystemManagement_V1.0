package br.com.fiap.SystemManagement_V10.controllers;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.SystemManagement_V10.controllers.models.Tarefa;

@Controller
public class TarefaController {
    
    @GetMapping("/api/tarefa")
    public Tarefa show(){
        return new Tarefa = new Tarefa("Plano de Voo", LocalDate.now(), "Tarefa de Digital Entreprise");
    }

}