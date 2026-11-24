package com.mftplus;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankServiceTest {

    @Test
    void testCardToCardSuccess() {
        BankService bankService = new BankService();

        CardAccount card1 = CardAccount.builder()
                .accountNumber(101L)
                .cardNumber("1111-2222-3333-4444")
                .balance(2000)
                .active(true)
                .build();

        CardAccount card2 = CardAccount.builder()
                .accountNumber(102L)
                .cardNumber("5555-6666-7777-8888")
                .balance(500)
                .active(true)
                .build();

        bankService.cardToCard(card1, card2, 700);

        assertEquals(1300, card1.getBalance());
        assertEquals(1200, card2.getBalance());
    }

    @Test
    void testAccountToAccountSuccess() {
        BankService bankService = new BankService();

        SavingAccount acc1 = SavingAccount.builder()
                .accountNumber(301L)
                .balance(4000)
                .active(true)
                .build();

        CardAccount acc2 = CardAccount.builder()
                .accountNumber(302L)
                .balance(1000)
                .active(true)
                .build();

        bankService.accountToAccount(acc1, acc2, 1500);

        assertEquals(2500, acc1.getBalance());
        assertEquals(2500, acc2.getBalance());
    }

    @Test
    void testInactiveAccountThrowsException() {
        BankService bankService = new BankService();

        SavingAccount acc1 = SavingAccount.builder()
                .accountNumber(301L)
                .balance(3000)
                .active(true)
                .build();

        SavingAccount acc2 = SavingAccount.builder()
                .accountNumber(302L)
                .balance(1000)
                .active(false) // حساب غیرفعال
                .build();

        assertThrows(IllegalStateException.class,
                () -> bankService.accountToAccount(acc1, acc2, 500));

        // مطمئن می‌شویم پولی از حساب مبدأ کم نشده است
        assertEquals(3000, acc1.getBalance());
    }
}