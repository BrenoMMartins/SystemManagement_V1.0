package br.com.fiap.SystemManagement_V10.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.SystemManagement_V10.models.Empresa;
import br.com.fiap.SystemManagement_V10.repository.EmpresaRepository;
import java.util.List;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    EmpresaRepository empresaRepository;

    @Override
    public void run(String... args) throws Exception {

        empresaRepository.saveAll(List.of(
                new Empresa((long) 1, "FIAP", "fiap@fiap.com.br", "28252381000115",
                        "Avenida Lins de Vasconselos, 1222", "(11)33858010"),
                new Empresa((long) 2, "Stefanini", "info@stefanini.com.br", "01530329000127",
                        "Avenida Deputado Cristovam Chiaradia, 670", "(31)30253800")));

    }

}
