package dtos;

import models.AccountDetails;
import models.AccountType;
import models.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AccountDetailsResponseDTO {

    private Long accountNo;
    private Long customerId;
    private String customerName;
    private double currentBalance;
    private AccountType accountType;
    private List<Transaction> transactionHistory;


    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<Transaction> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    @Override
    public String toString() {
        return "Account No: " + this.accountNo +
                "\nCustomer Id: " + this.customerId +
                "\nCustomer Name: "+this.customerName+
                "\nAccount Type: " + this.accountType +
                "\nCurrent Balance: "+this.currentBalance+
                "\nLast Transaction: " + (this.transactionHistory.isEmpty() ? "No transactions yet!" : "\n"+getLastTransaction());
    }


    public static AccountDetailsResponseDTO convertAccountDetailsToAccountDetailsResponseDTO(AccountDetails accountDetails) {

        AccountDetailsResponseDTO accountDetailsResponseDTO = new AccountDetailsResponseDTO();

        accountDetailsResponseDTO.setAccountNo(accountDetails.getAccount_No());
        accountDetailsResponseDTO.setCustomerId(accountDetails.getCustomer().getCustomerId());
        accountDetailsResponseDTO.setCustomerName(accountDetails.getCustomer().getCustomerName());
        accountDetailsResponseDTO.setAccountType(accountDetails.getAccountType());
        accountDetailsResponseDTO.setCurrentBalance(accountDetails.getAccountBalance());
        accountDetailsResponseDTO.setTransactionHistory(accountDetails.getTransactionHistory());


//        List<Transaction> transactionList = accountDetails.getTransactionHistory();
//
//        List<TransactionResponseDTO> transactionResponseList = new ArrayList<>();
//
//        for(Transaction transaction: transactionList){
//            transactionResponseList.add(TransactionResponseDTO.convertTransactionToTransactionResponseDTO(transaction));
//        }
//        accountDetailsResponseDTO.setTransactionHistory(transactionResponseList);
        return accountDetailsResponseDTO;
    }

     String getLastTransaction(){
         Transaction transaction = transactionHistory.get(0);

        TransactionResponseDTO transactionResponseDTO = TransactionResponseDTO.convertTransactionToTransactionResponseDTO(transaction);

         return  transactionResponseDTO.getTransactionType()+" "+transactionResponseDTO.getAmount()+" on "+
                 transactionResponseDTO.getTransactionTime();
    }
}
