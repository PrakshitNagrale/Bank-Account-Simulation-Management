package client;

import models.AccountDetails;
import models.Customer;
import models.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankOperationClient {

    Map<Long,Customer> customersMap; //map to store customers
    Map<Long,AccountDetails> accountDetailsMap; //map to store account details
    Map<Long , List<Transaction>> transactionMap;

    public BankOperationClient() {
        this.customersMap = new HashMap<>();
        this.accountDetailsMap = new HashMap<>();
        this.transactionMap = new HashMap<>();
    }



    public void registerCustomer(Customer customer) {

        customersMap.put(customer.getCustomerId(),customer);
    }

    public void createNewAccount(AccountDetails accountDetails) {

        accountDetailsMap.put(accountDetails.getAccount_No(),accountDetails);

    }

    public Customer findByCustomerId(Long userId) {

        return customersMap.get(userId);
    }

    public AccountDetails findAccountDetailsByAccountNumber(Long accountNumber) {

        return accountDetailsMap.get(accountNumber);
    }

    public boolean checkCustomerIsEmpty() {

        return customersMap.isEmpty();
    }

    public boolean checkAccountDetailsIsEmpty() {

        return accountDetailsMap.isEmpty();
    }



    public void addTransaction(AccountDetails accountDetails, Transaction transaction) {


        accountDetails.getTransactionHistory().add(transaction);//adding transaction list to account details

    }
}
