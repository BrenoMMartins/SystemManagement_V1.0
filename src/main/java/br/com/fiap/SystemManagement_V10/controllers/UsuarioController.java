package br.com.fiap.SystemManagement_V10.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;



import br.com.fiap.SystemManagement_V10.controllers.models.Usuario;

@RestController
public class UsuarioController {
    
    Logger log = LoggerFactory.getLogger(UsuarioController.class);

    List<Usuario> usuarios = new ArrayList <>();
    
    
    @GetMapping ("/api/usuario")
    public List<Usuario> index(){
        return usuarios;
    }

    @PostMapping("/api/usuario")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
        log.info("Cadastrando usuario: " + usuario);
        usuario.setId(usuarios.size() + 1l);
        usuarios.add(usuario);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
    
    @GetMapping ("/api/usuario/{id}")
    public ResponseEntity<Usuario> show(@PathVariable Long id){
        log.info("buscando usuarios com id " + id);
        var usuarioEncontrado = usuarios.stream().filter(d -> d.getId().equals(id)).findFirst();

        if (usuarioEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(usuarioEncontrado.get());
            

    }

    @DeleteMapping("api/usuario/{id}")
    public ResponseEntity<Usuario> destroy(@PathVariable Long id){
        log.info("buscando usuario com id " + id);
        var usuarioEncontrado = usuarios.stream().filter(d -> d.getId().equals(id)).findFirst();
        
        if (usuarioEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        usuarios.remove(usuarioEncontrado.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("api/usuario/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario){
        log.info("buscando usuario com id " + id);
        var usuarioEncontrado = usuarios.stream().filter(d -> d.getId().equals(id)).findFirst();
        
        if (usuarioEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        usuarios.remove(usuarioEncontrado.get());
        usuario.setId(id);
        usuarios.add(usuario);

        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

}
