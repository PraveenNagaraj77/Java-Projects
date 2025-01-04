import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {
    protected String accountNumber;
    protected String accountHolderName;
    protected double balance;
    protected String pin;
    protected List<String> transactionHistory;

    public BankAccount(String accountNumber, String accountHolderName, double initialBalance, String pin) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.pin = pin;
        this.transactionHistory = new ArrayList<>();
    }

    public boolean authenticate(String pin) {
        return this.pin.equals(pin);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount);
        } else {
            transactionHistory.add("Failed Withdrawal Attempt: " + amount);
        }
    }

    public double getBalance() {
        return balance;
    }

    public void calculateInterest() {
        // Default implementation, can be overridden
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
}
