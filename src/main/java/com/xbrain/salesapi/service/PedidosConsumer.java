package com.xbrain.salesapi.service;

import com.xbrain.salesapi.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;

@Component
public class PedidosConsumer {

    @Autowired
    private PedidoService pedidoService;

    @RabbitListener(queues = "${queue.name}")
    public void receive(@Payload Pedido fileBody) {
        System.out.println("Message " + fileBody);

        pedidoService.saveEntrega(fileBody);
    }
}
