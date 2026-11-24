package com.mftplus;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CardAccountTest {

    @Test
    void testDepositAndWithdraw() {
        CardAccount card = CardAccount.builder()
                .accountNumber(1001L)
                .ownerName("Ghazaleh")
                .ownerFamily("Shafii")
                .cardNumber("6037-9911-2233-4455")
                .balance(1000)
                .active(true)
                .build();

        card.withdraw(100);
        assertEquals(900, card.getBalance());

        card.deposit(300);
        assertEquals(1200, card.getBalance());
    }

    @Test
    void testWithdrawMoreThanBalance() {
        CardAccount card = CardAccount.builder()
                .accountNumber(1001L)
                .balance(500)
                .active(true)
                .build();

        assertThrows(IllegalArgumentException.class, () -> card.withdraw(600));
    }

    @Test
    void testNegativeBalance() {
        CardAccount card = new CardAccount();
        assertThrows(IllegalArgumentException.class, () -> card.setBalance(-10));
    }
}