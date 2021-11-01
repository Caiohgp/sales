package br.com.caiohenriquedev.sales.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PaymentMethodEnum {
    BOLETO(1,"Boleto"),
    CARTAO_DE_CREDITO(2,"Cartão de Crédito"),
    PIX(3,"PIX");

    private int id;
    private String namePaymentMethod;

}
