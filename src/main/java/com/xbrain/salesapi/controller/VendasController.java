package com.xbrain.salesapi.controller;

import com.xbrain.salesapi.model.Venda;
import com.xbrain.salesapi.model.Vendedor;
import com.xbrain.salesapi.repository.VendaRepository;
import com.xbrain.salesapi.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendasController {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    @GetMapping
    public List<Venda> listar() {
        return vendaRepository.findAll();
    }

    @PostMapping("/{vendedorId}/novaVenda")
    @ResponseStatus(HttpStatus.CREATED)
    public Venda novaVenda(@RequestBody Venda venda, @PathVariable Long vendedorId) {
        Vendedor vendedor = vendedorRepository.findById(vendedorId).get();
        vendedor.setTotalVendas(vendedor.getTotalVendas() + 1);
        vendedorRepository.save(vendedor);

        Date dataAtual = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        venda.setDataVenda(dateFormat.format(dataAtual));
        venda.setVendedor(vendedor);

        return vendaRepository.save(venda);
    }
}
