package br.com.fiap.SystemManagement_V10.models;

import java.time.LocalDate;

public class Tarefa {

    private Long id;
    private String nome; 
    private String descricao;
    private LocalDate data;
        
    public Tarefa(String nome, String descricao, LocalDate data) {
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "Tarefa [nome=" + nome + ", descricao=" + descricao + ", data=" + data + "]";
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public LocalDate getData() {
        return data;
    }


    public void setData(LocalDate data) {
        this.data = data;
    }

    
}

