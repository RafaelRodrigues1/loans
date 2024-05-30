package com.rafaelrodrigues1.desafios.loans.application.ports;

import com.rafaelrodrigues1.desafios.loans.domain.models.Customer;
import com.rafaelrodrigues1.desafios.loans.domain.models.Loan;

import java.util.Set;

public interface AccessLoanPort {

    Set<Loan> getLoanTypesByCustomer(Customer customer);
}
