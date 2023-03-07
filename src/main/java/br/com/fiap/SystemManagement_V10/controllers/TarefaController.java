package br.com.fiap.SystemManagement_V10.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class TarefaController {
    
    @RequestMapping("/api/tarefa")
    @ResponseBody
    public String show(){
        return "tarefa";
    }
    
}
