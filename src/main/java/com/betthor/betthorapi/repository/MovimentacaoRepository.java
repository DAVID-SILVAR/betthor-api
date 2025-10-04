package com.betthor.betthorapi.repository;

import com.betthor.betthorapi.model.MovimentacaoFinanceira;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MovimentacaoRepository extends JpaRepository<MovimentacaoFinanceira, Long> {
    List<MovimentacaoFinanceira> findByUsuarioId(Long usuarioId);
}
