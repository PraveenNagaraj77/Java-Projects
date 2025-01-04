public class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String accountHolderName, double initialBalance, String pin, double overdraftLimit) {
        super(accountNumber, accountHolderName, initialBalance, pin);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount >= -overdraftLimit)) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount + " with overdraft");
        } else {
            transactionHistory.add("Failed Withdrawal Attempt: " + amount);
        }
    }

    @Override
    public void calculateInterest() {
        // No interest for current accounts
        transactionHistory.add("No interest for current accounts.");
    }
}
