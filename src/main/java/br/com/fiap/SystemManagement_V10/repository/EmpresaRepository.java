package br.com.fiap.SystemManagement_V10.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.SystemManagement_V10.models.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    
}