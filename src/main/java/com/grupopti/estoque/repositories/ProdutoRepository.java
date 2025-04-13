package com.grupopti.estoque.repositories;

import com.grupopti.estoque.entities.Produto;
import org.springframework.data.repository.CrudRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

    List<Produto> findByDataCadastroBetween(Instant dataInicio, Instant dataFim);
    Optional<Produto> findByNome(String nome);
    void deleteByNome(String nome);
}