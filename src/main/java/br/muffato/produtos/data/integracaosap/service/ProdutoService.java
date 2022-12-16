package br.muffato.produtos.data.integracaosap.service;

import br.muffato.produtos.data.integracaosap.repository.ProdutoRepository;
import br.muffato.produtos.data.integracaosap.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService{

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }


}
