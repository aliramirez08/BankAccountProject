/**
 * Represents a basic bank account with owner's information and balance.
 */
public class BankAccount {
    private String firstName;
    private String lastName;
    private int accountID;
    private double balance;

    public BankAccount() {
        this.balance = 0.0;
    }

    /**
     * Deposits a positive amount into the account.
     * @param amount the amount to deposit
     * @throws IllegalArgumentException if amount is not positive
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
    }

    /**
     * Withdraws a positive amount from the account.
     * @param amount the amount to withdraw
     * @throws IllegalArgumentException if amount is not positive
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
     * Prints account details including name, ID, and balance.
     */
    public void accountSummary() {
        System.out.println("Account Summary:");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Account ID: " + accountID);
        System.out.println("Balance: $" + String.format("%.2f", balance));
    }
}
