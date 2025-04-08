package com.grupopti.estoque.repositories;

import com.grupopti.estoque.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
}