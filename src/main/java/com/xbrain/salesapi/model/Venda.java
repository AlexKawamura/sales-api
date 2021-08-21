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
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVenda;
    @Column
    private Float valor;

    @PrePersist
    void dataVenda() {
        this.dataVenda = new Date();
    }
}
