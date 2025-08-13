package models;

import java.util.ArrayList;
import java.util.List;

public class AccountDetails {

    private Long account_No;
    private Customer customer;
    private double accountBalance;
    private AccountType accountType;
    private String accountPassword;
    private List<Transaction> transactionHistory;

    public AccountDetails() {
        this.transactionHistory = new ArrayList<>();
    }

    public Long getAccount_No() {
        return account_No;
    }

    public void setAccount_No(Long account_No) {
        this.account_No = account_No;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<Transaction> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }
}
