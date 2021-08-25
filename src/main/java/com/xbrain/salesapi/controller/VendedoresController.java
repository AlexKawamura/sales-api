package com.xbrain.salesapi.controller;

import com.xbrain.salesapi.model.Vendedor;
import com.xbrain.salesapi.repository.VendaRepository;
import com.xbrain.salesapi.repository.VendedorRepository;
import org.joda.time.DateTime;
import org.joda.time.Days;
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

    @GetMapping("/listar")
    public List<Vendedor> listarPorPeriodo(@RequestParam String dataInicial, @RequestParam String dataFinal) {
        DateTime dInicial = new DateTime(dataInicial);
        DateTime dFinal = new DateTime(dataFinal);
        int qntDias = Days.daysBetween(dInicial, dFinal).getDays();

        List<Vendedor> vendedorList = vendedorRepository.findAll();

        for (Vendedor vendedor : vendedorList) {
            int qntVendas = vendaRepository.countByVendedorIdAndDataVendaBetween(vendedor.getId(), dataInicial, dataFinal);

            float mediaVendasDiarias = (float) qntVendas / qntDias;

            vendedor.setMediaVendasDiarias(mediaVendasDiarias);

            vendedorRepository.save(vendedor);
        }

        return vendedorList;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vendedor novoVendedor(@RequestBody Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }
}
