package br.com.fiap.SystemManagement_V10.controllers.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Tarefa {
    private BigDecimal valor;
    private LocalDate data; 
    private String descrição;
    
    
    public Tarefa(BigDecimal valor, LocalDate data, String descrição) {
        this.valor = valor;
        this.data = data;
        this.descrição = descrição;
    }


    public BigDecimal getValor() {
        return valor;
    }


    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }


    public LocalDate getData() {
        return data;
    }


    public void setData(LocalDate data) {
        this.data = data;
    }


    public String getDescrição() {
        return descrição;
    }


    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    
    
}

