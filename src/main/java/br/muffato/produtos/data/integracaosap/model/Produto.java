package br.muffato.produtos.data.integracaosap.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "PROD")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(ProdutoId.class)
@Builder

public class Produto {
    @Column(name = "MATNR")
    @Id
    private String matnr;
    @Column(name = "MEINS")
    @Id
    private String meins;
    @Column(name = "BISMT")
    private String bismt;
    @Column(name = "EAN11")
    private String ean11;
    @Column(name = "MAKTX")
    private String maktx;
    @Column(name = "DESCMARC")
    private String descmarc;
    @Column(name = "NODE")
    private String node;
    @Column(name = "IMOB")
    private String imob;
    @Column(name = "UMREZ")
    private String umrez;

}







