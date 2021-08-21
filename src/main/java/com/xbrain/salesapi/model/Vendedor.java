package com.xbrain.salesapi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column
    private int total_vendas;
}
