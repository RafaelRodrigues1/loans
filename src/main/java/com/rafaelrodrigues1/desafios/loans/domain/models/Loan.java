package com.rafaelrodrigues1.desafios.loans.domain.models;

import com.rafaelrodrigues1.desafios.loans.domain.enums.LoanType;

public record Loan (
        LoanType type,
        Double interestRate
){}
