package com.betthor.betthorapi.controller;

import com.betthor.betthorapi.model.Usuario;
import com.betthor.betthorapi.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listarTodos();
    }

    @PostMapping("/{id}")
    public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
        return usuarioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/cadastro")
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return usuarioService.criarUsuario(usuario);
    }

    @PostMapping("/{id}/deposito")
    public Usuario depositar(@PathVariable Long id, @RequestParam Double valor) {
        Usuario usuario = usuarioService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return usuarioService.atualizarSaldo(usuario, valor);
    }
}
