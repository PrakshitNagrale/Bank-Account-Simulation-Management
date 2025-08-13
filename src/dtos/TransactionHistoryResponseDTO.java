package dtos;

import models.Transaction;
import models.TransactionType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class TransactionHistoryResponseDTO {

//    Account No: 123456789
//
//            #1
//    Transaction Type : DEPOSIT
//    Amount           : 500.00
//    Updated Balance  : 1500.00
//    Transaction ID   : 4a7b21ac-7c9b-4a26-91fd-f9e3d3771d20
//    Date & Time      : 13-Aug-2025 08:53 PM

    private Long accountNumber;
    private TransactionType transactionType;
    private double amount;
    private double updatedBalance;
    private UUID transactionId;
    private String localDateTime;




    public double getUpdatedBalance() {
        return updatedBalance;
    }

    public void setUpdatedBalance(double updatedBalance) {
        this.updatedBalance = updatedBalance;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public String getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(String localDateTime) {
        this.localDateTime = localDateTime;
    }


    @Override
    public String toString() {
        return "Transaction Type :" + this.transactionType +
                "\nAmount           :" + this.amount +
                "\nUpdated Balance  :" + this.updatedBalance +
                "\nTransaction Id   :" + this.transactionId +
                "\nDate & Time      :" + this.localDateTime;

    }


    public static TransactionHistoryResponseDTO convertTransactionToTransactionHistoryDTO(Transaction transaction) {

        TransactionHistoryResponseDTO transactionHistoryResponse = new TransactionHistoryResponseDTO();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a");
        String dateTime  =  transaction.getTransactionDateTime().format(formatter);

        transactionHistoryResponse.setTransactionType(transaction.getTransactionType());
        transactionHistoryResponse.setAmount(transaction.getAmount());
        transactionHistoryResponse.setUpdatedBalance(transaction.getUpdatedBalance());
        transactionHistoryResponse.setTransactionId(transaction.getTransactionId());
        transactionHistoryResponse.setLocalDateTime(dateTime);

        return transactionHistoryResponse;
    }
}
