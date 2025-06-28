import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Account implements AccountService {
    private int currentBalance;
    private ArrayList<Transaction> transactions;
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public Account() {
        this.currentBalance = 0;
        this.transactions = new ArrayList<>();
    }
    
    @Override
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        
        currentBalance += amount;
        Transaction transaction = new Transaction(LocalDate.now(), amount, currentBalance);
        transactions.add(transaction);
    }
    
    @Override
    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        
        if (amount > currentBalance) {
            throw new IllegalArgumentException("Insufficient money for this operation. Current balance: " + currentBalance);
        }
        
        currentBalance -= amount;
        Transaction transaction = new Transaction(LocalDate.now(), -amount, currentBalance);
        transactions.add(transaction);
    }
    
    @Override
    public void printStatement() {
        System.out.println("Date || Amount || Balance");
        
        int n= transactions.size();
        for (int i = n - 1; i >= 0; i--) {
            Transaction transaction = transactions.get(i);
            String formattedDate = transaction.getDate().format(DATE_FORMAT);
            System.out.println(formattedDate + " || " + transaction.getAmount() + " || " + transaction.getBalance());
        }
    }
    
    public int getTransactionCount() {
        return transactions.size();
    }
    
    public int getCurrentBalance() {
        return currentBalance;
    }
    
    public void depositOnDate(int amount, LocalDate date) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        
        currentBalance += amount;
        Transaction transaction = new Transaction(date, amount, currentBalance);
        transactions.add(transaction);
    }
    
    public void withdrawOnDate(int amount, LocalDate date) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        
        if (amount > currentBalance) {
            throw new IllegalArgumentException("Insufficient funds. Current balance: " + currentBalance);
        }
        
        currentBalance -= amount;
        Transaction transaction = new Transaction(date, -amount, currentBalance);
        transactions.add(transaction);
    }
}