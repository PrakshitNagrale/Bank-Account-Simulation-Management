## Bank Account Management System 

- A **menu-driven Java console application** for managing bank customers, accounts, and transactions.  
- It allows customer registration, account creation, deposits, withdrawals, balance inquiries, and transaction history viewing — all with secure password handling and input validation.

---

## Features

- **Customer Registration** – Create new customers with unique IDs.
- **Account Opening** – Link accounts to existing customers with account type selection.
- **Deposit / Withdraw** – Perform transactions with real-time balance updates.
- **Balance Inquiry** – View account balance after authentication.
- **Transaction History** – Display complete deposit/withdrawal history.
- **Password Security** – Uses BCrypt hashing for secure password storage.
- **Input Validation** – Rejects invalid or malformed user inputs.
- **Custom Exceptions** – Clear and meaningful error handling.



## Technologies Used

- **Java 17+** (compatible with Java 8+)
- **jBCrypt** for password hashing
- **OOP Principles** – Encapsulation, Abstraction, Polymorphism
- **LocalDateTime API** for timestamps
- **Custom Exceptions** for clear error reporting

## Menu Options

1. Register New Customer
2. Open New Bank Account
3. View Customer Account Details
4. Deposit Money
5. Withdraw Money
6. Check Account Balance
7. View Transaction History
8. Exit Application


## Example Output

 - ====================================
-  WELCOME TO BANKING SERVICE     
- ====================================
1. Register New Customer
2. Open New Bank Account
3. View Customer Account Details
4. Deposit Money
5. Withdraw Money
6. Check Account Balance
7. View Transaction History 
8.  Exit Application
  
====================================
  -  Please select an operation to perform (1-8):
1
  -  Please Enter Customer Id:
01
   - Please Enter Customer Name:
Sahil
   - Please Enter Customer Phone No:
   876459998
   - Please Enter Customer Address:
   Near MDR mall chandrpur Maharashtra 442402

   ----Customer Registered Successfully!----
  -  CustomerId: 1
  -  Customer Name: Sahil
   - PhoneNo: 876459998
   - Address: Near MDR mall Delhi India
 
===========================================

1. Register New Customer
2. Open New Bank Account
3. View Customer Account Details
4. Deposit Money
5. Withdraw Money
6. Check Account Balance
7. View Transaction History 
8.  Exit Application

====================================
  -  Please select an operation to perform (1-8):
   2
   - Please Enter Account Number:
   112345
   - Please Enter Customer Id:
   01
   - Please Enter Account Balance:
   1000
   - Please Select Account Type:
      -  1.SAVING
      - 2.CURRENT
       - 3.FIXED_DEPOSIT :
1
   - Please Set Your Password:
   1234
  -  Please Re-Enter Your Password:
   1234

   ----New Account Created Successfully!----
  -  Account No: 112345
   - Customer Id: 1
   - Customer Name: Sahil
   - Account Type: SAVING
   - Current Balance: 1000.0
   - Last Transaction: No transactions yet!
   
===========================================
1. Register New Customer
2. Open New Bank Account
3. View Customer Account Details
4. Deposit Money
5. Withdraw Money
6. Check Account Balance
7. View Transaction History
8. Exit Application

   ====================================
  -  Please select an operation to perform (1-8):
   4
   - Please Enter Account Number:
   112345
   - Please Enter Password:
   1234
   - Please Enter Amount to deposit:
   1000

   -----Amount deposited Successfully!-----
  -  Transaction Type: DEPOSIT
   - Amount DEPOSIT: 1000.0
   - Updated Balance: 2000.0
   - Transaction Id: 4229c0d1-8afe-4176-8d89-b8804248f162
   - Transaction Time: 14-Aug-2025 03:45 am
   
===========================================
1. Register New Customer
2. Open New Bank Account
3. View Customer Account Details
4. Deposit Money
5. Withdraw Money
6. Check Account Balance
7. View Transaction History 
8. Exit Application

 ====================================
   - Please select an operation to perform (1-8):
   7
   - Please Enter Account Number:
112345
   - Please Enter Password:
1234

   
  --------Transaction History--------
  -  Account No  :112345

#1
- Transaction Type :DEPOSIT
- Amount           :1000.0
- Updated Balance  :2000.0
- Transaction Id   :4229c0d1-8afe-4176-8d89-b8804248f162
- Date & Time      :14-Aug-2025 03:45 am

===========================================
1. Register New Customer
2. Open New Bank Account
3. View Customer Account Details
4. Deposit Money
5. Withdraw Money
6. Check Account Balance
7. View Transaction History 
8. Exit Application

 ====================================
   - Please select an operation to perform (1-8):
   8
  
-----Banking Application Terminated-----


