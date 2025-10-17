package com.betthor.betthorapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimentacoes_financeiras")
public class MovimentacaoFinanceira extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private Double saldoAntes;

    @Column(nullable = false)
    private Double saldoDepois;

    @Column(nullable = false)
    private String tipo; // DEPOSITO, SAQUE, APOSTA, GANHO

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getSaldoAntes() {
        return saldoAntes;
    }

    public void setSaldoAntes(Double saldoAntes) {
        this.saldoAntes = saldoAntes;
    }

    public Double getSaldoDepois() {
        return saldoDepois;
    }

    public void setSaldoDepois(Double saldoDepois) {
        this.saldoDepois = saldoDepois;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
