package com.rafaelrodrigues1.desafios.loans.application.usecases;

import com.rafaelrodrigues1.desafios.loans.application.ports.AccessLoanPort;
import com.rafaelrodrigues1.desafios.loans.domain.models.Customer;
import com.rafaelrodrigues1.desafios.loans.domain.models.Loan;

import java.util.Set;

public class LoansTypesByCustomer {

    private AccessLoanPort accessLoanPort;

    public LoansTypesByCustomer(AccessLoanPort accessLoanPort) {
        this.accessLoanPort = accessLoanPort;
    }

    public Set<Loan> getLoanTypesByCustomer(Customer customer) {
        return this.accessLoanPort.getLoanTypesByCustomer(customer);
    }
}
