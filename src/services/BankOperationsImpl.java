package services;

import client.BankOperationClient;
import dtos.*;
import exceptions.*;
import models.AccountDetails;
import models.Customer;
import models.Transaction;
import models.TransactionType;
import org.mindrot.jbcrypt.BCrypt;

import java.time.LocalDateTime;
import java.util.*;

public class BankOperationsImpl implements BankOperations{

    BankOperationClient bankOperationClient;

    public BankOperationsImpl() {
        this.bankOperationClient = new BankOperationClient();
    }

    @Override
    public Customer registerCustomer(CustomerRequestDTO customerRequestDTO) {

        Customer customer = customerRequestDTO.convertCustomerRequestDTOtoCustomer(customerRequestDTO);

        bankOperationClient.registerCustomer(customer);

        return customer;




    }

    @Override
    public AccountDetailsResponseDTO createNewAccount(AccountDetailsRequestDTO accountDetailsRequestDTO) {

        AccountDetails accountDetails = AccountDetailsRequestDTO.convertAccountDetailsRequestDTOToAccountDetails(accountDetailsRequestDTO);

        bankOperationClient.createNewAccount(accountDetails);
        return AccountDetailsResponseDTO.convertAccountDetailsToAccountDetailsResponseDTO(accountDetails);


    }

    @Override
    public AccountDetailsResponseDTO getCustomerAccountDetails(Long accountNUmber, String password) {

        AccountDetails accountDetails = bankOperationClient.findAccountDetailsByAccountNumber(accountNUmber);

        String  hashedPassword = accountDetails.getAccountPassword();
        if(!BCrypt.checkpw(password,hashedPassword)){ //if password does not match

            throw  new IncorrectPasswordException("Incorrect Password! Please Enter valid Password!");
        }

        return  AccountDetailsResponseDTO.convertAccountDetailsToAccountDetailsResponseDTO(accountDetails);

    }

    @Override
    public TransactionResponseDTO depositMoney(Long accountNumber, double amount) {

        AccountDetails accountDetails = bankOperationClient.findAccountDetailsByAccountNumber(accountNumber);
        double updatedBalance = accountDetails.getAccountBalance()+amount;

        accountDetails.setAccountBalance(updatedBalance);//setting account balance

        Transaction transaction = new Transaction(); //creating new transaction
        transaction.setTransactionId(UUID.randomUUID());
        transaction.setCustomer(accountDetails.getCustomer());
        transaction.setAccountDetails(accountDetails);
        transaction.setTransactionType(TransactionType.DEPOSIT);
        transaction.setAmount(amount);
        transaction.setUpdatedBalance(updatedBalance);
        transaction.setTransactionDateTime(LocalDateTime.now());

        bankOperationClient.addTransaction(accountDetails,transaction); //to add transaction

        return TransactionResponseDTO.convertTransactionToTransactionResponseDTO(transaction); //returning transaction details

    }

    @Override
    public TransactionResponseDTO withdrawMoney(Long accountNumber, double withdrawAmount) {

        AccountDetails accountDetails = bankOperationClient.findAccountDetailsByAccountNumber(accountNumber);

        if(accountDetails.getAccountBalance() < withdrawAmount){ //throw exception if current balance is less than withdraw amount
            throw new InsufficientFundsException("Insufficient Funds!");
        }
       double updatedBalance = accountDetails.getAccountBalance()-withdrawAmount; //updating balance
        accountDetails.setAccountBalance(updatedBalance);

        Transaction transaction = new Transaction(); //creating new transaction
        transaction.setTransactionId(UUID.randomUUID());
        transaction.setCustomer(accountDetails.getCustomer());
        transaction.setAccountDetails(accountDetails);
        transaction.setTransactionType(TransactionType.WITHDRAW);
        transaction.setAmount(withdrawAmount);
        transaction.setUpdatedBalance(updatedBalance);
        transaction.setTransactionDateTime(LocalDateTime.now());

        bankOperationClient.addTransaction(accountDetails,transaction); //to add transaction

        return TransactionResponseDTO.convertTransactionToTransactionResponseDTO(transaction); //returning transaction details
    }

    @Override
    public void checkDuplicateCustomerId(Long customer_id) {

          Customer customer = bankOperationClient.findByCustomerId(customer_id);

          if(customer!=null){
              throw new DuplicateCustomerIdException("Customer Id Already Exists! Please Enter different Customer Id");
        }

    }

    @Override
    public void checkDuplicateAccountNumber(Long accountNumber) {

        AccountDetails  accountDetails = bankOperationClient.findAccountDetailsByAccountNumber(accountNumber);

        if(accountDetails !=null){
            throw new DuplicateAccountNumberException("Account Number Already Exists! Please Enter different Account Number");
        }

    }

    @Override
    public Customer checkCustomerIdExists(Long customerId) {

       Customer customer = bankOperationClient.findByCustomerId(customerId);

       if(customer != null){
           return customer;
       }
       throw  new InvalidCustomerIdException("Invalid Customer Id! Customer Id does Not Exists!");

    }

    @Override
    public void checkCustomerIsEmpty() {

         if(bankOperationClient.checkCustomerIsEmpty()){
             throw  new NoRegisteredCustomerException("No customer Present! Please Register Customer First");
         }
    }

    @Override
    public void checkAccountDetailsIsEmpty() {

         if(bankOperationClient.checkAccountDetailsIsEmpty()){
             throw new NoAccountDetailsPresentException("No Account Present! Please create Account First!");
         }

    }

    @Override
    public AccountDetails checkAccountNumberExists(Long accountNumber) {

        AccountDetails accountDetails = bankOperationClient.findAccountDetailsByAccountNumber(accountNumber);

        if(accountDetails == null) {
            throw  new NoAccountDetailsPresentException("Invalid Account Number! Please Enter valid Account Number!");
        }

        return accountDetails;

    }

    @Override
    public void checkAccountBelongsToCustomer(Long accountNumber, Long customerId) {

        AccountDetails accountDetails = bankOperationClient.findAccountDetailsByAccountNumber(accountNumber);

        Long accountCustomerId = accountDetails.getCustomer().getCustomerId();

       if(customerId != accountCustomerId){

           throw new NoAccountDetailsPresentException("Account Number doest not belong to Customer Id! Please Enter " +
                   "different Account Number or Customer Id ");
       }
    }

    @Override
    public void checkAccountNoAndPasswordMatch(Long accountNumber, String password) {
        AccountDetails accountDetails = bankOperationClient.findAccountDetailsByAccountNumber(accountNumber);

        if(!BCrypt.checkpw(password,accountDetails.getAccountPassword())){
            throw new IncorrectPasswordException("Incorrect Password! Please Enter valid Password!");
        }
    }

    @Override
    public List<TransactionHistoryResponseDTO> getTransactionHistory(Long accountNumber) {

       AccountDetails accountDetails = bankOperationClient.findAccountDetailsByAccountNumber(accountNumber);

       List<Transaction> transactionList = accountDetails.getTransactionHistory();

       List<TransactionHistoryResponseDTO> transactionHistoryResponseList = new ArrayList<>();

       for(Transaction transaction : transactionList){
           transactionHistoryResponseList.add(TransactionHistoryResponseDTO.convertTransactionToTransactionHistoryDTO(transaction));

       }

       return transactionHistoryResponseList;


    }

    @Override
    public double getAccountBalance(Long accountNumber) {

        AccountDetails accountDetails = bankOperationClient.findAccountDetailsByAccountNumber(accountNumber);

        return  accountDetails.getAccountBalance();
    }


}
