package br.com.fiap.SystemManagement_V10.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class despesaController {
    
    @RequestMapping("/api/despesas")
    @ResponseBody
    public String show(){
        return "despesa";
    }

}
