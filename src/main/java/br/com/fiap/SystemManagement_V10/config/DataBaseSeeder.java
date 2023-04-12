import java.math.BigDecimal;

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
        contaRepository.saveAll(List.of(
            new Empresa(1, "FIAP", "gumora18@hotmail.com", Integer(02266454000134)),
            new Empresa(2L, "bradesco", new BigDecimal(50), "coin"),
            new Empresa(3L, "carteira", new BigDecimal(2), "coin")
        ));

    }

}