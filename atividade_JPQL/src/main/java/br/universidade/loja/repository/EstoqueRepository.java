package br.universidade.loja.repository;

import br.universidade.loja.model.Estoque;
import br.universidade.loja.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    // consultas customizadas aqui
    // 1) Obter quantidade em estoque de um produto
    @Query( value = "SELECT quantidade FROM estoque e JOIN produto p ON e.produto_id = p.id WHERE; p.nome = :nome", nativeQuery = true)
    Integer findQuantidadeByProdutoNomeNative(@Param("nome") String
                                                      nomeProduto);
    // 2) Listar produtos com estoque abaixo de um limite
    @Query(value = "SELECT p.* FROM produto p JOIN estoque e ON p.id = e.produto_id WHERE e.quantidade < :limite", nativeQuery = true)
    List<Produto> findProdutosComEstoqueAbaixoDe(@Param("limite") int limite);

    @Query(value = "SELECT SUM(quantidade) FROM estoque", nativeQuery = true)
    Long findTotalItensEmEstoque();
}
