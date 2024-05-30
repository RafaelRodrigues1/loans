package com.rafaelrodrigues1.desafios.loans.infrastructure.adapters.out.impl;

import com.rafaelrodrigues1.desafios.loans.domain.models.Customer;
import com.rafaelrodrigues1.desafios.loans.infrastructure.adapters.out.interfaces.LoanAccessChecker;
import com.rafaelrodrigues1.desafios.loans.infrastructure.adapters.utils.BeanUtil;

import java.math.BigDecimal;

public class IncomeBetweenThreeFiveThousandUnderThirtyYearsResidingDefaultState implements LoanAccessChecker {

    private ConfigProperties configProperties;

    public IncomeBetweenThreeFiveThousandUnderThirtyYearsResidingDefaultState() {
        this.configProperties = BeanUtil.getBean(ConfigProperties.class);
    }

    @Override
    public Boolean check(Customer customer) {
        return customer.income().compareTo(BigDecimal.valueOf(3000)) >= 0
                && customer.income().compareTo(BigDecimal.valueOf(5000)) <= 0
                && configProperties.getDefaultStates().contains(customer.location());
    }
}
