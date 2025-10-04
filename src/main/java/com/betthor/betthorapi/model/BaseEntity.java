package com.betthor.betthorapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_registro", nullable = false, updatable = false)
    private LocalDateTime dataRegistro;

    @Column(name = "data_modificacao", nullable = false)
    private LocalDateTime dataModificacao;

    @PrePersist
    protected void onCreate() {
        this.dataRegistro = LocalDateTime.now();
        this.dataModificacao = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.dataModificacao = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }


}
