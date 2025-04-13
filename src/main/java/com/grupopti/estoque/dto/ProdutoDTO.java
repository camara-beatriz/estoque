package com.grupopti.estoque.dto;

import java.math.BigDecimal;
import java.time.Instant;

public record ProdutoDTO(Long id,
                         String nome,
                         BigDecimal preco,
                         Integer quantidadeEstoque,
                         Instant dataCadastro) {
}




