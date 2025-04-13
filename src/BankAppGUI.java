import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankAppGUI {
    private CheckingAccount account;

    public BankAppGUI() {
        account = new CheckingAccount();
        account.setFirstName("Alicia");
        account.setLastName("Ramirez");
        account.setAccountID(1001);

        JFrame frame = new JFrame("Bank Account Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JTextArea display = new JTextArea("Account Summary: \n");
        display.setEditable(false);

        JTextField amountField = new JTextField(10);
        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");

        depositBtn.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                account.deposit(amount);
                display.setText(account.accountSummary());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Enter a valid amount.");
            }
        });

        withdrawBtn.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                account.withdrawal(amount);
                display.setText(account.accountSummary());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Enter a valid amount.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Amount:"));
        panel.add(amountField);
        panel.add(depositBtn);
        panel.add(withdrawBtn);

        frame.getContentPane().add(BorderLayout.NORTH, display);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new BankAppGUI();
    }
}
