package br.universidade.loja.repository;

import br.universidade.loja.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // consultas customizadas aqui
    // 1) Listar produtos de uma categoria pelo nome

    List<Produto> findByCategoriaNome(String nomeCategoria);

// 2) Buscar produtos com preço maior que um valor informado

    List<Produto> findByPrecoGreaterThan(BigDecimal valor);

// 3) Verificar a existência de um produto pelo nome

    boolean existsByNome(String nomeProduto);
// 4) AAAAAAAAAAAA
    List<Produto> findByCategoriaNomeAndPrecoLessThan(String nomeCategoria, Double valorMaximo);



}
