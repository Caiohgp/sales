package br.com.caiohenriquedev.sales.Request;

import br.com.caiohenriquedev.sales.domain.PaymentMethodEnum;
import br.com.caiohenriquedev.sales.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PostSaleRequest {
    private Product product;
    private PaymentMethodEnum paymentMethod;
}
