package br.muffato.produtos.data.integracaosap.views;

import br.muffato.produtos.data.integracaosap.model.Produto;
import br.muffato.produtos.data.integracaosap.service.ProdutoService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@PageTitle("Produtos")
@Route(value = "produtos", layout = Principal.class)
@RouteAlias(value = "produtos", layout = Principal.class)
@AnonymousAllowed
public class ProdutosView extends VerticalLayout {

    private ProdutoService produtoService;
    private final Grid<Produto> produtoGrid = new Grid<>(Produto.class, false);

    public ProdutosView(ProdutoService produtoService){
        this.produtoService = produtoService;

        SplitLayout splitLayout = new SplitLayout();

        produtoGrid.addColumn("matnr").setAutoWidth(true);
        produtoGrid.addColumn("bismt").setAutoWidth(true);
        produtoGrid.addColumn("ean11").setAutoWidth(true);
        produtoGrid.addColumn("meins").setAutoWidth(true);
        produtoGrid.addColumn("maktx").setAutoWidth(true);
        produtoGrid.addColumn("descmarc").setAutoWidth(true);
        produtoGrid.addColumn("node").setAutoWidth(true);
        produtoGrid.addColumn("imob").setAutoWidth(true);
        produtoGrid.addColumn("umrez").setAutoWidth(true);

        produtoGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);

        produtoGrid.setItems(produtoService.findAll());

        add(produtoGrid);
    }
}
