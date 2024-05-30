package com.rafaelrodrigues1.desafios.loans.infrastructure.adapters.out;

import com.rafaelrodrigues1.desafios.loans.application.ports.AccessLoanPort;
import com.rafaelrodrigues1.desafios.loans.domain.enums.LoanType;
import com.rafaelrodrigues1.desafios.loans.domain.models.Customer;
import com.rafaelrodrigues1.desafios.loans.domain.models.Loan;
import com.rafaelrodrigues1.desafios.loans.infrastructure.adapters.out.impl.IncomeBetweenThreeFiveThousandUnderThirtyYearsResidingDefaultState;
import com.rafaelrodrigues1.desafios.loans.infrastructure.adapters.out.impl.IncomeEqualOrGreaterThanFiveThousand;
import com.rafaelrodrigues1.desafios.loans.infrastructure.adapters.out.impl.IncomeEqualOrLessThanThreeThousand;
import com.rafaelrodrigues1.desafios.loans.infrastructure.adapters.out.interfaces.LoanAccessChecker;
import lombok.Getter;

import java.util.*;

public class AccessLoanAdapter implements AccessLoanPort {

    @Override
    public Set<Loan> getLoanTypesByCustomer(Customer customer) {
        List<Loan> loanList = Arrays.stream(InterestRateLoanType.values())
                .map(interestRateLoan -> interestRateLoan.getLoanTypeByCustomer(customer))
                .filter(Objects::nonNull)
                .map(interestRateLoan -> new Loan(interestRateLoan.getLoanType(), interestRateLoan.getInterestRate()))
                .toList();
        return new HashSet<>(loanList);
    }
}

enum InterestRateLoanType {

    PERSONAL(LoanType.PERSONAL, 4D, List.of(new IncomeEqualOrLessThanThreeThousand(),
            new IncomeBetweenThreeFiveThousandUnderThirtyYearsResidingDefaultState())),
    GUARANTEED(LoanType.GUARANTEED, 3D, List.of(new IncomeEqualOrLessThanThreeThousand(),
            new IncomeBetweenThreeFiveThousandUnderThirtyYearsResidingDefaultState())),
    CONSIGNMENT(LoanType.CONSIGNMENT, 2D, List.of(new IncomeEqualOrGreaterThanFiveThousand()));

    @Getter
    private final LoanType loanType;
    @Getter
    private final Double interestRate;
    private final List<LoanAccessChecker> loanAccessCheckerList;

    InterestRateLoanType(LoanType loanType, Double interestRate, List<LoanAccessChecker> loanAccessCheckerList) {
        this.loanType = loanType;
        this.interestRate = interestRate;
        this.loanAccessCheckerList = loanAccessCheckerList;
    }

    public InterestRateLoanType getLoanTypeByCustomer(Customer customer) {
        return this.loanAccessCheckerList.stream()
                .filter(loanAccessChecker -> loanAccessChecker.check(customer)).toList().isEmpty() ? null : this;
    }
}
