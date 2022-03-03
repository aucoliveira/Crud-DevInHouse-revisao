package com.crud.revisao.controller;

import com.crud.revisao.model.Produto;
import com.crud.revisao.service.ProdutoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller serve para MVC quando vc tem tela
 * RestController retorna XML OU JSON para uma api
 */
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public String produto() {
        return "Produto";
    }

    @GetMapping("/todos")
    public List<Produto> listarProduto() {
        return (List<Produto>) service.ListarProdutos();
    }

    @PostMapping
    public Produto adicionarProduto(Produto produto) {
        return service.adicionaProduto(produto);
    }

}
