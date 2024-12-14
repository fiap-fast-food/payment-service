package com.guilherme.fiapfood.infrastructure.exceptions;

public class MercadoPagoException extends RuntimeException {
    public MercadoPagoException(String message) {
        super(message);
    }
}
