package com.grupopti.estoque.repositories;

import com.grupopti.estoque.entities.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
}