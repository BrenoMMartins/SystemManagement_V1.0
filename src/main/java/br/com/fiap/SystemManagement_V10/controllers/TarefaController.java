package br.com.fiap.SystemManagement_V10.controllers;


import java.time.LocalDate;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.SystemManagement_V10.controllers.models.Tarefa;

@RestController
public class TarefaController {
    
    @GetMapping ("/api/tarefa")
    public Tarefa show(){
        return new Tarefa ("Plano de Voo", "Tarefa de Digital Entreprise",  LocalDate.now());
    }

}