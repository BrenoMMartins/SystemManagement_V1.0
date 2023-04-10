package br.com.fiap.SystemManagement_V10.models;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String login;
    
    @NotBlank @Size(min = 5, max = 35)
    private String nome;
    
    @NotNull
    private String email;
    
    @NotBlank @Size(min = 10, max = 11)
    private String telefone;
    
    @NotBlank
    private String senha;

    protected Usuario (){}
    
    public Usuario(String login, String nome, String email, String telefone, String senha) {
        this.login = login;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario [login=" + login + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", senha=" + senha + "]";
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getLogin() {
        return login;
    }


    public void setLogin(String login) {
        this.login = login;
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


    public String getTelefone() {
        return telefone;
    }


    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getSenha() {
        return senha;
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }
    

}
