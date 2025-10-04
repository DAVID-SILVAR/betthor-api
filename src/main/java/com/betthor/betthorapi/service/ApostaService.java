package com.betthor.betthorapi.service;

import com.betthor.betthorapi.model.Aposta;
import com.betthor.betthorapi.model.MovimentacaoFinanceira;
import com.betthor.betthorapi.model.Usuario;
import com.betthor.betthorapi.repository.ApostaRepository;
import com.betthor.betthorapi.repository.MovimentacaoRepository;
import com.betthor.betthorapi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class ApostaService {

    private final ApostaRepository apostaRepository;
    private final UsuarioRepository usuarioRepository;
    private final MovimentacaoRepository movimentacaoRepository;

    public ApostaService(
            ApostaRepository apostaRepository,
            UsuarioRepository usuarioRepository,
            MovimentacaoRepository movimentacaoRepository
    ) {
        this.apostaRepository = apostaRepository;
        this.usuarioRepository = usuarioRepository;
        this.movimentacaoRepository = movimentacaoRepository;
    }

    public Aposta criarAposta(Long usuaridId, Aposta aposta) {
        Usuario usuario = usuarioRepository.findById(usuaridId)
                .orElseThrow(() ->new RuntimeException("Usuário não encontrado"));

        if (usuario.getSaldo() < aposta.getValor()) {
            throw  new RuntimeException("Saldo insuficiente");
        }

        double saldoAntes = usuario.getSaldo();
        usuario.setSaldo(saldoAntes - aposta.getValor());
        usuarioRepository.save(usuario);

        aposta.setUsuario(usuario);
        Aposta newAposta = apostaRepository.save(aposta);

        MovimentacaoFinanceira movimentacao = new MovimentacaoFinanceira();
        movimentacao.setUsuario(usuario);
        movimentacao.setTipo("APOSTA");
        movimentacao.setValor(aposta.getValor());
        movimentacao.setSaldoAntes(saldoAntes);
        movimentacao.setSaldoDepois(usuario.getSaldo());
        movimentacaoRepository.save(movimentacao);

        return  newAposta;
    }


    public Iterable<Aposta> listarApostasUsuario(Long usuarioId) {
        return apostaRepository.findByUsuarioId(usuarioId);
    }
}
