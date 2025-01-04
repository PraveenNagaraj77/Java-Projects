import java.util.Map;

public class Admin {
    public static void adminPanel(Map<String, BankAccount> accounts) {
        // Admin functionality: List all accounts
        System.out.println("\n--- Admin Panel ---");
        for (Map.Entry<String, BankAccount> entry : accounts.entrySet()) {
            BankAccount account = entry.getValue();
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Holder: " + account.getAccountHolderName());
            System.out.println("Balance: " + account.getBalance());
        }
    }
}
