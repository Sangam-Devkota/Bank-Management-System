import javax.swing.JOptionPane;
public class Account extends Customer {
    private int accountNumber;
    private int balance;

    public Account(String firstName, String lastName, int accountNumber, int balance) {
        super(firstName, lastName);
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public boolean withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        JOptionPane.showMessageDialog(null, "Insufficient balance. Withdrawal failed.");
        return false;
    }
}
