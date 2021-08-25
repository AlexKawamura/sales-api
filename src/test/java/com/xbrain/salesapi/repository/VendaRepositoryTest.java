package com.xbrain.salesapi.repository;

import com.xbrain.salesapi.model.Venda;
import com.xbrain.salesapi.model.Vendedor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Testes para Vendas")
class VendaRepositoryTest {
    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    @Test
    @DisplayName("Criar nova venda com sucesso")
    void salvar_venda_comSucesso() {
        Vendedor vendedor = criarVendedor();
        Vendedor vendedorCriado = vendedorRepository.save(vendedor);

        Assertions.assertThat(vendedorCriado).isNotNull();
        Assertions.assertThat(vendedorCriado.getId()).isNotNull();
        Assertions.assertThat(vendedorCriado.getNome()).isNotNull().isEqualTo(vendedor.getNome());

        Venda venda = criarVenda(vendedor);
        Venda vendaCriada = vendaRepository.save(venda);

        Assertions.assertThat(vendaCriada).isNotNull();
        Assertions.assertThat(vendaCriada.getId()).isNotNull();
        Assertions.assertThat(vendaCriada.getDataVenda()).isNotNull();
        Assertions.assertThat(vendaCriada.getValor()).isEqualTo(venda.getValor());
        Assertions.assertThat(vendaCriada.getVendedor()).isNotNull();
    }

    private Vendedor criarVendedor() {
        Vendedor vendedor = new Vendedor();
        vendedor.setNome("Teste");

        return vendedor;
    }

    private Venda criarVenda(Vendedor vendedor) {
        Venda venda = new Venda();

        Date dataAtual = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        venda.setDataVenda(dateFormat.format(dataAtual));
        venda.setValor(100f);
        venda.setVendedor(vendedor);

        return venda;
    }
}