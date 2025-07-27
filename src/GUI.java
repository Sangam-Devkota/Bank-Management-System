import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class GUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private Transaction transferObject;
    private StringBuilder sbAllData;
    private LinkedList<Account> globalAccounts;
    private String filePath; // To store the CSV file path

    private JTable accountTable;
    private DefaultTableModel tableModel;
    private JButton showAllButton;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton transferButton;

    private JTextField accDeposit;
    private JTextField accWithdraw;
    private JTextField acc1Transfer;
    private JTextField acc2Transfer;
    private JTextField depositInput;
    private JTextField withdrawInput;
    private JTextField transferAmount;
    private JLabel lblNewLabel;
    private JLabel lblAmount;
    private JLabel lblNewLabel_1;
    private JLabel lblAmount_1;
    private JLabel lblNewLabel_2;
    private JLabel lblAmount_2;
    private JLabel lblNewLabel_3;
    private JButton btnReset;
    private JPanel panel_1;
    private JLabel lblNewLabel_6;
    private JPanel panel_2;
    private JLabel lblNewLabel_7;
    private JPanel panel_3;
    private JLabel lblNewLabel_8;

    public GUI(LinkedList<Account> accounts, String filePath) {
        // Set up the frame
        super("Banking System");
        getContentPane().setBackground(SystemColor.textHighlight);
        getContentPane().setLayout(null);

        // Initialize globalAccounts with the accounts from the main class
        this.globalAccounts = accounts;
        this.filePath = filePath; // Set the CSV file path
        
        // Initialize the table model and JTable
        String[] columnNames = {"First Name", "Last Name", "Account Number", "Balance"};
        tableModel = new DefaultTableModel(columnNames, 0);
        accountTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(accountTable);
        scrollPane.setBounds(141, 396, 931, 342);
        getContentPane().add(scrollPane);

        showAllButton = new JButton("Show All");
        showAllButton.setBackground(Color.MAGENTA);
        showAllButton.setBounds(504, 355, 150, 30);
        getContentPane().add(showAllButton);

        depositButton = new JButton("Deposit");
        depositButton.setBackground(new Color(176, 196, 222));
        depositButton.setBounds(665, 131, 150, 30);
        getContentPane().add(depositButton);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBackground(new Color(176, 196, 222));
        withdrawButton.setBounds(665, 215, 150, 30);
        getContentPane().add(withdrawButton);

        transferButton = new JButton("Transfer");
        transferButton.setBackground(new Color(176, 196, 222));
        transferButton.setBounds(894, 316, 150, 30);
        getContentPane().add(transferButton);

        accDeposit = new JTextField("");
        accDeposit.setFont(new Font("Tahoma", Font.BOLD, 10));
        accDeposit.setBackground(UIManager.getColor("scrollbar"));
        accDeposit.setBounds(178, 132, 200, 30);
        getContentPane().add(accDeposit);

        depositInput = new JTextField("");
        depositInput.setFont(new Font("Tahoma", Font.BOLD, 10));
        depositInput.setBackground(UIManager.getColor("scrollbar"));
        depositInput.setBounds(428, 132, 200, 30);
        getContentPane().add(depositInput);

        accWithdraw = new JTextField("");
        accWithdraw.setFont(new Font("Tahoma", Font.BOLD, 10));
        accWithdraw.setBackground(UIManager.getColor("scrollbar"));
        accWithdraw.setBounds(174, 216, 200, 30);
        getContentPane().add(accWithdraw);

        withdrawInput = new JTextField("");
        withdrawInput.setFont(new Font("Tahoma", Font.BOLD, 10));
        withdrawInput.setBackground(UIManager.getColor("scrollbar"));
        withdrawInput.setBounds(424, 216, 200, 30);
        getContentPane().add(withdrawInput);

        acc1Transfer = new JTextField("");
        acc1Transfer.setFont(new Font("Tahoma", Font.BOLD, 10));
        acc1Transfer.setBackground(UIManager.getColor("scrollbar"));
        acc1Transfer.setBounds(178, 317, 200, 30);
        getContentPane().add(acc1Transfer);

        acc2Transfer = new JTextField("");
        acc2Transfer.setFont(new Font("Tahoma", Font.BOLD, 10));
        acc2Transfer.setBackground(UIManager.getColor("scrollbar"));
        acc2Transfer.setBounds(428, 317, 200, 30);
        getContentPane().add(acc2Transfer);

        transferAmount = new JTextField("");
        transferAmount.setFont(new Font("Tahoma", Font.BOLD, 10));
        transferAmount.setBackground(UIManager.getColor("scrollbar"));
        transferAmount.setBounds(678, 317, 200, 30);
        getContentPane().add(transferAmount);
        
        lblNewLabel = new JLabel("Account");
        lblNewLabel.setBounds(248, 109, 81, 13);
        getContentPane().add(lblNewLabel);
        
        lblAmount = new JLabel("Amount");
        lblAmount.setBounds(496, 109, 45, 13);
        getContentPane().add(lblAmount);
        
        lblNewLabel_1 = new JLabel("Account");
        lblNewLabel_1.setBounds(248, 195, 81, 13);
        getContentPane().add(lblNewLabel_1);
        
        lblAmount_1 = new JLabel("Amount");
        lblAmount_1.setBounds(496, 195, 45, 13);
        getContentPane().add(lblAmount_1);
        
        lblNewLabel_2 = new JLabel("To Account");
        lblNewLabel_2.setBounds(496, 296, 88, 13);
        getContentPane().add(lblNewLabel_2);
        
        lblAmount_2 = new JLabel("Amount");
        lblAmount_2.setBounds(744, 296, 45, 13);
        getContentPane().add(lblAmount_2);
        
        lblNewLabel_3 = new JLabel("From Account");
        lblNewLabel_3.setBounds(248, 300, 81, 13);
        getContentPane().add(lblNewLabel_3);
        
        btnReset = new JButton("RESET ALL");
        btnReset.setBackground(new Color(176, 196, 222));
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                accDeposit.setText("");
                depositInput.setText("");
                accWithdraw.setText("");
                withdrawInput.setText("");
                acc1Transfer.setText("");
                acc2Transfer.setText("");
                transferAmount.setText("");
            }
        });
        btnReset.setBounds(890, 169, 150, 30);
        getContentPane().add(btnReset);
        
        JLabel lblNewLabel_4 = new JLabel("Banking Management System");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_4.setBounds(351, 10, 365, 35);
        getContentPane().add(lblNewLabel_4);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 255, 0));
        panel.setBounds(160, 71, 713, 97);
        getContentPane().add(panel);
        
        JLabel lblNewLabel_5 = new JLabel("DEPOSIT");
        panel.add(lblNewLabel_5);
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        panel_1 = new JPanel();
        panel_1.setBackground(Color.ORANGE);
        panel_1.setBounds(161, 171, 713, 97);
        getContentPane().add(panel_1);
        
        lblNewLabel_6 = new JLabel("WITHDRAW");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_1.add(lblNewLabel_6);
        
        panel_2 = new JPanel();
        panel_2.setBackground(new Color(0, 255, 255));
        panel_2.setBounds(160, 272, 888, 81);
        getContentPane().add(panel_2);
        panel_2.setLayout(null);
        
        lblNewLabel_7 = new JLabel("TRANSFER");
        lblNewLabel_7.setBounds(330, 0, 73, 19);
        lblNewLabel_7.setBackground(Color.WHITE);
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(lblNewLabel_7);
        
        panel_3 = new JPanel();
        panel_3.setBackground(Color.RED);
        panel_3.setBounds(875, 71, 173, 197);
        getContentPane().add(panel_3);
        panel_3.setLayout(null);
        
        lblNewLabel_8 = new JLabel("RESET");
        lblNewLabel_8.setBounds(62, 10, 55, 30);
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_3.add(lblNewLabel_8);

        // Create an object of HandlerClass to handle events
        HandlerClass handler = new HandlerClass();
        showAllButton.addActionListener(handler);
        depositButton.addActionListener(handler);
        withdrawButton.addActionListener(handler);
        transferButton.addActionListener(handler);

        // Set the JFrame properties
        setSize(1186, 889);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Method to populate the JTable with account data
    private void populateTable() {
        // Clear the existing rows
        tableModel.setRowCount(0);

        // Add rows to the table
        for (Account acc : globalAccounts) {
            Object[] rowData = {
                acc.getFirstName(),
                acc.getLastName(),
                acc.getAccountNumber(),
                acc.getBalance()
            };
            tableModel.addRow(rowData);
        }
    }

    // Method to update the CSV file with the current account data
    private void updateCSV() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("First Name,Last Name,Account Number,Balance");
            writer.newLine();

            for (Account acc : globalAccounts) {
                String line = acc.getFirstName() + "," + acc.getLastName() + "," + acc.getAccountNumber() + "," + acc.getBalance();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // HandlerClass to manage button actions
    private class HandlerClass implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == showAllButton) {
                populateTable(); // Populate the JTable with data
            } else if (e.getSource() == depositButton) {
                try {
                    int accNum = Integer.parseInt(accDeposit.getText().trim());
                    int amount = Integer.parseInt(depositInput.getText().trim());
                    boolean found = false;
                    for (Account acc : globalAccounts) {
                        if (acc.getAccountNumber() == accNum) {
                            acc.deposit(amount);
                            updateCSV();  // Update the CSV file after deposit
                            populateTable(); // Update the JTable with new data
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Account not found");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numbers.");
                }
            } else if (e.getSource() == withdrawButton) {
                try {
                    int accNum = Integer.parseInt(accWithdraw.getText().trim());
                    int amount = Integer.parseInt(withdrawInput.getText().trim());
                    boolean found = false;
                    for (Account acc : globalAccounts) {
                        if (acc.getAccountNumber() == accNum) {
                            acc.withdraw(amount);
                            updateCSV();  // Update the CSV file after withdrawal
                            populateTable(); // Update the JTable with new data
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Account not found");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numbers.");
                }
            } else if (e.getSource() == transferButton) {
                try {
                    int accNum1 = Integer.parseInt(acc1Transfer.getText().trim());
                    int accNum2 = Integer.parseInt(acc2Transfer.getText().trim());
                    int amount = Integer.parseInt(transferAmount.getText().trim());

                    Account acc1 = null, acc2 = null;
                    for (Account acc : globalAccounts) {
                        if (acc.getAccountNumber() == accNum1) {
                            acc1 = acc;
                        }
                        if (acc.getAccountNumber() == accNum2) {
                            acc2 = acc;
                        }
                        // Early exit if both accounts are found
                        if (acc1 != null && acc2 != null) {
                            break;
                        }
                    }

                    if (acc1 != null && acc2 != null) {
                        transferObject = new Transaction();
                        transferObject.transfer(acc1, acc2, amount);
                        updateCSV();  // Update the CSV file after transfer
                        populateTable(); // Update the JTable with new data
                    } else {
                        JOptionPane.showMessageDialog(null, "Account not found", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
