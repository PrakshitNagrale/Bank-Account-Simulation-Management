package services;

import dtos.*;
import models.AccountDetails;
import models.Customer;

import java.util.List;

public interface BankOperations {

    Customer registerCustomer(CustomerRequestDTO customerRequestDTO);
    AccountDetailsResponseDTO createNewAccount(AccountDetailsRequestDTO accountDetailsRequestDTO);
    AccountDetailsResponseDTO getCustomerAccountDetails(Long accountNumber, String password);
    TransactionResponseDTO depositMoney(Long accountNumber, double amount);
    TransactionResponseDTO withdrawMoney(Long accountNumber, double withdrawAmount);
    double getAccountBalance(Long accountNumber);

    void checkDuplicateCustomerId(Long userId);

    void checkDuplicateAccountNumber(Long accountNumber);

    Customer checkCustomerIdExists(Long customerId);

    void checkCustomerIsEmpty();

    void checkAccountDetailsIsEmpty();

    AccountDetails checkAccountNumberExists(Long accountNumber);

    void checkAccountBelongsToCustomer(Long accountNumber, Long customerId);

    void checkAccountNoAndPasswordMatch(Long accountNumber, String password);

    List<TransactionHistoryResponseDTO> getTransactionHistory(Long accountNumber);
}
