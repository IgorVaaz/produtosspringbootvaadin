package br.muffato.produtos.data.integracaosap.views;

import br.muffato.produtos.data.integracaosap.model.Produto;
import br.muffato.produtos.data.integracaosap.service.ProdutoService;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import java.util.Arrays;
import java.util.List;
@PageTitle("Produtos")
@Route(value = "produtos", layout = Principal.class)
@RouteAlias(value = "produtos", layout = Principal.class)
@AnonymousAllowed
public class ProdutosView extends VerticalLayout {

    private ProdutoService produtoService;
    private final Grid<Produto> produtoGrid = new Grid<>(Produto.class, false);

    private TextField ean11;

    public ProdutosView(ProdutoService produtoService){
        this.produtoService = produtoService;

        SplitLayout splitLayout = new SplitLayout();

        //createGridLayout(splitLayout);
        //createEditorLayout(splitLayout);



        produtoGrid.addColumn("ean11").setAutoWidth(true);
//        produtoGrid.addColumn("")

        produtoGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        //produtoGrid.setHeightFull();

        produtoGrid.setItems(produtoService.findAll());

        add(produtoGrid);
    }

//    private void createGridLayout(SplitLayout splitLayout) {
//        Div wrapper = new Div();
//        wrapper.setClassName("grid-wrapper");
//        wrapper.add(produtoGrid);
//        splitLayout.addToPrimary(wrapper);
//    }
//
//    private void createEditorLayout(SplitLayout splitLayout) {
//        Div editorLayoutDiv = new Div();
//        editorLayoutDiv.setClassName("editor-layout");
//
//        Div editorDiv = new Div();
//        editorDiv.setClassName("editor");
//        editorLayoutDiv.add(editorDiv);
//
//        FormLayout formLayout = new FormLayout();
//        ean11 = new TextField("ean11");
//        ean11.setWidthFull();
//
//        splitLayout.addToSecondary(editorLayoutDiv);
//    }
}
