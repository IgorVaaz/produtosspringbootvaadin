package br.muffato.produtos.data.integracaosap.repository;

import br.muffato.produtos.data.integracaosap.model.PediVtex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PediVtexRepository extends JpaRepository<PediVtex, String> {
}
