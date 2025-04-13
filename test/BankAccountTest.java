import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void testInitialBalanceIsZero() {
        BankAccount account = new BankAccount("Alicia", "Ramirez", 1001);
        assertEquals(0.0, account.getBalance(), 0.001);
    }

    @Test
    void testDeposit() {
        BankAccount account = new BankAccount("Alicia", "Ramirez", 1001);
        account.deposit(500.0);
        assertEquals(500.0, account.getBalance(), 0.001);
    }

    @Test
    void testWithdraw() {
        BankAccount account = new BankAccount("Alicia", "Ramirez", 1001);
        account.deposit(500.0);
        account.withdrawal(200.0);
        assertEquals(300.0, account.getBalance(), 0.001);
    }

    @Test
    void testNegativeDepositThrowsException() {
        BankAccount account = new BankAccount("Alicia", "Ramirez", 1001);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100));
    }

    @Test
    void testNegativeWithdrawalThrowsException() {
        BankAccount account = new BankAccount("Alicia", "Ramirez", 1001);
        assertThrows(IllegalArgumentException.class, () -> account.withdrawal(-50));
    }

    @Test
    void testOverdraftProcessingInCheckingAccount() {
        CheckingAccount checking = new CheckingAccount("Alicia", "Ramirez", 2001, 0.02);
        checking.deposit(100);
        checking.processWithdrawal(150); // should allow overdraft and apply $30 fee
        assertEquals(-80.0, checking.getBalance(), 0.001); // -50 - 30 overdraft fee
    }

    @Test
    void testInterestRateDisplay() {
        CheckingAccount checking = new CheckingAccount("Alicia", "Ramirez", 2001, 0.03);
        String summary = checking.displayAccount();
        assertTrue(summary.contains("Interest Rate: 0.03"));
    }
}
