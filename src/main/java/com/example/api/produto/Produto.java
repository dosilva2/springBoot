package com.example.api.produto;

import com.example.api.DadosProdutos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "produtos")
@Entity(name="Produtos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal preco;
    private int estoque;
    private String descricao;
    private Boolean ativo;

    public Produto(DadosProdutos dados) {
        this.id = dados.id();
        this.nome = dados.nome();
        this.preco = dados.preco();
        this.estoque = dados.estoque();
        this.descricao = dados.descricao();

    }

    public void atualizarInformacoes(DadosAtualizacaoProdutos dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.preco() != null) {
            this.preco = dados.preco();
        }
        if (dados.estoque() != 0 ) {
            this.estoque = dados.estoque();
        }
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
