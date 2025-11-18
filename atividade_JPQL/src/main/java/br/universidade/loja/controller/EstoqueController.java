package br.universidade.loja.controller;
import br.universidade.loja.model.Estoque;
import br.universidade.loja.model.Produto;
import br.universidade.loja.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@RestController
@RequestMapping("/estoque")
public class EstoqueController {
    @Autowired
    private EstoqueRepository estRepo;
    @GetMapping
    public List<Estoque> listarTodos() {
        return estRepo.findAll();
    }
    @GetMapping("/soma")
    public Long listarTodosSoma() {
        return estRepo.findTotalItensEmEstoque();
    }
}
