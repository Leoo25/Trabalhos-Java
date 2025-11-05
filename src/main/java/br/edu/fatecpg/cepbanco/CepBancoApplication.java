package br.edu.fatecpg.cepbanco;

import br.edu.fatecpg.cepbanco.model.Endereco;
import br.edu.fatecpg.cepbanco.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class CepBancoApplication implements CommandLineRunner {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public static void main(String[] args) {
        SpringApplication.run(CepBancoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("consulta de CEP");


        List<String> cepsAConsultar = Arrays.asList("01001-000", "88034-001", "01001-000");


        List<Endereco> enderecosSimulados = Arrays.asList(
                new Endereco(1L, "01001-000", "Praça da Sé", "Sé", "São Paulo", "SP"),
                new Endereco(2L, "88034-001", "Rua Lauro Linhares", "Trindade", "Florianópolis", "SC")

        );


        for (String cep : cepsAConsultar) {
            System.out.println("CEP: " + cep);


            Optional<Endereco> enderecoExistente = enderecoRepository.findByCep(cep);

            if (enderecoExistente.isPresent()) {
                System.out.println("   CEP já existe no banco. Endereço: " + enderecoExistente.get().getLogradouro());
            } else {

                Endereco novoEndereco = enderecosSimulados.stream()
                        .filter(e -> e.getCep().equals(cep))
                        .findFirst()
                        .orElse(null);

                if (novoEndereco != null) {

                    try {
                        enderecoRepository.save(novoEndereco);
                        System.out.println(" Novo endereço: " + novoEndereco.getLogradouro());
                    } catch (DataIntegrityViolationException e) {

                        System.out.println(" Erro  " + cep );
                    }
                } else {
                    System.out.println("CEP não encontrado" + cep);
                }
            }
        }

        System.out.println("\nListando os endereços");


        List<Endereco> todosEnderecos = enderecoRepository.findAll();
        if (todosEnderecos.isEmpty()) {
            System.out.println("Nenhum endereço foi armazenado.");
        } else {
            todosEnderecos.forEach(endereco -> System.out.println("   " + endereco));
        }

        System.out.println("Foi");

    }
}