package br.muffato.produtos.data.integracaosap.model;

import java.util.Date;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PEDIVTEX")
public class PediVtex {

    @Id
    @Column(name = "ORDEIDXX")
    private String ordeIdxx;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "PEDIVENDPDVX")
    private Integer pediVendPdvx;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "SEQU")
    private String sequ;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "SELLORDEIDXX")
    private String sellOrdeidxx;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "SALECHAN")
    private String saleChan;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "VLRX")
    private Double vlrx;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "CREADATE")
    private Date creaDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "LASTCHANG")
    private Date lastChang;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "ORDEGROU")
    private String ordeGrou;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "STAT")
    private Integer stat;

    @Column(name = "FILI")
    private Integer fili;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "DATACANC")
    private Date dataCanc;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "OBSX")
    private String obsx;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "USERCANC")
    private String userCanc;

    @Column(name = "DATAFATU")
    private Date dataFatu;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "USERFATU")
    private String userFatu;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "STATVISU")
    private Integer statVisu;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "EXPR")
    private Integer expr;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "INIXAPPXSEPA")
    private Double inixappxsepa;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "CHAVPEDIVTEX")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PEDIVTEX")
    @SequenceGenerator(name = "SEQ_PEDIVTEX", initialValue = 1, sequenceName = "SEQ_PEDIVTEX", allocationSize = 1)
    private Long chavPediVtex;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "DATAHORAINTG")
    private Date dataHoraIntg;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "PROCSTAT")
    private Integer procStat;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "CHANGEVTEX")
    private Integer changeVtex;

    @Column(name = "APPXSEPA")
    private Integer appxsepa;

}
