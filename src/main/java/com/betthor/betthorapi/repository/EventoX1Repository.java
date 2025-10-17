package com.betthor.betthorapi.repository;

import com.betthor.betthorapi.enums.ResultadoEvento;
import com.betthor.betthorapi.model.EventoX1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventoX1Repository extends JpaRepository<EventoX1, Long> {

    Optional<EventoX1> findByStatus(ResultadoEvento status);

}
