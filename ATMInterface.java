import java.util.Scanner;

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM();

        System.out.println("Welcome to the ATM!");

        while (true) {
            System.out.println("\nPlease enter your account number: ");
            String accountNumber = scanner.nextLine();
            System.out.println("Please enter your PIN: ");
            String pin = scanner.nextLine();

            Account account = atm.authenticate(accountNumber, pin);

            if (account != null) {
                System.out.println("Authentication successful. Welcome, " + accountNumber + "!");
                performTransaction(scanner, atm, account);
            } else {
                System.out.println("Authentication failed. Invalid account number or PIN.");
            }
        }
    }

    private static void performTransaction(Scanner scanner, ATM atm, Account account) {
        while (true) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your account balance: $" + account.getBalance());
                    break;
                case 2:
                    System.out.println("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(account, withdrawAmount);
                    break;
                case 3:
                    System.out.println("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(account, depositAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}