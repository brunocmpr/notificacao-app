package com.campera.notificacao.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Proposta {

    private Long id;

    private Double valorSolicitado;

    private Integer prazoPagamento;

    private Boolean aprovada;

    private boolean integrada;

    private String observacao;

    private Usuario usuario;
}