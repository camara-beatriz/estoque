package com.grupopti.estoque.services;

import com.grupopti.estoque.dto.ProdutoDTO;
import com.grupopti.estoque.entities.Produto;
import com.grupopti.estoque.exceptions.ResourceNotFoundException;
import com.grupopti.estoque.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProdutoService {

        @Autowired
        private ProdutoRepository repository;

        private List<ProdutoDTO> converteDados(List<Produto> produtos){
            return produtos.stream()
                    .map(s -> new ProdutoDTO(s.getId(), s.getNome(), s.getPreco(), s.getQuantidadeEstoque(), s.getDataCadastro()))
                    .collect(Collectors.toList());
        }

        private Produto converterParaEntidade(ProdutoDTO dto) {
            Produto produto = new Produto();
            produto.setNome(dto.nome());
            produto.setPreco(dto.preco());
            produto.setQuantidadeEstoque(dto.quantidadeEstoque());
            produto.setDataCadastro(dto.dataCadastro());
            return produto;
        }

        public List<ProdutoDTO> getAllProducts() {
            return converteDados((List<Produto>) repository.findAll());
        }

        public Produto getProductById(Long id) {
            return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Produto com ID " + id + " não encontrado."));
        }


        public Produto saveProduct(ProdutoDTO dto) {
            Produto produto = converterParaEntidade(dto);
            return repository.save(produto);
        }

        public void deleteProduct(Long id) {
            repository.deleteById(id);
        }

        public void deleteProductByName(String nome) {
            Produto produto = repository.findByNome(nome)
                    .orElseThrow(() -> new ResourceNotFoundException("Produto com nome '" + nome + "' não encontrado."));
            repository.delete(produto);
        }

        public Produto atualizarQuantidadeEstoque(Long id, Integer novaQuantidade) {
            Produto produto = getProductById(id);
            produto.setQuantidadeEstoque(novaQuantidade);
            return repository.save(produto);
        }

        public List<ProdutoDTO> buscarPorDataCadastro(Instant inicio, Instant fim) {
            return converteDados(repository.findByDataCadastroBetween(inicio, fim));
        }



}
