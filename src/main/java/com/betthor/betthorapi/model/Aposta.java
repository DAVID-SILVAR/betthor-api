package com.betthor.betthorapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "apostas")
public class Aposta extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = true)
    private Double odd;

    @Column(nullable = true)
    private String evento; // Ex: "Flamengo x Palmeiras"

    @Column(nullable = false)
    private String status = "PENDENTE"; // PENDENTE, GANHOU, PERDEU

    @Column(nullable = false, unique = true, updatable = false, length = 15)
    private String codigo; // Exemplo: "A7D8E-72AB8C"

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

    public Double getOdd() {
        return odd;
    }

    public void setOdd(Double odd) {
        this.odd = odd;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @PrePersist
    public void gerarCodigo() {
        if (this.codigo == null) {
            this.codigo = gerarCodigoAleatorio();
        }
    }

    private String gerarCodigoAleatorio() {
        String parte1 = java.util.UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 5)
                .toUpperCase();

        String parte2 = java.util.UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 6)
                .toUpperCase();

        return parte1 + "-" + parte2;
    }
}
