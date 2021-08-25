package com.xbrain.salesapi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String dataVenda;
    @Column
    private Float valor;
    @ManyToOne
    @JoinColumn(name = "vendedor_id", nullable = false, referencedColumnName = "id")
    private Vendedor vendedor;
}
