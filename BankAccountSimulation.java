import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    // Account fields.
    private String accountHolder;
    private String accountNumber;
    private double balance;
    private ArrayList<String> transactionHistory;

    // Constructor to create a bank account.
    public BankAccount(String accountHolder, String accountNumber, double openingBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
        this.transactionHistory = new ArrayList<>();

        transactionHistory.add(String.format("Opening balance: +%.2f", openingBalance));
    }

    // Deposit money into the account.
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
            return;
        }

        balance += amount;
        transactionHistory.add(String.format("Deposit: +%.2f | Balance: %.2f", amount, balance));
        System.out.printf("Deposit successful. Current balance: %.2f%n", balance);
    }

    // Withdraw money after checking the available balance.
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
            return;
        }

        if (amount > balance) {
            System.out.println("Withdrawal failed: Insufficient balance.");
            transactionHistory.add(String.format(
                "Withdrawal failed: %.2f | Balance: %.2f", amount, balance
            ));
            return;
        }

        balance -= amount;
        transactionHistory.add(String.format("Withdrawal: -%.2f | Balance: %.2f", amount, balance));
        System.out.printf("Withdrawal successful. Current balance: %.2f%n", balance);
    }

    // Display the current account balance.
    public void checkBalance() {
        System.out.printf("Current balance: %.2f%n", balance);
    }

    // Print all transactions.
    public void printTransactionHistory() {
        System.out.println("\n============= TRANSACTION HISTORY =============");
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("-----------------------------------------------");

        for (int i = 0; i < transactionHistory.size(); i++) {
            System.out.println((i + 1) + ". " + transactionHistory.get(i));
        }

        System.out.println("-----------------------------------------------");
        System.out.printf("Final Balance  : %.2f%n", balance);
        System.out.println("===============================================");
    }
}

public class BankAccountSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get account details from the user.
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();

        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter opening balance: ");
        double openingBalance = scanner.nextDouble();

        while (openingBalance < 0) {
            System.out.print("Opening balance cannot be negative. Enter again: ");
            openingBalance = scanner.nextDouble();
        }

        // Create a BankAccount object.
        BankAccount account = new BankAccount(name, accountNumber, openingBalance);

        int choice;

        // Menu-driven bank account simulation.
        do {
            System.out.println("\n============= BANK MENU =============");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    System.out.println("Exiting bank application...");
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1 to 4.");
            }
        } while (choice != 4);

        // Print transaction history when the program ends.
        account.printTransactionHistory();

        scanner.close();
    }
}
