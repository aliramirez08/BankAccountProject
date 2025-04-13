/**
 * A simple test class to demonstrate usage of BankAccount and CheckingAccount.
 */
public class BankAccountTest {
    public static void main(String[] args) {
        // Create a checking account
        CheckingAccount account = new CheckingAccount();

        account.setFirstName("Alice");
        account.setLastName("Ramirez");
        account.setAccountID(12345);
        account.setInterestRate(1.25);

        System.out.println("Initial deposit of $500.00");
        account.deposit(500.00);
        account.displayAccount();

        System.out.println("\nWithdrawing $600.00 (should trigger overdraft)");
        account.processWithdrawal(600.00);
        account.displayAccount();

        System.out.println("\nDepositing $200.00");
        account.deposit(200.00);
        account.displayAccount();

        System.out.println("\nWithdrawing $50.00 (normal withdrawal)");
        account.processWithdrawal(50.00);
        account.displayAccount();
    }
}
