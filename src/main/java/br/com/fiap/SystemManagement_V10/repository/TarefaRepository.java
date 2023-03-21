package br.com.fiap.SystemManagement_V10.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.SystemManagement_V10.models.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    
}
