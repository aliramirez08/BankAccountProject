public class BankAccountTest {
    public static void main(String[] args) {
        CheckingAccount ca = new CheckingAccount();

        ca.setFirstName("Alice");
        ca.setLastName("Smith");
        ca.setAccountID(1001);
        ca.setInterestRate(1.5);

        ca.deposit(500.00);
        ca.displayAccount();

        ca.processWithdrawal(600.00); // triggers overdraft
        ca.displayAccount();

        ca.deposit(200.00);
        ca.processWithdrawal(50.00);
        ca.displayAccount();
    }
}
