package com.xbrain.salesapi.repository;

import com.xbrain.salesapi.model.Vendedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> { }
