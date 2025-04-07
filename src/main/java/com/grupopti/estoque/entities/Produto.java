package com.grupopti.estoque.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Lob
    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco")
    private BigDecimal preco;

    @ColumnDefault("0")
    @Column(name = "quantidade_estoque")
    private Integer quantidadeEstoque;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "data_cadastro")
    private Instant dataCadastro;

    @OneToMany(mappedBy = "idProduto")
    private Set<Itemdevenda> itemdevendas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idProduto")
    private Set<Movimentacaodeestoque> movimentacaodeestoques = new LinkedHashSet<>();

}