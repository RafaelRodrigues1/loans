package com.rafaelrodrigues1.desafios.loans.domain.models;

import java.math.BigDecimal;

public record Customer (
        String cpf,
        String name,
        Integer age,
        String location,
        BigDecimal income
) {}

