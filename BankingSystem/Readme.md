# **Banking System Project**

## **Overview**

The Banking System is a console-based application that simulates the basic functionality of a real-world banking system. It allows users to create savings and current accounts, deposit and withdraw funds, calculate interest, and view transaction histories. Additionally, the system includes an admin panel that provides an overview of all accounts in the system.

This project was developed in **Java**, utilizing object-oriented programming concepts to create classes for **BankAccount**, **SavingsAccount**, **CurrentAccount**, and **AdminPanel**. The system features secure login, transaction handling, and account management functionalities.

## **Key Features**

### 1. **Account Creation**
Users can create two types of accounts:
- **Savings Account**: Allows the user to earn interest on their balance.
- **Current Account**: Provides an overdraft limit for withdrawals beyond the balance.

### 2. **Account Operations**
- **Deposit**: Users can deposit funds into their account.
- **Withdraw**: Users can withdraw funds, with overdraft limits available for current accounts.
- **Interest Calculation**: Savings accounts earn interest based on the balance and a user-specified interest rate.
- **Transaction History**: Users can view a list of all transactions performed on their account (deposits, withdrawals, interest calculations).

### 3. **Authentication**
- **PIN-based Authentication**: Users must enter a PIN to log into their accounts. The application ensures that the correct PIN is entered before allowing access.

### 4. **Admin Panel**
- The admin panel is accessible only by an administrator and provides an overview of all accounts in the system.
- It lists account numbers, holders' names, and balances, offering a way for the admin to manage and monitor account details.

### 5. **User-Friendly Interface**
- The system provides a simple menu-based interface for users to choose from a variety of banking operations. Each option is clearly labeled for ease of navigation.

## **Technologies Used**
- **Java**: The core programming language used to implement the banking system.
- **Object-Oriented Programming (OOP)**: The application uses OOP principles such as inheritance, polymorphism, and encapsulation to define the banking system's functionality.
- **Data Structures**: Collections such as `HashMap` and `ArrayList` are used to store and manage accounts and transaction history.

## **Classes and Functionality**

### 1. **BankAccount (Abstract Class)**
- **Attributes**: `accountNumber`, `accountHolderName`, `balance`, `pin`.
- **Methods**: 
    - `deposit()`
    - `withdraw()`
    - `calculateInterest()`
    - `viewTransactionHistory()`
    - Abstract method `calculateInterest()` for subclasses to implement their own version of interest calculation.

### 2. **SavingsAccount (Derived Class)**
- **Additional Attribute**: `interestRate`.
- **Method**: `calculateInterest()`, which calculates and adds interest to the balance based on the interest rate.

### 3. **CurrentAccount (Derived Class)**
- **Additional Attribute**: `overdraftLimit`.
- **Method**: `withdraw()`, which allows withdrawals up to the overdraft limit.

### 4. **AdminPanel**
- **Methods**: Displays details of all accounts, including account number, holder’s name, and balance.

### 5. **BankingSystem (Main Class)**
- **Methods**: 
    - Manages user interaction, including account creation, login, and executing banking operations like deposit, withdraw, and interest calculation.
    - Contains a loop to handle the menu-based navigation.

## **How to Run the Application**

1. **Clone the repository** or **download** the project files to your local machine.
2. **Open the project** in your favorite Java IDE (e.g., IntelliJ IDEA, Eclipse).
3. **Compile and run** the `BankingSystem.java` file.
4. Follow the interactive menu to create accounts, log in, and perform operations like deposit, withdrawal, and interest calculations.

## **Future Enhancements**
- **Password Protection**: Instead of using a PIN, introduce a more secure password system.
- **External Database**: Store user data and transaction history in an external database (e.g., MySQL, PostgreSQL).
- **ATM Withdrawal**: Simulate ATM operations for deposit and withdrawal with a physical ATM interface.
- **Loan System**: Implement a loan system that allows users to borrow money and manage repayments.
- **Graphical User Interface (GUI)**: Convert the console-based application to a GUI-based one using JavaFX or Swing.

## **Conclusion**

This project is a basic simulation of a banking system that demonstrates how to model real-world entities using object-oriented principles. The system is designed to be modular, allowing for easy extensions and improvements in the future.
