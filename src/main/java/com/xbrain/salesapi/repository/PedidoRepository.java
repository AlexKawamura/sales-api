package com.xbrain.salesapi.repository;

import com.xbrain.salesapi.model.Entrega;
import com.xbrain.salesapi.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
     default Entrega of(Pedido pedido){
         Entrega e = new Entrega();
         e.setIdPedido(pedido.getIdPedido());
         e.setEnderecoEntrega(pedido.getEnderecoEntrega());
        return e;
    }
}
