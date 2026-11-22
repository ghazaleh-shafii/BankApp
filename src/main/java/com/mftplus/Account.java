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
public abstract class Account {
    private long accountNumber;
    private String ownerName;
    private String ownerFamily;
    private double balance;
    private boolean active;

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

}
