package com.xbrain.salesapi.controller;

import com.xbrain.salesapi.model.Pedido;
import com.xbrain.salesapi.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/vendas")
public class PedidosController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/pedidos")
    public List<Pedido> listarPedidos() {
        return pedidoService.findAll();
    }

    @PostMapping("/novoPedido")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido novoPedido(@RequestBody Pedido pedido) {
        return pedidoService.save(pedido);
    }
}
