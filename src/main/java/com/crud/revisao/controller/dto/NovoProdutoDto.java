package com.crud.revisao.controller.dto;


import com.crud.revisao.model.Produto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

/**
 * Dto cria a separação entre as camadas;
 * pode adicionar filtros
 */
@Setter
@Getter
public class NovoProdutoDto {

    @NotBlank
    private String nome;
    @NotBlank
    private String valor;
    @NotBlank
    private String descricao;

    public Produto converter() {
        Produto produto = new Produto();
        produto.setDescricao(descricao);
        produto.setNome(nome);
        produto.setValor((Double.valueOf(valor)));
        produto.setData(LocalDate.now());

        return produto;
    }
}
