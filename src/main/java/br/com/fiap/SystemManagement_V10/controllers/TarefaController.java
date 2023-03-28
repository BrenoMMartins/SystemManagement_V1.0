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

import br.com.fiap.SystemManagement_V10.models.Tarefa;
import br.com.fiap.SystemManagement_V10.repository.TarefaRepository;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/tarefa")
public class TarefaController {
    
    Logger log = LoggerFactory.getLogger(TarefaController.class);
    
    @Autowired
    TarefaRepository repository;

    @GetMapping("/api/tarefa")
    public List<Tarefa> index(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Tarefa> create(@RequestBody @Valid Tarefa tarefa, BindingResult result){
        if(result.hasErrors()) return ResponseEntity.badRequest().build();
        log.info("Cadastrando Tarefa: " + tarefa);
        repository.save(tarefa);

        return ResponseEntity.status(HttpStatus.CREATED).body(tarefa);
    }

    @GetMapping("{id}")
    public ResponseEntity<Tarefa> mostrar(@PathVariable long id){
        log.info("Buscando tarefa pelo id: " + id);
        var tarefaEncontrada = repository.findById(id);

        if (tarefaEncontrada.isPresent()) {
            return ResponseEntity.ok(tarefaEncontrada.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Tarefa> destruir(@PathVariable Long id){
        log.info("Buscando tarefa pelo id " + id);
        var tarefaEncontrada = repository.findById(id);

        if (tarefaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();


        return ResponseEntity.noContent().build();        
    }

    @PutMapping("{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @RequestBody @Valid Tarefa tarefa){
        log.info("Buscando tarefa pelo id " + id);
        var tarefaEncontrada = repository.findById(id);

        if (tarefaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();

        
        tarefa.setId(id);
        repository.save(tarefa);
        
        return ResponseEntity.status(HttpStatus.OK).body(tarefa);
    }


}
