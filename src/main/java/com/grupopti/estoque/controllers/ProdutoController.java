package com.grupopti.estoque.controllers;


import com.grupopti.estoque.dto.ProdutoDTO;

import com.grupopti.estoque.entities.Produto;
import com.grupopti.estoque.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;


@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/produtos")
    public Produto salvarProduto(@RequestBody ProdutoDTO dto) {
        return produtoService.saveProduct(dto);
    }

    @DeleteMapping("/produtos/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoService.deleteProduct(id);
    }

    @DeleteMapping("/produtos")
    public void deletarProdutoPorNome(@RequestParam String nome) {
        produtoService.deleteProductByName(nome);
    }

    @GetMapping("/produtos")
    public List<ProdutoDTO> obterProdutos(){
        return produtoService.getAllProducts();
    }

    @PatchMapping("/produtos/{id}/quantidade")
    public Produto atualizarQuantidadeEstoque(@PathVariable Long id, @RequestParam Integer quantidade) {
        return produtoService.atualizarQuantidadeEstoque(id, quantidade);
    }

    @GetMapping("/produtos/por-data")
    public List<ProdutoDTO> buscarProdutosPorDataCadastro(@RequestParam Instant inicio, @RequestParam Instant fim) {
        return produtoService.buscarPorDataCadastro(inicio, fim);
    }
}
