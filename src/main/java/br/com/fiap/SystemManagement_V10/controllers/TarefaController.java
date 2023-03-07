package br.com.fiap.SystemManagement_V10.controllers;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.fiap.SystemManagement_V10.controllers.models.Tarefa;

@Controller
public class TarefaController {
    
    @GetMapping("/api/despesa")
    public Tarefa show(){
        var tarefa = new Tarefa(new BigDecimal(100), LocalDate.now(), "Plano de Voo");
        return tarefa;
    }

}