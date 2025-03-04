package com.campera.notificacao.service;

import org.springframework.stereotype.Service;

@Service
public class NotificacaoSnsService {
    public void notificar(String mensagem) {
        System.out.println(mensagem);
    }
}
