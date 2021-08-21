package com.xbrain.salesapi.controller;

import com.xbrain.salesapi.model.Venda;
import com.xbrain.salesapi.model.Vendedor;
import com.xbrain.salesapi.repository.VendaRepository;
import com.xbrain.salesapi.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendedores")
public class VendedoresController {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private VendaRepository vendaRepository;

    @GetMapping
    public List<Vendedor> listar() {
        return vendedorRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vendedor novoVendedor(@RequestBody Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    @PostMapping("/{vendedorId}/novaVenda")
    @ResponseStatus(HttpStatus.CREATED)
    public Venda novaVenda(@RequestBody Venda venda, @PathVariable Long vendedorId) {
        Vendedor vendedor = vendedorRepository.findById(vendedorId).get();
        vendedor.incrementarTotalVendas();
        venda.designarVendedor(vendedor);
        return vendaRepository.save(venda);
    }
}
