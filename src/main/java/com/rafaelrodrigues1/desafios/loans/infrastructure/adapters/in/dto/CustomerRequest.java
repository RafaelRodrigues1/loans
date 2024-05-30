package com.rafaelrodrigues1.desafios.loans.infrastructure.adapters.in.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.math.BigDecimal;

public record CustomerRequest(
        @JsonAlias("cpf") String cpf,
        @JsonAlias("name") String name,
        @JsonAlias("age") Integer age,
        @JsonAlias("location") String location,
        @JsonAlias("income") BigDecimal income
) {
}
