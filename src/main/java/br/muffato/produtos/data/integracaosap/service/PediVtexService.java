package br.muffato.produtos.data.integracaosap.service;

import br.muffato.produtos.data.integracaosap.model.PediVtex;
import br.muffato.produtos.data.integracaosap.repository.PediVtexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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

    public List<PediVtex> retornarListaPedidoNaoSeparado(LocalDate data) {

        List<PediVtex> lista = new ArrayList<PediVtex>();
        List<Object> params = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String dataFormatada = data.format(formatter);

        params.add(dataFormatada);

        String select = "SELECT * FROM DELIVERY2.PEDIVTEX dp WHERE dp.APPXSEPA = 0 AND dp.DATAFATU = TO_DATE(?,'yyyy-MM-dd')";
        SqlRowSet sqlListaPedido = jdbcTemplateDelivery.queryForRowSet(select, params.toArray());

        while (sqlListaPedido.next()){
            PediVtex pedido = new PediVtex();

            pedido.setAppxsepa(sqlListaPedido.getInt("APPXSEPA"));
            pedido.setFili(sqlListaPedido.getInt("FILI"));
            pedido.setOrdeIdxx(sqlListaPedido.getString("ORDEIDXX"));
            pedido.setDataFatu(sqlListaPedido.getDate("DATAFATU"));
            lista.add(pedido);
        }
        //params.remove(limit);
        return lista;
    }
}
