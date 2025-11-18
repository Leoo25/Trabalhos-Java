package br.universidade.loja.repository;

import br.universidade.loja.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // consultas customizadas aqui
}