package br.universidade.loja;

import br.universidade.loja.model.Categoria;
import br.universidade.loja.model.Estoque;
import br.universidade.loja.model.Produto;
import br.universidade.loja.repository.CategoriaRepository;
import br.universidade.loja.repository.EstoqueRepository;
import br.universidade.loja.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class LojaApplication implements CommandLineRunner {
	@Autowired
	private CategoriaRepository catRepo;
	@Autowired
	private ProdutoRepository prodRepo;
	@Autowired
	private EstoqueRepository estRepo;



    public static void main(String[] args) {
		SpringApplication.run(LojaApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Loja inicializada!");
        List<Produto> resultado = prodRepo.findByCategoriaNomeAndPrecoLessThan("Eletrônicos", 2000.0);
        resultado.forEach(System.out::println);

        Long total = estRepo.findTotalItensEmEstoque();
        System.out.println("Total de itens no estoque: " + total);


    }

}
