package com.xbrain.salesapi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data_venda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVenda;
    @Column
    private Float valor;
    @ManyToOne
    @JoinColumn(name = "vendedor_id", nullable = false, referencedColumnName = "id")
    private Vendedor vendedor;

    @PrePersist
    void dataVenda() {
        this.dataVenda = new Date();
    }
}
