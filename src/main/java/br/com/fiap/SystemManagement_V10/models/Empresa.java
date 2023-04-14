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
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Empresa {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    
    private String nome;
    
    private String email;
    
    @NotBlank @Size(min = 14, max = 14)
    private String cnpj;
    
    private String endereco;

    @NotBlank @NotNull
    private String telefone;
        
    
}

