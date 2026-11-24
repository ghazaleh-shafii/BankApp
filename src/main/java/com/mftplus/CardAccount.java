package com.mftplus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
public class CardAccount extends Account {
    private String cardNumber;

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("مبلغ واریز باید بزرگتر از صفر باشد.");
        }
        setBalance(getBalance() + amount);

    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("مبلغ برداشت باید بزرگتر از صفر باشد.");
        }
        if (amount > getBalance()) {
            throw new IllegalArgumentException("موجودی حساب کارتی کافی نیست.");
        }
        setBalance(getBalance() - amount);
    }
}
