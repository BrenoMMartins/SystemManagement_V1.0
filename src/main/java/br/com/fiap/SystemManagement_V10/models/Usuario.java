package br.com.fiap.SystemManagement_V10.models;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;



@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@Entity
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

    public static Empresa getUsuario() {
        return null;
    }
    

}
