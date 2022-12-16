package br.muffato.produtos.data.integracaosap.repository;

import br.muffato.produtos.data.integracaosap.model.Produto;
import br.muffato.produtos.data.integracaosap.model.ProdutoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, ProdutoId> {
}
