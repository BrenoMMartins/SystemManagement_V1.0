package br.com.fiap.SystemManagement_V10.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.SystemManagement_V10.models.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    Page<Tarefa> findByDescricaoContaining(String descricao, Pageable pageable);

    Page<Tarefa> findAll(Pageable pageable);

}
