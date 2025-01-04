public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance, String pin, double interestRate) {
        super(accountNumber, accountHolderName, initialBalance, pin);
        this.interestRate = interestRate;
    }

    @Override
    public void calculateInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        transactionHistory.add("Interest Added: " + interest);
    }
}
