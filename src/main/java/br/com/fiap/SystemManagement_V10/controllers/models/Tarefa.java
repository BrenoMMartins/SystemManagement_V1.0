package br.com.fiap.SystemManagement_V10.controllers.models;

import java.time.LocalDate;

public class Tarefa {
    private String nome; 
    private String descrição;
    private LocalDate data;
    
    
    public Tarefa(String nome, String descrição, LocalDate data) {
        this.nome = nome;
        this.descrição = descrição;
        this.data = data;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getDescrição() {
        return descrição;
    }


    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }


    public LocalDate getData() {
        return data;
    }


    public void setData(LocalDate data) {
        this.data = data;
    }

    
}

