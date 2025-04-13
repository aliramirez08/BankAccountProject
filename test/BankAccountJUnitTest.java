import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BankAccountJUnitTest {

    @Test
    public void testDeposit() {
        BankAccount acc = new BankAccount();
        acc.deposit(100.0);
        assertEquals(100.0, acc.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawal() {
        BankAccount acc = new BankAccount();
        acc.deposit(200.0);
        acc.withdrawal(50.0);
        assertEquals(150.0, acc.getBalance(), 0.001);
    }

    @Test
    public void testNegativeDepositThrowsException() {
        BankAccount acc = new BankAccount();
        assertThrows(IllegalArgumentException.class, () -> {
            acc.deposit(-100.0);
        });
    }

    @Test
    public void testOverdraftChargesFee() {
        CheckingAccount acc = new CheckingAccount();
        acc.deposit(100.0);
        acc.processWithdrawal(150.0);
        assertEquals(-80.0, acc.getBalance(), 0.001); // 150 + 30 fee
    }
}
