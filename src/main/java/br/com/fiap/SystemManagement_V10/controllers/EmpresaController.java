package br.com.fiap.SystemManagement_V10.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.SystemManagement_V10.models.Empresa;
import br.com.fiap.SystemManagement_V10.repository.EmpresaRepository;
import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

    Logger log = LoggerFactory.getLogger(EmpresaController.class);


    @Autowired
    EmpresaRepository repository;

    @GetMapping("/api/empresa")
    public List<Empresa> index(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Empresa> create(@RequestBody @Valid Empresa empresa, BindingResult result){
        if(result.hasErrors()) return ResponseEntity.badRequest().build();
        log.info("Cadastrando Empresa: " + empresa);
        repository.save(empresa);

        return ResponseEntity.status(HttpStatus.CREATED).body(empresa);
    }

    @GetMapping("{id}")
    public ResponseEntity<Empresa> show(@PathVariable long id){
        log.info("Buscando Empresa pelo id" + id);
        var empresaEncontrada = repository.findById(id);

        if (empresaEncontrada.isPresent()) {
            return ResponseEntity.ok(empresaEncontrada.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Empresa> destroy(@PathVariable Long id){
        log.info("Buscando Empresa pelo id " + id);
        var empresaEncontrada = repository.findById(id);

        if (empresaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();


        return ResponseEntity.noContent().build();        
    }

    @PutMapping("{id}")
    public ResponseEntity<Empresa> refresh(@PathVariable Long id, @RequestBody @Valid Empresa empresa){
        log.info("Buscando Empresa pelo id " + id);
        var empresaEncontrada = repository.findById(id);

        if (empresaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();

        
        empresa.setId(id);
        repository.save(empresa);
        
        return ResponseEntity.status(HttpStatus.OK).body(empresa);
    }

    
}
