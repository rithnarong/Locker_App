import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LockerApp extends JFrame {
    private JTextField passwordField;
    private JButton enterButton;
    private JButton clearButton;
    private JLabel statusLabel;
    private String savedPassword;

    public LockerApp() {
        // Setup the frame
        setTitle("Locker Application");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 3));

        // Initialize components
        passwordField = new JTextField();
        enterButton = new JButton("Enter");
        clearButton = new JButton("Clear");
        statusLabel = new JLabel("", SwingConstants.CENTER);

        // Add components to frame
        for (int i = 1; i <= 9; i++) {
            final int number = i;
            JButton numberButton = new JButton(Integer.toString(number));
            numberButton.addActionListener(e -> passwordField.setText(passwordField.getText() + number));
            add(numberButton);
        }
        JButton zeroButton = new JButton("0");
        zeroButton.addActionListener(e -> passwordField.setText(passwordField.getText() + "0"));
        add(zeroButton);

        add(clearButton);
        add(enterButton);
        add(passwordField);
        add(statusLabel);

        // Add action listeners
        enterButton.addActionListener(new EnterButtonListener());
        clearButton.addActionListener(e -> passwordField.setText(""));

        // Show the frame
        setVisible(true);
    }

    private class EnterButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String inputPassword = passwordField.getText();

            if (savedPassword == null) {
                savedPassword = inputPassword;
                statusLabel.setText("Password Set");
            } else {
                if (inputPassword.equals(savedPassword)) {
                    statusLabel.setText("Correct Password");
                } else {
                    statusLabel.setText("Incorrect Password");
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LockerApp::new);
    }
}