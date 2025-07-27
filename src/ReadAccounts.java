import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class ReadAccounts {
    private BufferedReader reader;
    private String url;

    // Constructor
    public ReadAccounts(String URL) {
        this.url = URL;
    }

    // Method to get first names
    public LinkedList<String> getFirstNames() {
        LinkedList<String> firstNames = new LinkedList<>();
        try {
            reader = new BufferedReader(new FileReader(url));
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the header line
                }
                String[] data = line.split(",");
                if (data.length >= 1 && !data[0].trim().isEmpty()) {
                    firstNames.add(data[0].trim()); // Add first name after trimming
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return firstNames;
    }

    // Method to get last names
    public LinkedList<String> getLastNames() {
        LinkedList<String> lastNames = new LinkedList<>();
        try {
            reader = new BufferedReader(new FileReader(url));
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the header line
                }
                String[] data = line.split(",");
                if (data.length >= 2 && !data[1].trim().isEmpty()) {
                    lastNames.add(data[1].trim()); // Add last name after trimming
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastNames;
    }

    // Method to get account numbers
    public LinkedList<Integer> getAccounts() {
        LinkedList<Integer> accounts = new LinkedList<>();
        try {
            reader = new BufferedReader(new FileReader(url));
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the header line
                }
                String[] data = line.split(",");
                if (data.length >= 3 && !data[2].trim().isEmpty()) {
                    accounts.add(Integer.parseInt(data[2].trim())); // Parse account number
                }
            }
            reader.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    // Method to get balances
    public LinkedList<Integer> getBalances() {
        LinkedList<Integer> balances = new LinkedList<>();
        try {
            reader = new BufferedReader(new FileReader(url));
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the header line
                }
                String[] data = line.split(",");
                if (data.length >= 4 && !data[3].trim().isEmpty()) {
                    balances.add(Integer.parseInt(data[3].trim())); // Parse balance
                }
            }
            reader.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return balances;
    }
}
