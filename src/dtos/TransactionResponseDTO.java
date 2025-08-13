package dtos;

import models.Transaction;
import models.TransactionType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class TransactionResponseDTO {

    private TransactionType transactionType;
    private double amount;
    private double updatedBalance;
    private UUID transactionId;
    private String transactionTime;

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

    public double getUpdatedBalance() {
        return updatedBalance;
    }

    public void setUpdatedBalance(double updatedBalance) {
        this.updatedBalance = updatedBalance;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }


    @Override
    public String toString() {

        return  "Transaction Type: "+this.transactionType+
                "\nAmount "+this.transactionType+": " + this.amount +
                "\nUpdated Balance: " + this.updatedBalance +
                "\nTransaction Id: " + this.transactionId +
                "\nTransaction Time: " + this.transactionTime;

    }

    public static TransactionResponseDTO convertTransactionToTransactionResponseDTO(Transaction transaction){

        TransactionResponseDTO transactionResponseDTO = new TransactionResponseDTO();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a");
       String dateTime  =  transaction.getTransactionDateTime().format(formatter);


        transactionResponseDTO.setTransactionType(transaction.getTransactionType());
        transactionResponseDTO.setAmount(transaction.getAmount());
        transactionResponseDTO.setUpdatedBalance(transaction.getUpdatedBalance());
        transactionResponseDTO.setTransactionId(transaction.getTransactionId());
        transactionResponseDTO.setTransactionTime(dateTime);

        return transactionResponseDTO;

    }
}
