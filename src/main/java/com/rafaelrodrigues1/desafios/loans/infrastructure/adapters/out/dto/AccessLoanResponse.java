package com.rafaelrodrigues1.desafios.loans.infrastructure.adapters.out.dto;


import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.Set;

public record AccessLoanResponse (
        @JsonAlias("customer") String customerName,
        @JsonAlias("loans") Set<LoanResponse> loans
){}
