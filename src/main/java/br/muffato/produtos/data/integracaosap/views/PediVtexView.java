package br.muffato.produtos.data.integracaosap.views;

import br.muffato.produtos.data.integracaosap.model.PediVtex;
import br.muffato.produtos.data.integracaosap.service.PediVtexService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import java.time.LocalDate;
import java.util.Date;

@PageTitle("Pedivtex")
@Route(value = "pedivtex", layout = Principal.class)
@RouteAlias(value = "pedivtex", layout = Principal.class)
@AnonymousAllowed
public class PediVtexView extends VerticalLayout {

    private PediVtexService pediVtexService;

    private final Grid<PediVtex> pediVtexGrid = new Grid<>(PediVtex.class, false);

    public PediVtexView(PediVtexService pediVtexService){
        this.pediVtexService = pediVtexService;

        SplitLayout splitLayout = new SplitLayout();

        pediVtexGrid.addColumn("ordeIdxx").setAutoWidth(true);
        pediVtexGrid.addColumn("fili").setAutoWidth(true);
        pediVtexGrid.addColumn("dataFatu").setAutoWidth(true);
        pediVtexGrid.addColumn("appxsepa").setAutoWidth(true);

        pediVtexGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);

        LocalDate data = LocalDate.of(2020,06,30);
        pediVtexGrid.setItems(pediVtexService.retornarListaPedidoNaoSeparado(data));

        add(pediVtexGrid);
    }

}
