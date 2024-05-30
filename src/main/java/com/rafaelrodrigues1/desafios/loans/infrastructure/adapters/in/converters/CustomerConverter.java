package com.rafaelrodrigues1.desafios.loans.infrastructure.adapters.in.converters;

import com.rafaelrodrigues1.desafios.loans.domain.models.Customer;
import com.rafaelrodrigues1.desafios.loans.infrastructure.adapters.in.dto.CustomerRequest;

public class CustomerConverter {

    public static Customer toModel(CustomerRequest customerRequest) {
        return new Customer(
                customerRequest.cpf(),
                customerRequest.name(),
                customerRequest.age(),
                customerRequest.location(),
                customerRequest.income()
        );
    }
}
