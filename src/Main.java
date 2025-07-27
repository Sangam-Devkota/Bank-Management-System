/*public class Main {
    public static void main(String[] args) {
        Account account1 = new Account("Jeffrey", "Ting", 1, 2000);
        Account account2 = new Account("Hiran", "Patel", 2, 1000);

        System.out.println("Initial balance of account1: " + account1.getBalance());
        System.out.println("Initial balance of account2: " + account2.getBalance());

        account1.deposit(250);
        System.out.println("Balance of account1 after deposit: " + account1.getBalance());

        account2.withdraw(500);
        System.out.println("Balance of account2 after withdrawal: " + account2.getBalance());

        Transaction transaction = new Transaction();
        transaction.transfer(account1, account2, 250);

        System.out.println("Balance of account1 after transfer: " + account1.getBalance());
        System.out.println("Balance of account2 after transfer: " + account2.getBalance());
    }
}*/
import java.util.LinkedList;

/*public class Main {
    public static void main(String[] args) {
        // File path to the CSV file
        String file = "C:\\Users\\User\\eclipse-workspace\\CourseWork\\src\\Accounts.csv"; // Modify this path based on your actual file location

        // Create an object of ReadAccounts class
        ReadAccounts readAccounts = new ReadAccounts(file);

        // Create LinkedLists using the ReadAccounts class methods
        LinkedList<String> firstNames = readAccounts.getFirstNames();
        LinkedList<String> lastNames = readAccounts.getLastNames();
        LinkedList<Integer> accountList = readAccounts.getAccounts();
        LinkedList<Integer> balanceList = readAccounts.getBalances();

        // Create a LinkedList of Account objects
        LinkedList<Account> accounts = new LinkedList<>();

        // Populate the accounts LinkedList using a loop
        for (int i = 0; i < firstNames.size(); i++) {
            accounts.add(new Account(firstNames.get(i), lastNames.get(i), accountList.get(i), balanceList.get(i)));
            System.out.println(accounts.get(i));
        }

        // Test the accounts (as in Part 1)
        // Example of accessing and performing operations on the accounts
        Account acc1 = accounts.get(0);
        Account acc2 = accounts.get(2);
        System.out.println("Balance of "+ firstNames.get(0)+" in initial stage: " + acc1.getBalance());
        System.out.println("Balance of "+ firstNames.get(2)+" in initial stage: " + acc2.getBalance());
        // Example: Deposit, withdraw, and transfer
        acc1.deposit(500);
        acc2.withdraw(200);
        System.out.println("Balance of account1 in deposit: " + acc1.getBalance());
        System.out.println("Balance of account2 in withdraw: " + acc2.getBalance());

        Transaction transaction = new Transaction();
        transaction.transfer(acc1, acc2, 100);

        // Print account balances after transactions
        System.out.println("Balance of account1 after transfer: " + acc1.getBalance());
        System.out.println("Balance of account2 after transfer: " + acc2.getBalance());
    }
}
*/
public class Main {
    public static void main(String[] args) {
    	String filepath = "C:\\Users\\User\\Desktop\\java coursework\\Accounts.csv";
        ReadAccounts readAccounts = new ReadAccounts(filepath);

        LinkedList<Account> accounts = new LinkedList<>();

        LinkedList<String> firstNames = readAccounts.getFirstNames();
        LinkedList<String> lastNames = readAccounts.getLastNames();
        LinkedList<Integer> accountList = readAccounts.getAccounts();
        LinkedList<Integer> balanceList = readAccounts.getBalances();

        for (int i = 0; i < firstNames.size(); i++) {
            accounts.add(new Account(firstNames.get(i), lastNames.get(i), accountList.get(i), balanceList.get(i)));
        }

        new GUI(accounts, filepath);
    }
}
