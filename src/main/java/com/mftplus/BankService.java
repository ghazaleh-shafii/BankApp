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

public class BankService  {
    public void cardToCard(CardAccount srcCard, CardAccount destCard, double amount) {
        if (srcCard == null || destCard == null) {
            throw new IllegalArgumentException("حساب کارتی مبدأ یا مقصد نمی‌تواند خالی باشد.");
        }
        if (!srcCard.isActive() || !destCard.isActive()) {
            throw new IllegalStateException("یکی از کارت‌ها غیرفعال است و امکان کارت به کارت وجود ندارد.");
        }

        srcCard.withdraw(amount);
        destCard.deposit(amount);
    }
    public void accountToAccount(Account srcAccount, Account destAccount, double amount) {
        if (srcAccount == null || destAccount == null) {
            throw new IllegalArgumentException("حساب مبدأ یا مقصد نمی‌تواند خالی باشد.");
        }
        if (!srcAccount.isActive() || !destAccount.isActive()) {
            throw new IllegalStateException("یکی از حساب‌ها غیرفعال است و امکان انتقال وجه وجود ندارد.");
        }

        srcAccount.withdraw(amount);
        destAccount.deposit(amount);
    }

}
