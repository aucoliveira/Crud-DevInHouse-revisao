package com.crud.revisao.controller.mvc;

import com.crud.revisao.controller.dto.NovoProdutoDto;
import com.crud.revisao.model.Produto;


import com.crud.revisao.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProdutoControllerMvc {

    private final ProdutoService service;

    public ProdutoControllerMvc(ProdutoService service){
        this.service = service;
    }


    @GetMapping("/produtomvc")
    public String helloMvc(){
        return "hello";
    }

    @GetMapping("/lista")
    public String listarProdutos(Model model){
        List<Produto> produtos = service.listaProdutos();
        model.addAttribute("produtos",produtos);
        return "produto/lista";
    }

    @GetMapping("/formulario")
    public String formularioProduto(NovoProdutoDto novoProdutoDto){
        return "produto/formulario";
    }

    @PostMapping("/novo")
    public String adicionarProduto(@Valid NovoProdutoDto novoProdutoDto,
                                   BindingResult result)
    {
        if (result.hasErrors())
            return "produto/formulario";
        service.adicionaProduto(novoProdutoDto.converter());
        return "redirect:/lista";
    }

}
