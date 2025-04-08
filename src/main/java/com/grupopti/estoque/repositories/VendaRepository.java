package com.grupopti.estoque.repositories;

import com.grupopti.estoque.entities.Venda;
import org.springframework.data.repository.CrudRepository;

public interface VendaRepository extends CrudRepository<Venda, Integer> {
}