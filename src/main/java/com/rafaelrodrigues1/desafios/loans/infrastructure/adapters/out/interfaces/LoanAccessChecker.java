package com.rafaelrodrigues1.desafios.loans.infrastructure.adapters.out.interfaces;

import com.rafaelrodrigues1.desafios.loans.domain.models.Customer;

public interface LoanAccessChecker {

    Boolean check(Customer customer);
}
