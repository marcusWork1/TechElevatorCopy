package com.techelevator;

import java.util.ArrayList;
import java.util.List;

/**
 * BankCustomer
 */
public class BankCustomer {

    // this is an array list for customers accountables
    private List<Accountable> accounts = new ArrayList<>();   // List of Accountable objects
    //create instances
    private String name;
    private String address;
    private String phoneNumber;

// add getters and setters to return necessary info

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;

    }

    public Accountable[] getAccounts() {
        return accounts.toArray(new Accountable[accounts.size()]);
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addAccount(Accountable newAccount) {
        accounts.add(newAccount);
    }

    public boolean isVip() {
        int balance = 0;
        for (int findingAccountBalances = 0; findingAccountBalances < this.accounts.size(); findingAccountBalances++) {
            Accountable accTotal = this.accounts.get(findingAccountBalances);
            balance = balance + accTotal.getBalance();
        }
        if (balance >= 25000) {
            return true;
        }
        else {
            return false;
        }

    }
}
