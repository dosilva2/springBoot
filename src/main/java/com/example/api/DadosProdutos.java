package com.example.api;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;

public record DadosProdutos(
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        BigDecimal preco,
        int estoque,
        String descricao,
        int ativo
){
}
