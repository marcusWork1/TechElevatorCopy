package com.techelevator;

public class CheckingAccount extends BankAccount {


    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        int newBalance = getBalance() - amountToWithdraw;
        if (newBalance > -100) {
            super.withdraw(amountToWithdraw);
            if (newBalance < 0) {
                super.withdraw(10);
            }
    } return getBalance();
}
} // end of class
