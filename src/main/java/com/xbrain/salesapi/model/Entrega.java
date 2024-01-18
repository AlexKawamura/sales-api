package com.xbrain.salesapi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long idPedido;
    @Column(nullable = false)
    private String enderecoEntrega;
}
