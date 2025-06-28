import java.time.LocalDate;

public class AccountTest {
    public static void main(String[] args) {
        System.out.println("=== Banking System Test ===\n");
        
        try {
            Account account = new Account();
            
            // Test with given dates
            System.out.println("---Testing with given dates:");
            account.depositOnDate(1000, LocalDate.of(2025, 6, 25));
            account.depositOnDate(2000, LocalDate.of(2025, 6, 28));
            account.withdrawOnDate(500, LocalDate.of(2012, 6, 30));
            
            account.printStatement();
            
            
            // Test current date transactions
            Account account2 = new Account();
            System.out.println("---Testing with current dates:");
            account2.deposit(500);
            account2.withdraw(200);
            account2.deposit(100);
            
            account2.printStatement();
            System.out.println("Final balance: " + account2.getCurrentBalance());
            
            // Test exception handling  
             System.out.println("---Testing error handling:");
          
            try {
                account2.deposit(-100);
            } catch (IllegalArgumentException e) {
                System.out.println("Caught expected exception: " + e.getMessage());
            }
            
            try {
                account2.withdraw(1000);
            } catch (IllegalArgumentException e) {
                System.out.println("Caught expected exception: " + e.getMessage());
            }
            
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}