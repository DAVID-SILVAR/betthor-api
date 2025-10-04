package com.betthor.betthorapi.controller;

import com.betthor.betthorapi.model.Aposta;
import com.betthor.betthorapi.service.ApostaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apostas")
public class ApostaController {
    private final ApostaService apostaService;

    public ApostaController(ApostaService apostaService) {
        this.apostaService = apostaService;
    }
//
//    public Aposta criarAposta(@RequestParam Long usuarioId, @RequestParam) {
//
//    }


}
