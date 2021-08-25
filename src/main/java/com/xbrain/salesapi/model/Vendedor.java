package com.xbrain.salesapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column
    private int totalVendas;
    @Column
    private float mediaVendasDiarias;
    @JsonIgnore
    @OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL)
    private List<Venda> vendas;
}
