package com.grupopti.estoque.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;


import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "itemdevenda")
public class Itemdevenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venda")
    private com.grupopti.estoque.entities.Venda idVenda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produto")
    private com.grupopti.estoque.entities.Produto idProduto;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "subtotal")
    private BigDecimal subtotal;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "data_hora")
    private Instant dataHora;

}