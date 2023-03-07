package br.com.fiap.SystemManagement_V10.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.SystemManagement_V10.controllers.models.Despesa;
import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
public class despesaController {
    
    @GetMapping("/api/despesas")
    public Despesa show(){
        Despesa despesa = new Despesa((new BigDecimal(100)), LocalDate.now(), "cinema");
        return despesa;
    }

}
