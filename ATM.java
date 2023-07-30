import java.util.HashMap;
import java.util.Map;

public class ATM {
    private Map<String, Account> accounts;

    public ATM() {
        accounts = new HashMap<>();
        // Adding some dummy accounts for testing purposes
        accounts.put("123456", new Account("123456", "1234", 1000.0));
        accounts.put("654321", new Account("654321", "4321", 2000.0));
    }

    public Account authenticate(String accountNumber, String pin) {
        Account account = accounts.get(accountNumber);
        if (account != null && account.getPin().equals(pin)) {
            return account;
        }
        return null;
    }

    public void withdraw(Account account, double amount) {
        if (amount > 0 && amount <= account.getBalance()) {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Withdrawal successful. Remaining balance: $" + account.getBalance());
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    public void deposit(Account account, double amount) {
        if (amount > 0) {
            account.setBalance(account.getBalance() + amount);
            System.out.println("Deposit successful. Current balance: $" + account.getBalance());
        } else {
            System.out.println("Invalid amount.");
        }
    }
}