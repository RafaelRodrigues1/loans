package com.rafaelrodrigues1.desafios.loans.config;

import com.rafaelrodrigues1.desafios.loans.application.usecases.LoansTypesByCustomer;
import com.rafaelrodrigues1.desafios.loans.infrastructure.adapters.out.AccessLoanAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBean {

    @Bean
    public LoansTypesByCustomer getLoansTypesByCustomer() {
        return new LoansTypesByCustomer(new AccessLoanAdapter());
    }
}
