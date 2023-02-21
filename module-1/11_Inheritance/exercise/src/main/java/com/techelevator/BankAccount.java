package com.techelevator;

public class BankAccount {
    // set up attributes/instances

    private String  accountHolderName;
    private String accountNumber;
    private int balance;
// initialize attributes with constructors
    public BankAccount( String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
    }
    // initialize attributes with constructors
public BankAccount(String accountHolderName, String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;

}

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public int deposit(int amountToDeposit) {
       balance += amountToDeposit;
       return balance;
        }
        public int withdraw(int amountToWithdraw) {
        balance -= amountToWithdraw;
        return balance;

    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountHolderName='" + accountHolderName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}  // end of class
