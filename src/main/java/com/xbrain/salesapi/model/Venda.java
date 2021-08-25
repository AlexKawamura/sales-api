package com.xbrain.salesapi.model;

import lombok.Data;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @PrePersist
    void dataVenda() {
        Date dataAtual = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.dataVenda = dateFormat.format(dataAtual);
    }

    public void designarVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}
