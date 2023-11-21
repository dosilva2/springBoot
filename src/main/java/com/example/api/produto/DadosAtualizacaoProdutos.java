package com.example.api.produto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosAtualizacaoProdutos(
        @NotNull
        Long id,
        String nome,
        BigDecimal preco,
        int estoque,
        String descricao) {

}
