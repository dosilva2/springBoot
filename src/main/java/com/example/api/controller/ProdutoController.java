package com.example.api.controller;

import com.example.api.produto.DadosAtualizacaoProdutos;
import com.example.api.produto.Produto;
import com.example.api.produto.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.example.api.DadosProdutos;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    public String cadastrar(@RequestBody DadosProdutos dados) {
        try {
            Thread.sleep(5000);
            repository.save(new Produto(dados));
            return "Produto cadastrado com sucesso!";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "Erro ao cadastrar produto!";
        }

    }

    @GetMapping
    public Page<Produto> listar(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao); // Replace with your implementation
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosAtualizacaoProdutos dados){
        var produto = repository.getReferenceById(dados.id());
        produto.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void remover(@PathVariable Long id) {
        var produto = repository.getReferenceById(id);
        produto.excluir();
    }

}
