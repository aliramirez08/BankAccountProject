/**
 * Represents a checking account that supports overdraft with fees and includes an interest rate.
 */
public class CheckingAccount extends BankAccount {
    private double interestRate;

    /**
     * Constructs a new CheckingAccount and initializes the balance to zero.
     */
    public CheckingAccount() {
        super();
    }

    /**
     * Sets the interest rate for the checking account.
     * @param interestRate The interest rate as a percentage (e.g., 1.5 for 1.5%)
     * @throws IllegalArgumentException if the interest rate is negative
     */
    public void setInterestRate(double interestRate) {
        if (interestRate < 0) {
            throw new IllegalArgumentException("Interest rate must not be negative.");
        }
        this.interestRate = interestRate;
    }

    /**
     * Returns the interest rate.
     * @return interest rate in percentage
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * Processes a withdrawal. If the withdrawal amount exceeds the balance,
     * it applies a $30 overdraft fee.
     * @param amount Amount to withdraw
     * @throws IllegalArgumentException if amount is not positive
     */
    public void processWithdrawal(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }

        double currentBalance = getBalance();

        if (amount > currentBalance) {
            super.withdrawal(amount + 30); // Apply overdraft and fee
            System.out.println("Overdraft! A $30 fee has been applied.");
        } else {
            super.withdrawal(amount);
        }
    }

    /**
     * Displays account summary along with interest rate.
     */
    public void displayAccount() {
        super.accountSummary();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
