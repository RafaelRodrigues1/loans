package com.rafaelrodrigues1.desafios.loans.infrastructure.adapters.in;

import com.rafaelrodrigues1.desafios.loans.application.usecases.LoansTypesByCustomer;
import com.rafaelrodrigues1.desafios.loans.domain.models.Customer;
import com.rafaelrodrigues1.desafios.loans.domain.models.Loan;
import com.rafaelrodrigues1.desafios.loans.infrastructure.adapters.in.converters.CustomerConverter;
import com.rafaelrodrigues1.desafios.loans.infrastructure.adapters.in.dto.CustomerRequest;
import com.rafaelrodrigues1.desafios.loans.infrastructure.adapters.out.converters.LoanConverter;
import com.rafaelrodrigues1.desafios.loans.infrastructure.adapters.out.dto.AccessLoanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class LoanController {

    @Autowired
    private LoansTypesByCustomer loansTypesByCustomer;

    @PostMapping("/customer-loans")
    public ResponseEntity<AccessLoanResponse> getAccessLoansByCustomer(@RequestBody CustomerRequest customerRequest) {
        Customer customer = CustomerConverter.toModel(customerRequest);
        Set<Loan> loanTypesByCustomer = this.loansTypesByCustomer.getLoanTypesByCustomer(customer);

        return ResponseEntity.ok(LoanConverter.toDto(loanTypesByCustomer, customer));
    }
}
