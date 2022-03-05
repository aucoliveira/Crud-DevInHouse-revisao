package com.crud.revisao.controller.rest;

import com.crud.revisao.controller.dto.NovoProdutoDto;
import com.crud.revisao.model.Produto;
import com.crud.revisao.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

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
        return (List<Produto>) service.listaProdutos();
    }

    @PostMapping
    public Produto adicionarProduto(@RequestBody NovoProdutoDto produtoDto) {
        return service.adicionaProduto(produtoDto.converter());
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable("id") long id, @RequestBody NovoProdutoDto produtoDto) {
        return service.atualizaProduto(id, produtoDto.converter());
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable("id") Long id) {
        service.deletaProduto(id);
    }

}
