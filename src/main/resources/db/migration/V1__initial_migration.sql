create table cliente
(
    id_cliente    int auto_increment
        primary key,
    nome          varchar(100)                             not null,
    telefone      varchar(20)                              null,
    email         varchar(100)                             null,
    endereço      text                                     null,
    divida        decimal(10, 2) default 0.00              null,
    data_cadastro datetime       default CURRENT_TIMESTAMP null
);

create table produto
(
    id_produto         int auto_increment
        primary key,
    nome               varchar(100)                       not null,
    descricao          text                               null,
    preco              decimal(10, 2)                     not null,
    quantidade_estoque int      default 0                 not null,
    data_cadastro      datetime default CURRENT_TIMESTAMP null
);

create table movimentacaodeestoque
(
    id_movimentacao int auto_increment
        primary key,
    id_produto      int                                null,
    tipo            enum ('entrada', 'saida')          not null,
    quantidade      int                                not null,
    data_hora       datetime default CURRENT_TIMESTAMP null,
    constraint movimentacaodeestoque_ibfk_1
        foreign key (id_produto) references produto (id_produto)
);

create index id_produto
    on movimentacaodeestoque (id_produto);

create table venda
(
    id_venda   int auto_increment
        primary key,
    data       timestamp default CURRENT_TIMESTAMP null,
    total      decimal(10, 2)                      not null,
    id_cliente int                                 null,
    constraint venda_ibfk_1
        foreign key (id_cliente) references cliente (id_cliente)
);

create table itemdevenda
(
    id_item    int auto_increment
        primary key,
    id_venda   int                                null,
    id_produto int                                null,
    quantidade int                                not null,
    subtotal   decimal(10, 2)                     not null,
    data_hora  datetime default CURRENT_TIMESTAMP null,
    constraint itemdevenda_ibfk_1
        foreign key (id_venda) references venda (id_venda)
            on delete cascade,
    constraint itemdevenda_ibfk_2
        foreign key (id_produto) references produto (id_produto)
);

create index id_produto
    on itemdevenda (id_produto);

create index id_venda
    on itemdevenda (id_venda);

create index id_cliente
    on venda (id_cliente);

