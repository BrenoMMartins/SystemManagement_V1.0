package br.com.fiap.SystemManagement_V10.controllers;

import br.com.fiap.SystemManagement_V10.controllers.models.Usuario;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    
    @GetMapping ("/api/usuario")
    public Usuario show(){
        return new Usuario ("mouratins", "Breno Moura", "mouratins@hotmail.com", "11944466401", "ilovc0de");
    }

}
