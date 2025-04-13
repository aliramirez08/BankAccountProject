/**
 * A checking account that supports overdraft with a fixed fee and interest rate.
 */
public class CheckingAccount extends BankAccount {
    private double interestRate;

    public CheckingAccount() {
        super();
    }

    /**
     * Sets the interest rate for this account.
     * @param interestRate the interest rate as a percentage
     */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * Gets the interest rate for this account.
     * @return the interest rate
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * Processes a withdrawal and applies a $30 fee if it results in an overdraft.
     * @param amount the amount to withdraw
     * @throws IllegalArgumentException if amount is not positive
     */
    public void processWithdrawal(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }

        double currentBalance = getBalance();
        if (amount > currentBalance) {
            // Overdraft: apply fee
            super.withdrawal(amount + 30);
            System.out.println("Overdraft! A $30 fee has been applied.");
        } else {
            super.withdrawal(amount);
        }
    }

    /**
     * Displays account summary including interest rate.
     */
    public void displayAccount() {
        super.accountSummary();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
