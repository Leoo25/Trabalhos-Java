package br.universidade.loja.controller;
import br.universidade.loja.model.Produto;
import br.universidade.loja.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoRepository prodRepo;
    @GetMapping
    public List<Produto> listarTodos() {
        return prodRepo.findAll();
    }
    @GetMapping("/buscar")
    public List<Produto> buscarPorCategoriaEPreco(
            @RequestParam String categoria,
            @RequestParam Double preco) {
        return prodRepo.findByCategoriaNomeAndPrecoLessThan(categoria, preco);
    }

}


