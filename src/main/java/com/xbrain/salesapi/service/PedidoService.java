package com.xbrain.salesapi.service;

import com.xbrain.salesapi.model.Entrega;
import com.xbrain.salesapi.model.Pedido;
import com.xbrain.salesapi.repository.EntregaRepository;
import com.xbrain.salesapi.repository.PedidoRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private EntregaRepository entregaRepository;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;

    public Pedido save(Pedido pedido) {
        Pedido p = pedidoRepository.save(pedido);

        rabbitTemplate.convertAndSend(exchange, routingJsonKey, p);

        return p;
    }

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public void saveEntrega(Pedido pedido) {
        Entrega entrega = pedidoRepository.of(pedido);

        entregaRepository.save(entrega);
    }
}
