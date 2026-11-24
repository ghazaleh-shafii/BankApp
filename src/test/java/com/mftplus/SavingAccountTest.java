package com.mftplus;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SavingAccountTest {

    @Test
    void testDepositAndWithdraw() {
        SavingAccount saving = SavingAccount.builder()
                .accountNumber(2001L)
                .ownerName("Ali")
                .ownerFamily("Alipour")
                .interest(20)
                .balance(5000)
                .active(true)
                .build();

        saving.deposit(1000);
        assertEquals(6000, saving.getBalance());

        saving.withdraw(2000);
        assertEquals(4000, saving.getBalance());
        assertEquals(20, saving.getInterest());
    }

    @Test
    void testWithdrawMoreThanBalance() {
        SavingAccount saving = SavingAccount.builder()
                .accountNumber(2001L)
                .balance(1000)
                .active(true)
                .build();

        assertThrows(IllegalArgumentException.class, () -> saving.withdraw(1500));
    }
}