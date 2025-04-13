/**
 * Test class for CheckingAccount functionality.
 */
public class BankAccountTest {
    public static void main(String[] args) {
        CheckingAccount ca = new CheckingAccount();

        // Set account details
        ca.setFirstName("Alice");
        ca.setLastName("Smith");
        ca.setAccountID(1001);
        ca.setInterestRate(1.5);

        // First deposit
        ca.deposit(500.00);
        ca.displayAccount();

        // Overdraft withdrawal - should apply fee
        try {
            ca.processWithdrawal(600.00); // triggers overdraft
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        ca.displayAccount();

        // Normal deposit and withdrawal
        ca.deposit(200.00);
        try {
            ca.processWithdrawal(50.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        ca.displayAccount();
    }
}
