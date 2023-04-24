package br.com.fiap.SystemManagement_V10.models;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.time.LocalDate;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.fiap.SystemManagement_V10.controllers.TarefaController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@Entity
@NoArgsConstructor
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nome;

    @NotBlank
    @Size(min = 5, max = 250)
    private String descricao;

    @NotNull
    private LocalDate data;

    @ManyToOne
    private Empresa empresa;

    public EntityModel <Tarefa> toEntityModel(){
        return EntityModel.of( 
            this,
            linkTo(methodOn(TarefaController.class).mostrar(id)).withSelfRel(),
            linkTo(methodOn(TarefaController.class).destruir(id)).withRel("delete"),
            linkTo(methodOn(TarefaController.class).index(null, Pageable.unpaged())).withRel("all"),
            linkTo(methodOn(TarefaController.class).mostrar(this.getEmpresa().getId())).withRel("empresa")
            );
    }

}
