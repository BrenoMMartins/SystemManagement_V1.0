package br.com.fiap.SystemManagement_V10.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.SystemManagement_V10.models.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    Page<Tarefa> findByDescricaoContaining(String descricao, org.springframework.data.domain.Pageable pageable);

    Page<Tarefa> findAll(Pageable pageable);

}
