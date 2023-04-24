package br.com.fiap.SystemManagement_V10.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.SystemManagement_V10.exception.RestNotFoundException;
import br.com.fiap.SystemManagement_V10.models.Tarefa;
import br.com.fiap.SystemManagement_V10.repository.TarefaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tarefa")
public class TarefaController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    TarefaRepository repository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    @GetMapping
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String tarefa, @PageableDefault(size = 6) Pageable pageable) {
        Page<Tarefa> tarefas = (tarefa == null)?
            repository.findAll(pageable):
            repository.findByDescricaoContaining(tarefa, pageable);

        return assembler.toModel(tarefas.map(Tarefa::toEntityModel));
    }

    @PostMapping
    public ResponseEntity<Tarefa> create(@RequestBody @Valid Tarefa tarefa, BindingResult result) {
        log.info("Cadastrando Tarefa: " + tarefa);
        repository.save(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefa);
    }

    @GetMapping("{id}")
    public EntityModel<Tarefa> mostrar(@PathVariable long id) {
        log.info("Buscando tarefa pelo id: " + id);
        return getTarefa(id).toEntityModel();
    
        
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Tarefa> destruir(@PathVariable Long id) {
        log.info("Buscando tarefa pelo id " + id);
        repository.delete(getTarefa(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public EntityModel<Tarefa> atualizar(@PathVariable Long id, @RequestBody @Valid Tarefa tarefa) {
        log.info("Buscando tarefa pelo id " + id);
        getTarefa(id);
        
        tarefa.setId(id);
        repository.save(tarefa);
        
        return tarefa.toEntityModel();
    }

    private Tarefa getTarefa(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Tarefa não encontrada"));
    }

}
