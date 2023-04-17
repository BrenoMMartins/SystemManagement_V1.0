package br.com.fiap.SystemManagement_V10.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.SystemManagement_V10.models.Empresa;
import br.com.fiap.SystemManagement_V10.models.Tarefa;
import br.com.fiap.SystemManagement_V10.repository.TarefaRepository;
import br.com.fiap.SystemManagement_V10.repository.EmpresaRepository;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataBaseSeeder implements CommandLineRunner {

        @Autowired
        EmpresaRepository empresaRepository;

        @Autowired
        TarefaRepository tarefaRepository;

        @Override
        public void run(String... args) throws Exception {
                Empresa e1 = new Empresa((long) 1, "FIAP", "fiap@fiap.com.br", "28252381000115",
                                "Avenida Lins de Vasconselos, 1222", "(11)33858010");
                Empresa e2 = new Empresa((long) 2, "Stefanini", "info@stefanini.com.br", "01530329000127",
                                "Avenida Deputado Cristovam Chiaradia, 670", "(31)30253800");
                empresaRepository.saveAll(List.of(
                                e1,
                                e2));

                tarefaRepository.saveAll(List.of(
                                Tarefa.builder().nome("Pagination")
                                                .descricao("Tarefa de Digital Business Enablement")
                                                .data(LocalDate.now())
                                                .empresa(e1)
                                                .build(),

                                Tarefa.builder().nome("Relacionamento")
                                                .descricao("Tarefa de Digital Business Enablement")
                                                .data(LocalDate.now())
                                                .empresa(e1)
                                                .build(),

                                Tarefa.builder().nome("Preparação FrontEnd")
                                                .descricao("Tarefa Stefanini")
                                                .data(LocalDate.now())
                                                .empresa(e2)
                                                .build(),

                                Tarefa.builder().nome("CRUD")
                                                .descricao("Tarefa de Digital Business Enablement")
                                                .data(LocalDate.now())
                                                .empresa(e1)
                                                .build(),

                                Tarefa.builder().nome("Suporte Tecnico para fabrica 02")
                                                .descricao("Tarefa Stefanini")
                                                .data(LocalDate.now())
                                                .empresa(e2)
                                                .build(),

                                Tarefa.builder().nome("Modelagem Banco de Dados")
                                                .descricao("Tarefa de Database")
                                                .data(LocalDate.now())
                                                .empresa(e1)
                                                .build(),

                                Tarefa.builder().nome("Criação App de Clima")
                                                .descricao("Tarefa de Hybrid Mobile")
                                                .data(LocalDate.now())
                                                .empresa(e1)
                                                .build(),

                                Tarefa.builder().nome("Suporte Tecnico para fabrica 223")
                                                .descricao("Tarefa Stefanini")
                                                .data(LocalDate.now())
                                                .empresa(e2)
                                                .build(),

                                Tarefa.builder().nome("Reunião de Planejamento")
                                                .descricao("Tarefa Stefanini")
                                                .data(LocalDate.now())
                                                .empresa(e2)
                                                .build(),

                                Tarefa.builder().nome("Checkpoint 2 Compliance AND Quality Assurance")
                                                .descricao("Tarefa de Compliance AND Quality Assurance")
                                                .data(LocalDate.now())
                                                .empresa(e1)
                                                .build()));

        }

}
