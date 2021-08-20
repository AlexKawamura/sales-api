package com.xbrain.salesapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendas")
public class VendasController {

    @GetMapping
    public String listar() {
        return "Lista de vendas";
    }
}
