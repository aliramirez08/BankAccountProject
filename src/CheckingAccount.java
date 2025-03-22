public class CheckingAccount extends BankAccount {
    private double interestRate;

    public CheckingAccount() {
        super();
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void processWithdrawal(double amount) {
        if (amount > 0) {
            double currentBalance = getBalance();
            if (amount > currentBalance) {
                // Overdraft with fee
                super.withdrawal(amount + 30);
                System.out.println("Overdraft! A $30 fee has been applied.");
            } else {
                super.withdrawal(amount);
            }
        }
    }

    public void displayAccount() {
        super.accountSummary();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
