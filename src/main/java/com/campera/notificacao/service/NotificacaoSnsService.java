package com.campera.notificacao.service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificacaoSnsService {

    private AmazonSNS amazonSNS;

    public void notificar(String telefone, String mensagem) {
        PublishRequest publishRequest = new PublishRequest()
                .withMessage(mensagem)
                .withPhoneNumber(telefone);
        amazonSNS.publish(publishRequest);
    }
}
