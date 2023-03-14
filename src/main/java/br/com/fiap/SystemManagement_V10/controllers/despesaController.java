package br.com.fiap.SystemManagement_V10.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.SystemManagement_V10.controllers.models.Despesa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.RepaintManager;

@RestController
public class despesaController {

    Logger log = LoggerFactory.getLogger(despesaController.class);

    List<Despesa> despesas = new ArrayList<>();
    
    // @GetMapping("/api/despesas")
    // public Despesa show(){
    //     Despesa despesa = new Despesa((new BigDecimal(100)), LocalDate.now(), "cinema");
    //     return despesa;
    // }

    @GetMapping("/api/despesas")
    public List<Despesa> index(){
        return despesas;
    }

    @PostMapping("/api/despesas")
    public ResponseEntity<Despesa> create(@RequestBody Despesa despesa){
        log.info("Cadastrando despesa: " + despesa);
        despesa.setId(despesas.size() + 1l);
        despesas.add(despesa);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(despesa);
    }


    @GetMapping("api/despesas/{id}")
    public ResponseEntity<Despesa> show(@PathVariable Long id){
        log.info("buscando despesa com id " + id);
        var despesaEncontrada = despesas.stream().filter(d -> d.getId().equals(id)).findFirst();
        
        if (despesaEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(despesaEncontrada.get());
    }

    @DeleteMapping("api/despesas/{id}")
    public ResponseEntity<Despesa> destroy(@PathVariable Long id){
        log.info("buscando despesa com id " + id);
        var despesaEncontrada = despesas.stream().filter(d -> d.getId().equals(id)).findFirst();
        
        if (despesaEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        despesas.remove(despesaEncontrada.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("api/despesas/{id}")
    public ResponseEntity<Despesa> update(@PathVariable Long id, @RequestBody Despesa despesa){
        log.info("buscando despesa com id " + id);
        var despesaEncontrada = despesas.stream().filter(d -> d.getId().equals(id)).findFirst();
        
        if (despesaEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        despesas.remove(despesaEncontrada.get());
        despesa.setId(id);
        despesas.add(despesa);

        return ResponseEntity.status(HttpStatus.OK).body(despesa);
    }


}
