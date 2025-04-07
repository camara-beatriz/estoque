package com.grupopti.estoque.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "movimentacaodeestoque")
public class Movimentacaodeestoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimentacao")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produto")
    private com.grupopti.estoque.entities.Produto idProduto;

    @Lob
    @Column(name = "tipo")
    private String tipo;

    @Column(name = "quantidade")
    private Integer quantidade;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "data_hora")
    private Instant dataHora;

}