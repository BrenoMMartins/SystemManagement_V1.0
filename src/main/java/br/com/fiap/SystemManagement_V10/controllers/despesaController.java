package br.com.fiap.SystemManagement_V10.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class despesaController {
    
    @GetMapping("/api/despesas")
    public String show(){
        return "Despesas do System";
    }

}
