package com.guilherme.fiapfood.utils;

import com.guilherme.fiapfood.api.dto.order.CustomerDTO;
import com.guilherme.fiapfood.api.dto.order.OrderDTO;
import com.guilherme.fiapfood.api.dto.order.ProductDTO;
import com.guilherme.fiapfood.api.response.PaymentResponseDTO;
import com.guilherme.fiapfood.infrastructure.entity.PaymentEntity;
import com.mercadopago.client.preference.PreferenceItemRequest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PaymentHelper {

    public static PaymentEntity gerarPaymentEntity() {
        return PaymentEntity.builder()
                .orderId(1L)
                .collectorId(1L)
                .initPoint("teste")
                .clientId("clientId")
                .dateCreated(LocalDateTime.now())
                .productIds(List.of("productId", "productId"))
                .build();
    }

    public static OrderDTO gerarOrderDTO() {
        return OrderDTO.builder()
                .products(List.of(gerarProductDTO()))
                .idOrder(1L)
                .customer(gerarCustomerDTO())
                .build();
    }

    public static ProductDTO gerarProductDTO() {
        return ProductDTO.builder()
                .productName("Hamburguer")
                .productPrice(new BigDecimal("12.0"))
                .productDescription("Information")
                .categoryProduct("category")
                .quantityProduct(1)
                .build();
    }

    public static CustomerDTO gerarCustomerDTO() {
        return CustomerDTO.builder()
                .cpf("1234567809")
                .email("teste@mail.com")
                .name("teste")
                .build();
    }

    public static PaymentResponseDTO gerarPaymentResponse() {
        return PaymentResponseDTO.builder()
                .items(List.of(PreferenceItemRequest.builder().build()))
                .initPoint("teste")
                .build();
    }
}
