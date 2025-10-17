package com.betthor.betthorapi.model;

import com.betthor.betthorapi.enums.ResultadoEvento;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "evento_x1")
public class EventoX1 extends BaseEntity {

    @Column(nullable = false)
    private String nomeParticipante1;

    @Column(nullable = false)
    private String nomeParticipante2;

    @Column(nullable = false)
    private LocalDateTime dataHoraInicio;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ResultadoEvento status = ResultadoEvento.PENDENTE;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal oddParticipante1;

    @Column(nullable = false, precision = 10, scale = 2)
    private  BigDecimal oddParticipante2;

    private String resultadoVencedor;

    public EventoX1(String nomeParticipante1, String nomeParticipante2, LocalDateTime dataHoraInicio, ResultadoEvento status, BigDecimal oddParticipante1, BigDecimal oddParticipante2, String resultadoVencedor) {
        this.nomeParticipante1 = nomeParticipante1;
        this.nomeParticipante2 = nomeParticipante2;
        this.dataHoraInicio = dataHoraInicio;
        this.status = status;
        this.oddParticipante1 = oddParticipante1;
        this.oddParticipante2 = oddParticipante2;
        this.resultadoVencedor = resultadoVencedor;
    }

    public String getNomeParticipante1() {
        return nomeParticipante1;
    }

    public void setNomeParticipante1(String nomeParticipante1) {
        this.nomeParticipante1 = nomeParticipante1;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public ResultadoEvento getStatus() {
        return status;
    }

    public void setStatus(ResultadoEvento status) {
        this.status = status;
    }

    public BigDecimal getOddParticipante1() {
        return oddParticipante1;
    }

    public void setOddParticipante1(BigDecimal oddParticipante1) {
        this.oddParticipante1 = oddParticipante1;
    }

    public BigDecimal getOddParticipante2() {
        return oddParticipante2;
    }

    public void setOddParticipante2(BigDecimal oddParticipante2) {
        this.oddParticipante2 = oddParticipante2;
    }

    public String getResultadoVencedor() {
        return resultadoVencedor;
    }

    public void setResultadoVencedor(String resultadoVencedor) {
        this.resultadoVencedor = resultadoVencedor;
    }

    public String getNomeParticipante2() {
        return nomeParticipante2;
    }

    public void setNomeParticipante2(String nomeParticipante2) {
        this.nomeParticipante2 = nomeParticipante2;
    }
}
