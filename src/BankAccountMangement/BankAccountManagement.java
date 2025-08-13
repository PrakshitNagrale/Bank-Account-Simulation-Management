package BankAccountMangement;

import java.util.Scanner;

public class BankAccountManagement {

    Scanner sc;
    BankAccountInputController bankAccountController;

    public BankAccountManagement() {
        this.sc = new Scanner(System.in);
        this.bankAccountController = new BankAccountInputController(sc);
    }

    public void startBankApplication(){

        System.out.println("====================================");
        System.out.println("    WELCOME TO BANKING SERVICE     ");
        System.out.println("====================================");

        boolean keepRunning = true;

        while(keepRunning){

            try{
                System.out.println("1. Register New Customer");
                System.out.println("2. Open New Bank Account");
                System.out.println("3. View Customer Account Details");
                System.out.println("4. Deposit Money");
                System.out.println("5. Withdraw Money");
                System.out.println("6. Check Account Balance");
                System.out.println("7. View Transaction History");
                System.out.println("8 Exit Application");
                System.out.println("====================================");

                System.out.println("Please select an operation to perform (1-8): ");

                String input = sc.nextLine();
                int operation = Integer.parseInt(input);


                switch (operation){
                    case 1:
                        bankAccountController.registerCustomer();
                        break;
                    case 2:
                        bankAccountController.createNewAccount();
                        break;
                    case 3:
                        bankAccountController.ViewCustomerAccountDetails();
                        break;
                    case 4:
                         bankAccountController.depositMoney();
                         break;
                    case 5:
                        bankAccountController.withdrawMoney();
                        break;
                    case 6:
                        bankAccountController.checkAccountBalance();
                        break;
                    case 7:
                        bankAccountController.viewTransactionHistory();
                        break;


                    case 8:
                        keepRunning = false;
                        System.out.println("-----Banking Application Terminated-----");
                        break;

                    default:
                        System.out.println("Invalid Operation! Please Enter valid operation!");

                }

            }catch (NumberFormatException e){
                System.out.println("Invalid Input!. Please enter a valid operation (1-8)");
                System.out.println("----------------------------------------------------");            }



        }
    }
}
