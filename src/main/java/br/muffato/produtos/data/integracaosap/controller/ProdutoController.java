package br.muffato.produtos.data.integracaosap.controller;

import br.muffato.produtos.data.integracaosap.service.ProdutoService;
import br.muffato.produtos.data.integracaosap.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("produtos")
@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    @RequestMapping(method = RequestMethod.GET)
    public List<Produto> getProduto(){
        return produtoService.findAll();
    }

}
