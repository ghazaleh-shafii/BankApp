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

public class SavingAccount extends Account {
    @Override
    public void deposit(double amount) {

    }

    @Override
    public void withdraw(double amount) {

    }
}
