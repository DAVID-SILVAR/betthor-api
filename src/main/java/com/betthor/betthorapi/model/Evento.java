package com.betthor.betthorapi.model;

import com.betthor.betthorapi.enums.ResultadoEvento;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "eventos")
public class Evento extends BaseEntity {

    @Column(nullable = false)
    private String descricao;

    @Column(name = "data_evento", nullable = false)
    private LocalDateTime dataEvento;

    @Column(name = "competidor1", nullable = false)
    private String competidor1;

    @Column(name = "competidor2", nullable = false)
    private String competidor2;

    @Column(name = "odd_competidor1", precision = 5, scale = 2)
    private BigDecimal oddCompetidor1;

    @Column(name = "odd_competidor2", precision = 5, scale = 2)
    private BigDecimal oddCompetidor2;

    @Enumerated(EnumType.STRING)
    private ResultadoEvento resultado = ResultadoEvento.PENDENTE;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDateTime dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getCompetidor1() {
        return competidor1;
    }

    public void setCompetidor1(String competidor1) {
        this.competidor1 = competidor1;
    }

    public String getCompetidor2() {
        return competidor2;
    }

    public void setCompetidor2(String competidor2) {
        this.competidor2 = competidor2;
    }

    public BigDecimal getOddCompetidor1() {
        return oddCompetidor1;
    }

    public void setOddCompetidor1(BigDecimal oddCompetidor1) {
        this.oddCompetidor1 = oddCompetidor1;
    }

    public BigDecimal getOddCompetidor2() {
        return oddCompetidor2;
    }

    public void setOddCompetidor2(BigDecimal oddCompetidor2) {
        this.oddCompetidor2 = oddCompetidor2;
    }

    public ResultadoEvento getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoEvento resultado) {
        this.resultado = resultado;
    }
}
