import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ATM_GUI extends JFrame implements ActionListener {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JTextField accNumberField;
    private JPasswordField pinField;
    private JLabel balanceLabel;
    private JTextField amountField;
    private int balance = 0;
    private int pin = 0;
    private String transactionType = ""; // Track the type of transaction (Add or Take)

    public ATM_GUI() {
        // Setting up the JFrame
        setTitle("ATM Interface");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creating a CardLayout to manage multiple pages
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        // Adding pages to the CardLayout
        mainPanel.add(createLoginPage(), "LoginPage");
        mainPanel.add(createMainPage(), "MainPage");
        mainPanel.add(createActionPage(), "ActionPage");

        add(mainPanel, BorderLayout.CENTER);
        
        // Show the login page initially
        cardLayout.show(mainPanel, "LoginPage");
    }

    private JPanel createLoginPage() {
        JPanel loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBackground(Color.WHITE);  // White background
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Login Page");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLUE);  // Blue text
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        loginPanel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        
        JLabel accNumberLabel = new JLabel("Account Number:");
        accNumberLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 1;
        loginPanel.add(accNumberLabel, gbc);

        accNumberField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        loginPanel.add(accNumberField, gbc);

        JLabel pinLabel = new JLabel("PIN:");
        pinLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        loginPanel.add(pinLabel, gbc);

        pinField = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        loginPanel.add(pinField, gbc);

        JButton loginButton = new JButton("Login");
        loginButton.setBackground(Color.RED);  // Red button
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        loginPanel.add(loginButton, gbc);

        return loginPanel;
    }

    private JPanel createMainPage() {
        JPanel mainPage = new JPanel(new GridBagLayout());
        mainPage.setBackground(Color.BLACK);  // Black background
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Main Page");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);  // White text
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPage.add(titleLabel, gbc);

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setBackground(Color.BLUE);  // Blue button
        checkBalanceButton.setForeground(Color.WHITE);
        checkBalanceButton.setFont(new Font("Arial", Font.BOLD, 16));
        checkBalanceButton.addActionListener(this);
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        mainPage.add(checkBalanceButton, gbc);

        JButton addAmountButton = new JButton("Add Amount");
        addAmountButton.setBackground(Color.BLUE);  // Blue button
        addAmountButton.setForeground(Color.WHITE);
        addAmountButton.setFont(new Font("Arial", Font.BOLD, 16));
        addAmountButton.addActionListener(this);
        gbc.gridy = 2;
        mainPage.add(addAmountButton, gbc);

        JButton takeAmountButton = new JButton("Take Amount");
        takeAmountButton.setBackground(Color.BLUE);  // Blue button
        takeAmountButton.setForeground(Color.WHITE);
        takeAmountButton.setFont(new Font("Arial", Font.BOLD, 16));
        takeAmountButton.addActionListener(this);
        gbc.gridy = 3;
        mainPage.add(takeAmountButton, gbc);

        JButton receiptButton = new JButton("Print Receipt");
        receiptButton.setBackground(Color.BLUE);  // Blue button
        receiptButton.setForeground(Color.WHITE);
        receiptButton.setFont(new Font("Arial", Font.BOLD, 16));
        receiptButton.addActionListener(this);
        gbc.gridy = 4;
        mainPage.add(receiptButton, gbc);

        JButton changePinButton = new JButton("Change PIN");
        changePinButton.setBackground(Color.BLUE);  // Blue button
        changePinButton.setForeground(Color.WHITE);
        changePinButton.setFont(new Font("Arial", Font.BOLD, 16));
        changePinButton.addActionListener(this);
        gbc.gridy = 5;
        mainPage.add(changePinButton, gbc);

        JButton exitButton = new JButton("Exit");
        exitButton.setBackground(Color.RED);  // Red button
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(new Font("Arial", Font.BOLD, 16));
        exitButton.addActionListener(this);
        gbc.gridy = 6;
        mainPage.add(exitButton, gbc);

        return mainPage;
    }

    private JPanel createActionPage() {
        JPanel actionPage = new JPanel(new GridBagLayout());
        actionPage.setBackground(Color.BLACK);  // Black background
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Action Page");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);  // White text
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        actionPage.add(titleLabel, gbc);

        balanceLabel = new JLabel("Balance: ");
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        balanceLabel.setForeground(Color.WHITE);  // White text
        gbc.gridy = 1;
        actionPage.add(balanceLabel, gbc);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        amountLabel.setForeground(Color.WHITE);  // White text
        gbc.gridy = 2;
        actionPage.add(amountLabel, gbc);

        amountField = new JTextField(10);
        gbc.gridy = 3;
        actionPage.add(amountField, gbc);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBackground(Color.RED);  // Red button
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setFont(new Font("Arial", Font.BOLD, 16));
        confirmButton.addActionListener(this);
        gbc.gridy = 4;
        actionPage.add(confirmButton, gbc);

        return actionPage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();

        if (source.getText().equals("Login")) {
            String accNo = accNumberField.getText();
            String pinInput = new String(pinField.getPassword());

            if (accNo.equals("12345") && pinInput.equals("1234")) {
                balance = 10000;
                pin = 1234;
                cardLayout.show(mainPanel, "MainPage");
            } else if (accNo.equals("67890") && pinInput.equals("5678")) {
                balance = 15400;
                pin = 5678;
                cardLayout.show(mainPanel, "MainPage");
            } else if (accNo.equals("98765") && pinInput.equals("8765")) {
                balance = 584980;
                pin = 8765;
                cardLayout.show(mainPanel, "MainPage");
            } else if (accNo.equals("54321") && pinInput.equals("4321")) {
                balance = 64900;
                pin = 4321;
                cardLayout.show(mainPanel, "MainPage");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Account Number or PIN.");
            }

        } else if (source.getText().equals("Check Balance")) {
            balanceLabel.setText("Balance: " + balance);
            cardLayout.show(mainPanel, "ActionPage");

        } else if (source.getText().equals("Add Amount")) {
            transactionType = "Add";
            cardLayout.show(mainPanel, "ActionPage");
            amountField.setText("");  // Clear the amount field

        } else if (source.getText().equals("Take Amount")) {
            transactionType = "Take";
            cardLayout.show(mainPanel, "ActionPage");
            amountField.setText("");  // Clear the amount field

        } else if (source.getText().equals("Print Receipt")) {
            JOptionPane.showMessageDialog(this,
                "Balance: " + balance + "\nThank you for using ABC Bank.",
                "Receipt",
                JOptionPane.INFORMATION_MESSAGE);

        } else if (source.getText().equals("Change PIN")) {
            String oldPin = JOptionPane.showInputDialog(this, "Enter Old PIN:");
            if (oldPin != null && oldPin.equals(String.valueOf(pin))) {
                String newPin = JOptionPane.showInputDialog(this, "Enter New PIN:");
                String recheckPin = JOptionPane.showInputDialog(this, "Re-enter New PIN:");
                if (newPin != null && newPin.equals(recheckPin)) {
                    pin = Integer.parseInt(newPin);
                    JOptionPane.showMessageDialog(this, "PIN Changed Successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "PIN Mismatch!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Old PIN Incorrect!");
            }

        } else if (source.getText().equals("Exit")) {
            int confirmExit = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
            if (confirmExit == JOptionPane.YES_OPTION) {
                System.exit(0);
            }

        } else if (source.getText().equals("Confirm")) {
            String amountText = amountField.getText();
            try {
                int amount = Integer.parseInt(amountText);
                if (amountText.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter an amount.");
                } else if (transactionType.equals("Add")) {
                    balance += amount;
                    JOptionPane.showMessageDialog(this, "Amount Added Successfully!");
                    cardLayout.show(mainPanel, "MainPage");
                } else if (transactionType.equals("Take")) {
                    if (amount > balance) {
                        JOptionPane.showMessageDialog(this, "Insufficient Balance!");
                    } else {
                        balance -= amount;
                        JOptionPane.showMessageDialog(this, "Amount Debited Successfully!");
                        cardLayout.show(mainPanel, "MainPage");
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid amount entered.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ATM_GUI atmGui = new ATM_GUI();
            atmGui.setVisible(true);
        });
    }
}
