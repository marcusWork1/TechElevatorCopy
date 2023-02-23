package com.techelevator;

/**
 * CreditCardAccount
 */
public class CreditCardAccount implements Accountable {

    // create instances
    private String accountHolder;
    private String accountNumber;
    private int debt;

    // create constructor to initialize instances
    public CreditCardAccount(String accountHolder, String accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.debt = 0;
    }
    // make getters to return information
    public String getAccountHolder() {
        return this.accountHolder;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public int getDebt() {
        return this.debt;
    }

    // make methods to get credit card account up and going
    // pay method returns debt after amount has been paid
    public int pay(int amountToPay) {
        this.debt = this.debt - amountToPay;
        return this.debt;
    }

    // charge method adds to amount owed
    public int charge(int amountToCharge) {
        this.debt = this.debt + amountToCharge;
        return this.debt;
    }

    public int getBalance() {
        //***************************************************************
        // This should return the negative of the debt data member
        //***************************************************************
       return 0 - this.debt;
    }
}