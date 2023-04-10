package br.com.fiap.SystemManagement_V10.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Empresa {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;
    
    @NotEmpty
    private String email; 
    
    @NotBlank @Size(min = 14, max = 14)
    private Integer cnpj;
    
    private String endereco;

    @NotBlank @NotNull
    private String telefone;
        
    public Empresa(String nome, String email, int cnpj, String endereco, String telefone) {
        this.nome = nome;
        this.email = email;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    
    @Override
    public String toString() {
        return "Empresa [nome=" + nome + ", email=" + email + ", cnpj=" + cnpj + ", endereco=" + endereco + ", telefone=" + telefone + "]";
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


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public Integer getCnpj() {
        return cnpj;
    }


    public void setCnpj(Integer cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }


    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }


    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
}

