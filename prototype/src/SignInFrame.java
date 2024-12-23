import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SignInFrame extends JFrame {
    private List<User> users;
    private List<Intervenant> intervenants;

    public SignInFrame(List<User> users, List<Intervenant> intervenants) {
        this.users = users;
        this.intervenants = intervenants;

        setTitle("SignIn");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);
        JButton bouttonSignIn = new JButton("Sign In");

        inputPanel.add(emailLabel);
        inputPanel.add(emailField);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordField);

        JPanel signInButtonPanel = new JPanel();
        signInButtonPanel.add(bouttonSignIn);

        add(inputPanel, BorderLayout.CENTER);
        add(signInButtonPanel, BorderLayout.SOUTH);

        bouttonSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                if (login(email, password)) {
                    dispose(); // Ferme la fenêtre de sign in
                } else {
                    JOptionPane.showMessageDialog(SignInFrame.this, "Invalid email or password. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

    private boolean login(String email, String password) {
        
        for (User user : users) {
            
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                new ResidentMenuFrame(user, users, intervenants); // Show Resident Menu
                return true;
            }
        }

        
        for (Intervenant intervenant : intervenants) {
            
            if (intervenant.getEmail().equals(email) && intervenant.getPassword().equals(password)) {
                new IntervenantMenuFrame(intervenant, users, intervenants); // Show Intervenant Menu
                return true;
            }
        }
        return false;
    }
}
