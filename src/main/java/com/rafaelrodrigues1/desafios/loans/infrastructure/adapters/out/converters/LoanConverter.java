package com.rafaelrodrigues1.desafios.loans.infrastructure.adapters.out.converters;

import com.rafaelrodrigues1.desafios.loans.domain.models.Customer;
import com.rafaelrodrigues1.desafios.loans.domain.models.Loan;
import com.rafaelrodrigues1.desafios.loans.infrastructure.adapters.out.dto.AccessLoanResponse;
import com.rafaelrodrigues1.desafios.loans.infrastructure.adapters.out.dto.LoanResponse;

import java.util.Set;
import java.util.stream.Collectors;

public class LoanConverter {

    public static AccessLoanResponse toDto(Set<Loan> loans, Customer customer) {
        Set<LoanResponse> loanResponses = loans.stream()
                .map(loan -> new LoanResponse(loan.type().name(), loan.interestRate()))
                .collect(Collectors.toSet());
        return new AccessLoanResponse(customer.name(), loanResponses);
    }
}
