package com.campera.notificacao.listener;

import com.campera.notificacao.constante.MensagemConstante;
import com.campera.notificacao.domain.Proposta;
import com.campera.notificacao.service.NotificacaoSnsService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PropostaPendenteListener {

    private NotificacaoSnsService notificacaoSnsService;

    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}")
    public void propostaPendente(Proposta proposta) {
        String mensagem = String.format(MensagemConstante.PROPOSTA_EM_ANALISE, proposta.getUsuario().getNome());
        notificacaoSnsService.notificar(proposta.getUsuario().getTelefone(), mensagem);
    }

    @RabbitListener(queues = "${rabbitmq.queue.proposta.concluida}")
    public void propostaConcluida(Proposta proposta) {
        String mensagem = buildMensagemConcluida(proposta);
        notificacaoSnsService.notificar(proposta.getUsuario().getTelefone(), mensagem);
    }

    private String buildMensagemConcluida(Proposta proposta) {
        if(proposta.getAprovada()){
            return String.format(MensagemConstante.PROPOSTA_APROVADA, proposta.getUsuario().getNome());
        }
        return String.format(MensagemConstante.PROPOSTA_NEGADA
                , proposta.getUsuario().getNome()
                , proposta.getObservacao());
    }
}
