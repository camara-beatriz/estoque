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
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @Lob
    @Column(name = "endereco")
    private String endereco;

    @ColumnDefault("0.00")
    @Column(name = "divida")
    private BigDecimal divida;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "data_cadastro")
    private Instant dataCadastro;

    @OneToMany(mappedBy = "idCliente")
    private Set<com.grupopti.estoque.entities.Venda> vendas = new LinkedHashSet<>();

}