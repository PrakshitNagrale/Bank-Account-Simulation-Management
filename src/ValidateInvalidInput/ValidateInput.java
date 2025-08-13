package ValidateInvalidInput;

import exceptions.IncorrectPasswordException;
import exceptions.MaxAttemptExceededException;
import models.AccountType;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Scanner;

public class ValidateInput {



    public static Long validateLongInput(String input){

        int attempt = 0;    //initializing variable for max limit

        while (attempt<3){   // a loop for retry limit

            try{
               return Long.parseLong(input);//converting string input to integer and returning back

            }catch (NumberFormatException exception){  //if the user put character then it will catch here

                attempt = attempt+1; //increment attempt
                System.out.println("Invalid Input!");

                if(attempt<3){
                    System.out.println("Please enter Numeric Value");
                    System.out.println("Please Try again: ");
                    Scanner sc = new Scanner(System.in);
                    input = sc.nextLine();
                }
            }
        }

        //if the limit exceed throwing exception
        throw new MaxAttemptExceededException("Max Attempt Exceeded! Returning to Main Menu");

    }


    //to validate string input with retry limit ,it allows string with number
    public static String validateStringInput(String input){
        Scanner sc = new Scanner(System.in);

        int attempt = 0; // initializing variable for max limit

        while(attempt < 3){// a loop for retry limit

            // input allow letters, numbers, and spaces and reject empty input
            if(!input.isEmpty() && input.matches("[a-zA-Z0-9 ]+")){
               return input;
           }

           else{
               attempt = attempt+1;

               if(attempt < 3){
                   System.out.println("Please enter only letters, numbers, and spaces");
                   System.out.println("Try again: ");
                   input = sc.nextLine();
               }

           }
        }

        throw new MaxAttemptExceededException("Max Attempt Exceeded! Returning to Main Menu");

    }

    //to validate double input with retry
    public static Double validateDoubleInput(String input) {

        int attempt = 0;

        while(attempt < 3){

          try{
              return Double.parseDouble(input);
          } catch (NumberFormatException exception) {

              System.out.println("Invalid Input!");
              attempt = attempt+1;
              if(attempt < 3){
                  System.out.println("Please Enter Numeric value ");
                  System.out.println("Try again: ");
                  Scanner sc = new Scanner(System.in);
                  input = sc.nextLine();
              }
          }

        }
        //throw max limit exceed
        throw  new MaxAttemptExceededException("Max Attempt Exceeded! Returning to Main Menu");

    }

    public static AccountType validateAccountTypeFromInput(String input) {

       int  attempt = 0;

        while(attempt < 3){
            try{
                int value = Integer.parseInt(input);

                switch (value){

                    case 1: return AccountType.SAVING;

                    case 2: return AccountType.CURRENT;

                    case 3: return AccountType.FIXED_DEPOSIT;

                    default:
                        System.out.println("Invalid Input!");
                        attempt = attempt+1;
                        if(attempt < 3){
                            System.out.println("Please select from 1,2,3 :");
                            Scanner sc = new Scanner(System.in);
                            input = sc.nextLine();
                        }

                }
            } catch (NumberFormatException e) {
                attempt = attempt+1;
                System.out.println("Invalid Input!");
                if(attempt < 3){
                    System.out.println("Please select from 1,2,3 :");
                    Scanner sc = new Scanner(System.in);
                    input = sc.nextLine();
                }

            }
        }
        throw new MaxAttemptExceededException("Max Attempt Exceeded! Returning to Main Menu");
    }

    //to store the hash password
    public static String  hashPassword(String password) {

          String hashedPassword  =   BCrypt.hashpw(password,BCrypt.gensalt()); //hashing password with gen salt()

        return hashedPassword;
    }

    public static String takePasswordInput(Scanner sc) {

        System.out.println("Please Set Your Password: ");
        String password = sc.nextLine();

        System.out.println("Please Re-Enter Your Password: ");
        String rePassword = sc.nextLine();

        if(password.equals(rePassword)){
            return password;
        }
        throw new IncorrectPasswordException("Password did not match! Please try again!");
    }
}
