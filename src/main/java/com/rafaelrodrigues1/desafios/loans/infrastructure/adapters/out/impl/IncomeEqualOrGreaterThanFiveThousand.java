package com.rafaelrodrigues1.desafios.loans.infrastructure.adapters.out.impl;

import com.rafaelrodrigues1.desafios.loans.domain.models.Customer;
import com.rafaelrodrigues1.desafios.loans.infrastructure.adapters.out.interfaces.LoanAccessChecker;

import java.math.BigDecimal;

public class IncomeEqualOrGreaterThanFiveThousand implements LoanAccessChecker {

    @Override
    public Boolean check(Customer customer) {
        return customer.income().compareTo(BigDecimal.valueOf(5000)) >= 0;
    }
}
