package com.xbrain.salesapi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;
    @Column(nullable = false)
    private Long idCliente;
    @ManyToMany
    @Column(nullable = false)
    private List<Produto> idProdutos;
    @Column(nullable = false)
    private Float valorTotal;
    @Column(nullable = false)
    private String enderecoEntrega;
}
