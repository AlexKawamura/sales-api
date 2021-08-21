package com.xbrain.salesapi.controller;

import com.xbrain.salesapi.model.Vendedor;
import com.xbrain.salesapi.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vendedores")
public class VendedoresController {

    @Autowired
    private VendedorRepository vendedorRepository;

    @GetMapping
    public List<Vendedor> listar() {
        return vendedorRepository.findAll();
    }
}
