package br.com.fiap.SystemManagement_V10.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

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
    private Integer cnpj;
    
    private String endereco;

    @NotBlank @NotNull
    private String telefone;
        
    
}

