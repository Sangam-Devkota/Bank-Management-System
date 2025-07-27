public class Transaction {
    public void transfer(Account fromAccount, Account toAccount, int amount) {
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
}

