package com.betthor.betthorapi.service;

import com.betthor.betthorapi.model.Usuario;
import com.betthor.betthorapi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario criarUsuario(Usuario usuario) {
        usuario.setSaldo(0.0);
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarSaldo(Usuario usuario, Double valor) {
        usuario.setSaldo(usuario.getSaldo() + valor);
        return usuarioRepository.save(usuario);
    }
}
