import java.util.*;

public class BankingSystem {
    private static Map<String, BankAccount> accounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static BankAccount loggedInAccount = null;

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Banking System ---");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Login");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Check Balance");
            System.out.println("7. Calculate Interest");
            System.out.println("8. View Transaction History");
            System.out.println("9. Admin Panel");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createSavingsAccount();
                    break;
                case 2:
                    createCurrentAccount();
                    break;
                case 3:
                    login();
                    break;
                case 4:
                    if (loggedInAccount != null) performDeposit();
                    break;
                case 5:
                    if (loggedInAccount != null) performWithdrawal();
                    break;
                case 6:
                    checkBalance();
                    break;
                case 7:
                    calculateInterest();
                    break;
                case 8:
                    viewTransactionHistory();
                    break;
                case 9:
                    Admin.adminPanel(accounts);
                    break;
                case 10:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 10);
    }

    private static void createSavingsAccount() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.next();
        System.out.print("Enter Account Holder Name: ");
        String accountHolderName = scanner.next();
        System.out.print("Enter Initial Balance: ");
        double initialBalance = scanner.nextDouble();
        System.out.print("Enter PIN: ");
        String pin = scanner.next();
        System.out.print("Enter Interest Rate: ");
        double interestRate = scanner.nextDouble();

        SavingsAccount account = new SavingsAccount(accountNumber, accountHolderName, initialBalance, pin, interestRate);
        accounts.put(accountNumber, account);
        System.out.println("Savings Account created successfully.");
    }

    private static void createCurrentAccount() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.next();
        System.out.print("Enter Account Holder Name: ");
        String accountHolderName = scanner.next();
        System.out.print("Enter Initial Balance: ");
        double initialBalance = scanner.nextDouble();
        System.out.print("Enter PIN: ");
        String pin = scanner.next();
        System.out.print("Enter Overdraft Limit: ");
        double overdraftLimit = scanner.nextDouble();

        CurrentAccount account = new CurrentAccount(accountNumber, accountHolderName, initialBalance, pin, overdraftLimit);
        accounts.put(accountNumber, account);
        System.out.println("Current Account created successfully.");
    }

    private static void login() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.next();
        System.out.print("Enter PIN: ");
        String pin = scanner.next();

        BankAccount account = accounts.get(accountNumber);
        if (account != null && account.authenticate(pin)) {
            loggedInAccount = account;
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    private static void performDeposit() {
        System.out.print("Enter Amount to Deposit: ");
        double amount = scanner.nextDouble();
        loggedInAccount.deposit(amount);
        System.out.println("Deposited: " + amount);
    }

    private static void performWithdrawal() {
        System.out.print("Enter Amount to Withdraw: ");
        double amount = scanner.nextDouble();
        loggedInAccount.withdraw(amount);
        System.out.println("Withdrawn: " + amount);
    }

    private static void checkBalance() {
        if (loggedInAccount != null) {
            System.out.println("Balance: " + loggedInAccount.getBalance());
        } else {
            System.out.println("No account logged in.");
        }
    }

    private static void calculateInterest() {
        if (loggedInAccount != null) {
            loggedInAccount.calculateInterest();
        } else {
            System.out.println("No account logged in.");
        }
    }

    private static void viewTransactionHistory() {
        if (loggedInAccount != null) {
            System.out.println("Transaction History: " + loggedInAccount.getTransactionHistory());
        } else {
            System.out.println("No account logged in.");
        }
    }
}
