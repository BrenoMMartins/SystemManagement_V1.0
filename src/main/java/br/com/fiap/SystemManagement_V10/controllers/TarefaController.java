package br.com.fiap.SystemManagement_V10.controllers;

import java.util.ArrayList;
import java.util.List;

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

import br.com.fiap.SystemManagement_V10.controllers.models.Tarefa;

@RestController
public class TarefaController {
    
    Logger log = LoggerFactory.getLogger(TarefaController.class);

    // @GetMapping ("/api/tarefa")
    // public Tarefa show(){
    //     return new Tarefa ("Plano de Voo", "Tarefa de Digital Entreprise",  LocalDate.now());
    // }

    List<Tarefa> tarefas = new ArrayList<>();

    @GetMapping("/api/tarefa")
    public List<Tarefa> index(){
        return tarefas;
    }

    @PostMapping("/api/tarefa")
    public ResponseEntity<Tarefa> criar(@RequestBody Tarefa tarefa){
        log.info("Cadastrando Tarefa: " + tarefa);
        tarefa.setId(tarefas.size() + 1l);
        tarefas.add(tarefa);

        return ResponseEntity.status(HttpStatus.CREATED).body(tarefa);
    }

    @GetMapping("/api/tarefa/{id}")
    public ResponseEntity<Tarefa> mostrar(@PathVariable long id){
        log.info("Buscando tarefa pelo id: " + id);
        var tarefaEncontrada = tarefas.stream().filter(a -> a.getId().equals(id)).findFirst();

        if (tarefaEncontrada.isPresent()) {
            return ResponseEntity.ok(tarefaEncontrada.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/api/tarefa/{id}")
    public ResponseEntity<Tarefa> destruir(@PathVariable Long id){
        log.info("Buscando tarefa pelo id " + id);
        var tarefaEncontrada = tarefas.stream().filter(a -> a.getId().equals(id)).findFirst();

        if (tarefaEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        tarefas.remove(tarefaEncontrada.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();        
    }

    @PutMapping("api/despesas/{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa){
        log.info("Buscando tarefa pelo id " + id);
        var tarefaEncontrada = tarefas.stream().filter(a -> a.getId().equals(id)).findFirst();

        if (tarefaEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        tarefas.remove(tarefaEncontrada.get());
        tarefa.setId(id);
        tarefas.add(tarefa);
        
        return ResponseEntity.status(HttpStatus.OK).body(tarefa);
    }


}