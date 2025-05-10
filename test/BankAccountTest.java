public class BankAccountTest {

    public static void main(String[] args) {
        CheckingAccount ca = new CheckingAccount();

        ca.setFirstName("John");
        ca.setLastName("Doe");
        ca.setAccountID(12345);
        ca.setInterestRate(1);

        ca.deposit(500.00);
        ca.displayAccount();

        ca.processWithdrawal(500.00); // triggers overdraft
        ca.displayAccount();

        ca.deposit(200.00);
        // Assuming the intention is to process a withdrawal instead of displaying it
                ca.processWithdrawal(50.00);
        ca.displayAccount();
    }
}