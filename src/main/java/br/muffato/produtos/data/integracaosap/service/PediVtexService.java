package br.muffato.produtos.data.integracaosap.service;

import br.muffato.produtos.data.integracaosap.model.PediVtex;
import br.muffato.produtos.data.integracaosap.repository.PediVtexRepository;
import com.vaadin.flow.component.combobox.ComboBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class PediVtexService {
    @Autowired
    private PediVtexRepository pediVtexRepository;

    @Autowired
    JdbcTemplate jdbcTemplateDelivery;

    public List<PediVtex> findAll(){
        return pediVtexRepository.findAll();
    }

    public List<PediVtex> retornarListaPedidoNaoSeparado(LocalDate data, String filial, ComboBox comboBox, LocalDate dataInicial, LocalDate dataFinal) {

        System.out.println(comboBox.getValue());
        List<PediVtex> lista = new ArrayList<PediVtex>();
        String select;
        SqlRowSet sqlListaPedido = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String dataFormatada = "";
        String dataInicialFormatada = "";
        String dataFinalFormatada = "";

                if(dataInicial != null){
                    dataInicialFormatada = dataInicial.format(formatter);
                }
                if(dataFinal != null){
                    dataFinalFormatada = dataFinal.format(formatter);
                }
                if(data != null){
                    dataFormatada = data.format(formatter);
                }

        if(filial.isEmpty() && dataInicialFormatada == "" && dataFinalFormatada == "" && comboBox.getValue() == "Nao separado"){
            select = "SELECT * FROM DELIVERY2.PEDIVTEX dp WHERE dp.APPXSEPA = 0 AND TRUNC(dp.DATAFATU) = TO_DATE(?,'yyyy-MM-dd')";
            sqlListaPedido = jdbcTemplateDelivery.queryForRowSet(select, dataFormatada);
        } else if (dataInicialFormatada == "" && dataFinalFormatada == "" && comboBox.getValue() == "Nao separado") {
            select = "SELECT * FROM DELIVERY2.PEDIVTEX dp WHERE dp.APPXSEPA = 0 AND TRUNC(dp.DATAFATU) = TO_DATE(?,'yyyy-MM-dd') AND dp.FILI=?";
            sqlListaPedido = jdbcTemplateDelivery.queryForRowSet(select, dataFormatada, filial);
        } else if (dataFormatada == "" && filial.isEmpty() && comboBox.getValue() == "Nao separado") {
            select = "SELECT * FROM DELIVERY2.PEDIVTEX dp WHERE dp.APPXSEPA = 0 AND TRUNC(dp.DATAFATU) BETWEEN TO_DATE(?, 'yyyy-MM-dd') AND TO_DATE(?, 'yyyy-MM-dd')";
            sqlListaPedido = jdbcTemplateDelivery.queryForRowSet(select, dataInicialFormatada, dataFinalFormatada);
        } else if (dataFormatada == "" && comboBox.getValue() == "Nao separado")  {
            select = "SELECT * FROM DELIVERY2.PEDIVTEX dp WHERE dp.APPXSEPA = 0 AND TRUNC(dp.DATAFATU) BETWEEN TO_DATE(?, 'yyyy-MM-dd') AND TO_DATE(?, 'yyyy-MM-dd') AND dp.FILI = ?";
            sqlListaPedido = jdbcTemplateDelivery.queryForRowSet(select, dataInicialFormatada, dataFinalFormatada, filial);
        } else if(filial.isEmpty() && dataInicialFormatada == "" && dataFinalFormatada == "" && comboBox.getValue() == "Separado"){
            select = "SELECT * FROM DELIVERY2.PEDIVTEX dp WHERE dp.APPXSEPA = 1 AND TRUNC(dp.DATAFATU) = TO_DATE(?, 'YYYY-MM-DD')";
            sqlListaPedido = jdbcTemplateDelivery.queryForRowSet(select, dataFormatada);
        }else if (dataInicialFormatada == "" && dataFinalFormatada == "" && comboBox.getValue() == "Separado") {
            select = "SELECT * FROM DELIVERY2.PEDIVTEX dp WHERE dp.APPXSEPA = 1 AND TRUNC(dp.DATAFATU) = TO_DATE(?,'yyyy-MM-dd') AND dp.FILI=?";
            sqlListaPedido = jdbcTemplateDelivery.queryForRowSet(select, dataFormatada, filial);
        } else if (dataFormatada == "" && filial.isEmpty() && comboBox.getValue() == "Separado") {
            select = "SELECT * FROM DELIVERY2.PEDIVTEX dp WHERE dp.APPXSEPA = 1 AND TRUNC(dp.DATAFATU) BETWEEN TO_DATE(?, 'yyyy-MM-dd') AND TO_DATE(?, 'yyyy-MM-dd')";
            sqlListaPedido = jdbcTemplateDelivery.queryForRowSet(select, dataInicialFormatada, dataFinalFormatada);
        } else if (dataFormatada == "" && comboBox.getValue() == "Separado")  {
            select = "SELECT * FROM DELIVERY2.PEDIVTEX dp WHERE dp.APPXSEPA = 1 AND TRUNC(dp.DATAFATU) BETWEEN TO_DATE(?, 'yyyy-MM-dd') AND TO_DATE(?, 'yyyy-MM-dd') AND dp.FILI = ?";
            sqlListaPedido = jdbcTemplateDelivery.queryForRowSet(select, dataInicialFormatada, dataFinalFormatada, filial);
        }

        while (sqlListaPedido.next()){
            PediVtex pedido = new PediVtex();

            pedido.setAppxsepa(sqlListaPedido.getInt("APPXSEPA"));
            pedido.setFili(sqlListaPedido.getInt("FILI"));
            pedido.setOrdeIdxx(sqlListaPedido.getString("ORDEIDXX"));
            pedido.setDataFatu(sqlListaPedido.getDate("DATAFATU"));
            lista.add(pedido);
        }
        return lista;
    }
}
