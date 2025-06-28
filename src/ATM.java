import java.util.Scanner;

public class ATM {
    private Account account;
    private Scanner scanner;
    
    public ATM() {
        this.account = new Account();
        this.scanner = new Scanner(System.in);
    }
    
    public static void main(String[] args) {
        ATM app = new ATM();
        app.run();
    }
    
    public void run() {
        System.out.println("===Welcome to Banking System===");
        System.out.println("Current Balance: $" + account.getCurrentBalance());
        
        boolean continueRunning = true;
        while (continueRunning) {
            displayMenu();
            int choice = getUserChoice();
            continueRunning = processChoice(choice);
        }
        
        System.out.println("Thank you for using Banking System!");
        scanner.close();
    }
    
    private void displayMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. View Statement");
        System.out.println("4. Exit");
        System.out.print("Choose option (1-4): ");
    }
    
    private int getUserChoice() {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice >= 1 && choice <= 4) {
                    return choice;
                }
                System.out.print("Please enter 1-4: ");
            } catch (NumberFormatException e) {
                System.out.print("Please enter a number: ");
            }
        }
    }
    
    private boolean processChoice(int choice) {
        switch (choice) {
            case 1:
                handleDeposit();
                return true;
            case 2:
                handleWithdraw();
                return true;
            case 3:
                handleStatement();
                return true;
            case 4:
                return false;
            default:
                return true;
        }
    }
    
    private void handleDeposit() {
        System.out.print("Enter deposit amount: $");
        int amount = getValidAmount();
        
        try {
            account.deposit(amount);
            System.out.println("Deposited: $" + amount);
            System.out.println("New Balance: $" + account.getCurrentBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void handleWithdraw() {
        System.out.print("Enter withdrawal amount: $");
        int amount = getValidAmount();
        
        try {
            account.withdraw(amount);
            System.out.println("Withdrawn: $" + amount);
            System.out.println("New Balance: $" + account.getCurrentBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void handleStatement() {
        System.out.println("\n--- ACCOUNT STATEMENT ---");
        if (account.getTransactionCount() == 0) {
            System.out.println("No transactions found.");
        } else {
            account.printStatement();
        }
        System.out.println("Current Balance: $" + account.getCurrentBalance());
    }
    
    private int getValidAmount() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                if (input.startsWith("$")) {
                    input = input.substring(1);
                }
                int amount = Integer.parseInt(input);
                if (amount > 0) {
                    return amount;
                }
                System.out.print("Amount must be positive: $");
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: $");
            }
        }
    }
}