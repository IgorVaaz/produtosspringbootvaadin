package br.muffato.produtos.data.integracaosap.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor

public class ProdutoId implements Serializable {
    private String matnr;
    private String meins;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProdutoId produtoId = (ProdutoId) o;

        if (!Objects.equals(matnr, produtoId.matnr)) return false;
        return Objects.equals(meins, produtoId.meins);
    }

    @Override
    public int hashCode() {
        int result = matnr != null ? matnr.hashCode() : 0;
        result = 31 * result + (meins != null ? meins.hashCode() : 0);
        return result;
    }
}
