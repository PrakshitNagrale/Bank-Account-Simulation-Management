package BankAccountMangement;

import ValidateInvalidInput.ValidateInput;
import dtos.*;
import exceptions.*;
import models.Customer;
import services.BankOperations;
import services.BankOperationsImpl;

import java.util.List;
import java.util.Scanner;

public class BankAccountInputController {

    BankOperations bankOperations;
    Scanner sc;


    public BankAccountInputController(Scanner sc) {
        this.bankOperations = new BankOperationsImpl();
        this.sc = sc;
    }

    public  void registerCustomer() { //taking input to register customer

            CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();//creating customer dto object;
         try{
            System.out.println("Please Enter Customer Id: ");
             Long customer_id = ValidateInput.validateLongInput(sc.nextLine()); // to validate Integer input

            bankOperations.checkDuplicateCustomerId(customer_id);//check for duplicate id

            customerRequestDTO.setCustomerId(customer_id);

            System.out.println("Please Enter Customer Name: ");
            customerRequestDTO.setName(ValidateInput.validateStringInput(sc.nextLine()));

            System.out.println("Please Enter Customer Phone No: ");
            customerRequestDTO.setPhoneNo(ValidateInput.validateLongInput(sc.nextLine()));

            System.out.println("Please Enter Customer Address: ");
            customerRequestDTO.setAddress(ValidateInput.validateStringInput(sc.nextLine()));

            Customer customer = bankOperations.registerCustomer(customerRequestDTO); //calling create customer from service

            System.out.println("----Customer Registered Successfully!----");
            System.out.println(customer);//printing customer
            System.out.println("===========================================");

        }catch (DuplicateIdException | MaxAttemptExceededException exception){
            System.out.println(exception.getMessage());
         }
    }

    public void createNewAccount() {

        AccountDetailsRequestDTO accountDetailsRequestDTO = new AccountDetailsRequestDTO();

        try{
            System.out.println("Please Enter Account Number:");
            Long account_number = ValidateInput.validateLongInput(sc.nextLine());

            bankOperations.checkDuplicateAccountNumber(account_number);//check for duplicate Account number
            accountDetailsRequestDTO.setAccount_No(account_number);

            System.out.println("Please Enter Customer Id: ");
            Long customer_id = ValidateInput.validateLongInput(sc.nextLine());

           Customer customer = bankOperations.checkCustomerIdExists(customer_id); //to check customer exists
            accountDetailsRequestDTO.setCustomer(customer);

            System.out.println("Please Enter Account Balance: ");
            accountDetailsRequestDTO.setAccountBalance(ValidateInput.validateDoubleInput(sc.nextLine()));

            System.out.println("Please Select Account Type: \n1.SAVING \n2.CURRENT \n3.FIXED_DEPOSIT");  //to set account type
            accountDetailsRequestDTO.setAccountType(ValidateInput.validateAccountTypeFromInput(sc.nextLine()));

            String password = ValidateInput.takePasswordInput(sc);
            String hashedPassword = ValidateInput.hashPassword(password);// taking password input and storing its hashed value,using  jBCrypt password(added jar in classpath)
            accountDetailsRequestDTO.setAccountPassword(hashedPassword);

            AccountDetailsResponseDTO accountDetailsResponseDTO = bankOperations.createNewAccount(accountDetailsRequestDTO);

            System.out.println("----New Account Created Successfully!----");
            System.out.println(accountDetailsResponseDTO);//printing account details
            System.out.println("===========================================");

        }catch (MaxAttemptExceededException | DuplicateAccountNumberException | InvalidCustomerIdException |
                IncorrectPasswordException exception){
            System.out.println(exception.getMessage());

        }

    }

    public void ViewCustomerAccountDetails() {

        try{
            bankOperations.checkCustomerIsEmpty(); //to check customer details present or not

            System.out.println("Please Enter Customer id: ");
            Long customerId = ValidateInput.validateLongInput(sc.nextLine());

            bankOperations.checkCustomerIdExists(customerId); //to check customer Id exists

            bankOperations.checkAccountDetailsIsEmpty(); //to check account details are preset or not

            System.out.println("Please Enter Account Number: ");
            Long accountNumber = ValidateInput.validateLongInput(sc.nextLine());

            bankOperations.checkAccountNumberExists(accountNumber);

            bankOperations.checkAccountBelongsToCustomer(accountNumber,customerId);

            System.out.println("Please Enter Password: ");
            String password = sc.nextLine();

            AccountDetailsResponseDTO accountDetails = bankOperations.getCustomerAccountDetails(accountNumber,password);


            System.out.println("----View Account Details----");
            System.out.println(accountDetails);//printing account details
            System.out.println("===========================================");


        }catch (NoRegisteredCustomerException|MaxAttemptExceededException|InvalidCustomerIdException| NoAccountDetailsPresentException |
                IncorrectPasswordException exception){
            System.out.println(exception.getMessage());
        }



    }

    public void depositMoney() {

        try{
            bankOperations.checkAccountDetailsIsEmpty();//to check account exists

            System.out.println("Please Enter Account Number: ");
            Long accountNumber = ValidateInput.validateLongInput(sc.nextLine());

            bankOperations.checkAccountNumberExists(accountNumber); //to check account number is valid

            System.out.println("Please Enter Password: ");
            String password = sc.nextLine();

            bankOperations.checkAccountNoAndPasswordMatch(accountNumber,password); //to check account number and password match

            System.out.println("Please Enter Amount to deposit: ");
            double amount = ValidateInput.validateDoubleInput(sc.nextLine());

            TransactionResponseDTO transactionResponse  =  bankOperations.depositMoney(accountNumber,amount);

            System.out.println("-----Amount deposited Successfully!-----");
            System.out.println(transactionResponse);
            System.out.println("===========================================");


        }catch (NoAccountDetailsPresentException|IncorrectPasswordException  exception){
            System.out.println(exception.getMessage());
        }




    }

    public void withdrawMoney() {

        try{
            bankOperations.checkAccountDetailsIsEmpty();//to check account exists

            System.out.println("Please Enter Account Number: ");
            Long accountNumber = ValidateInput.validateLongInput(sc.nextLine());

            bankOperations.checkAccountNumberExists(accountNumber); //to check account number is valid

            System.out.println("Please Enter Password: ");
            String password = sc.nextLine();

            bankOperations.checkAccountNoAndPasswordMatch(accountNumber,password); //to check account number and password match

            System.out.println("Please Enter Amount to Withdraw: ");
            double amount = ValidateInput.validateDoubleInput(sc.nextLine());

            TransactionResponseDTO transactionResponse  =  bankOperations.withdrawMoney(accountNumber,amount);

            System.out.println("-----Amount Withdraw Successfully!-----");
            System.out.println(transactionResponse);
            System.out.println("===========================================");


        }catch (NoAccountDetailsPresentException|IncorrectPasswordException | InsufficientFundsException exception){
            System.out.println(exception.getMessage());
        }


    }

    public void checkAccountBalance() {
        try{
            bankOperations.checkAccountDetailsIsEmpty();//to check account exists

            System.out.println("Please Enter Account Number: ");
            Long accountNumber = ValidateInput.validateLongInput(sc.nextLine());

            bankOperations.checkAccountNumberExists(accountNumber); //to check account number is valid

            System.out.println("Please Enter Password: ");
            String password = sc.nextLine();

            bankOperations.checkAccountNoAndPasswordMatch(accountNumber,password); //to check account number and password match

            double accountBalance = bankOperations.getAccountBalance(accountNumber);//to get account balance

            System.out.println("-----Account Balance!-----");
            System.out.println("Account Number: "+accountNumber);
            System.out.println("Account Balance: "+accountBalance);
            System.out.println("===========================================");


        }catch (NoAccountDetailsPresentException|IncorrectPasswordException exception){
            System.out.println(exception.getMessage());
        }

        }

    public void viewTransactionHistory() {


        try{
            bankOperations.checkAccountDetailsIsEmpty();//to check account exists

            System.out.println("Please Enter Account Number: ");
            Long accountNumber = ValidateInput.validateLongInput(sc.nextLine());

            bankOperations.checkAccountNumberExists(accountNumber); //to check account number is valid

            System.out.println("Please Enter Password: ");
            String password = sc.nextLine();

            bankOperations.checkAccountNoAndPasswordMatch(accountNumber,password);

            List<TransactionHistoryResponseDTO> transactionHistoryResponseDTOList =  bankOperations.getTransactionHistory(accountNumber); //to get transaction history

            System.out.println("--------Transaction History--------");
            System.out.println("Account No  :"+accountNumber);
            System.out.println();

            int i=0;
            for(TransactionHistoryResponseDTO transactionHistoryResponseDTO : transactionHistoryResponseDTOList){
                System.out.println("#"+(i=i+1));
                System.out.println(transactionHistoryResponseDTO);
                System.out.println();
            }

            System.out.println("===========================================");


        }catch (NoAccountDetailsPresentException|IncorrectPasswordException exception){
            System.out.println(exception.getMessage());
        }
    }
}
