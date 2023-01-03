package br.muffato.produtos.data.integracaosap.views;

import br.muffato.produtos.data.integracaosap.model.PediVtex;
import br.muffato.produtos.data.integracaosap.service.PediVtexService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@PageTitle("Pedivtex")
@Route(value = "pedivtex", layout = Principal.class)
@RouteAlias(value = "pedivtex", layout = Principal.class)
@AnonymousAllowed
public class PediVtexView extends VerticalLayout {
    DatePicker datePicker = new DatePicker("Selecione a data: ");
    DatePicker dataInicial = new DatePicker("Data Inicial:");
    DatePicker dataFinal = new DatePicker("Data Final:");
    TextField textField = new TextField("Informe a Loja:");
    Button button = new Button("Pesquisar");
    ComboBox comboBox = new ComboBox("Tipo");
    HorizontalLayout horizontalLayout = new HorizontalLayout();
    HorizontalLayout horizontalLayout2 = new HorizontalLayout();
    private PediVtexService pediVtexService;

    private final Grid<PediVtex> pediVtexGrid = new Grid<>(PediVtex.class, false);
    public PediVtexView(PediVtexService pediVtexService){
        horizontalLayout.add(datePicker, textField, dataInicial, dataFinal, comboBox);
        horizontalLayout2.add(button);


        comboBox.setItems("Nao separado", "Separado");

        //add(datePicker, textField, dataInicial, dataFinal, comboBox, button);
        add(horizontalLayout, horizontalLayout2);
        pediVtexGrid.addColumn("ordeIdxx").setAutoWidth(true);
        pediVtexGrid.addColumn("fili").setAutoWidth(true);
        pediVtexGrid.addColumn("dataFatu").setAutoWidth(true);
        pediVtexGrid.addColumn("appxsepa").setAutoWidth(true);

        pediVtexGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        button.setAutofocus(true);
        datePicker.addValueChangeListener(e -> {
           if(!datePicker.isEmpty()){
               button.setEnabled(true);
           }
        });
        this.pediVtexService = pediVtexService;
        button.addClickListener(clickEvent -> this.botaoPesquisar(datePicker, textField, comboBox, dataInicial, dataFinal));
    }
    public void botaoPesquisar(DatePicker datePicker, TextField textField, ComboBox comboBox, DatePicker dataInicial, DatePicker dataFinal)
    {
            pediVtexGrid.setItems(pediVtexService.retornarListaPedidoNaoSeparado(datePicker.getValue(),
                    textField.getValue(), comboBox, dataInicial.getValue(), dataFinal.getValue()));
            add(pediVtexGrid);
    }



}
