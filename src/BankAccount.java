/**
 * Represents a basic bank account with the ability to deposit and withdraw funds.
 * Provides basic account details and summary reporting.
 */
public class BankAccount {
    private String firstName;
    private String lastName;
    private int accountID;
    private double balance;

    /**
     * Constructs a bank account with a balance initialized to zero.
     */
    public BankAccount() {
        this.balance = 0.0;
    }

    /**
     * Deposits the given amount into the account.
     * @param amount The amount to deposit; must be positive.
     * @throws IllegalArgumentException if the amount is less than or equal to zero.
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
    }

    /**
     * Withdraws the given amount from the account.
     * @param amount The amount to withdraw; must be positive.
     * @throws IllegalArgumentException if the amount is less than or equal to zero.
     */
    public void withdrawal(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        balance -= amount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * Prints a summary of the bank account's information.
     */
    public void accountSummary() {
        System.out.println("Account Summary:");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Account ID: " + accountID);
        System.out.println("Balance: $" + String.format("%.2f", balance));
    }
}
