package com.xbrain.salesapi.controller;

import com.xbrain.salesapi.model.Venda;
import com.xbrain.salesapi.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendasController {

    @Autowired
    private VendaRepository vendaRepository;

    @GetMapping
    public List<Venda> listar() {
        return vendaRepository.findAll();
    }
}
