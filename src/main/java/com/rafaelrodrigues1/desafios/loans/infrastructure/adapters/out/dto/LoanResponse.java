package com.rafaelrodrigues1.desafios.loans.infrastructure.adapters.out.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public record LoanResponse (
        @JsonAlias("type") String type,
        @JsonAlias("interest_rate") Double interestRate
) {}
