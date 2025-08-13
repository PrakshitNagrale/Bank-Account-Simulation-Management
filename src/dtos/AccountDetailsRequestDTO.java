package dtos;

import models.AccountDetails;
import models.AccountType;
import models.Customer;

public class AccountDetailsRequestDTO {

    private Long account_No;
    private Customer customer;
    private double accountBalance;
    private AccountType accountType;
    private String accountPassword;


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

    public static AccountDetails convertAccountDetailsRequestDTOToAccountDetails(AccountDetailsRequestDTO accountDetailsRequestDTO) {

        AccountDetails accountDetails = new AccountDetails();

        accountDetails.setAccount_No(accountDetailsRequestDTO.getAccount_No());
        accountDetails.setCustomer(accountDetailsRequestDTO.getCustomer());
        accountDetails.setAccountPassword(accountDetailsRequestDTO.getAccountPassword());
        accountDetails.setAccountType(accountDetailsRequestDTO.getAccountType());
        accountDetails.setAccountBalance(accountDetailsRequestDTO.getAccountBalance());

        return accountDetails;
    }



}
