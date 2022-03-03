package com.crud.revisao.service;

import com.crud.revisao.model.Produto;
import com.crud.revisao.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;
    public ProdutoService(ProdutoRepository repository){
        this.repository = repository;
    }

    public Iterable<Produto> ListarProdutos() {
        return repository.findAll();
    }

    public Produto adicionaProduto(Produto produto){
        produto.setId(null);

        return repository.save(produto);
    }
}
