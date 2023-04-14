package br.com.fiap.SystemManagement_V10.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.SystemManagement_V10.models.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    void saveAll(List<Empresa> of, Empresa empresa);
    
}