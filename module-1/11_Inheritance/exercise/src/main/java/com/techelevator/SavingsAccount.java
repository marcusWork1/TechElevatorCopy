package com.techelevator;

public class SavingsAccount extends BankAccount{


    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        int newBalance;
        newBalance = getBalance() - amountToWithdraw;
        // if remaining balance is less than 150 after withdraw, $2 is withdrawn
        if ( newBalance >= 150 ) {
            super.withdraw(amountToWithdraw);
        }
        // if the remaining balance is less than 150 after withdraw, then a $2 charge is added
        // so the balance available has to also be greater than or equal to 2.
        if (newBalance < 150 && newBalance >= 2) {
            super.withdraw(amountToWithdraw + 2);
        }
        // any balance less than 2 after a withdraw would overdraft
        // so there would be no withdraw and you return the balance with getBalance
        return getBalance();
    }
}// end of class
