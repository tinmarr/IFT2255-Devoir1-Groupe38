import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import com.google.gson.Gson;
import java.io.*;

public class SignUpFrame extends JFrame{
    private List<User> users;
    private List<Intervenant> intervenants;

    public SignUpFrame(List<User> users, List<Intervenant> intervenants){
        this.users = users;
        this.intervenants = intervenants;

        setTitle("Register/SignUp");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);
        JButton bouttonSignUp = new JButton("Sign Up");

        inputPanel.add(emailLabel);
        inputPanel.add(emailField);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordField);

        JPanel signUpButtonPanel = new JPanel();
        signUpButtonPanel.add(bouttonSignUp);

        add(inputPanel, BorderLayout.CENTER);
        add(signUpButtonPanel, BorderLayout.SOUTH);

        bouttonSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                if (!isRegistered(email)) {
                    SaveNewRegister(email, password);
                    dispose(); // Ferme la fenêtre de sign in
                } else {
                    JOptionPane.showMessageDialog(SignUpFrame.this, "This email is already registered. Please try again with a different email.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

    private boolean isRegistered(String email){
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                new ResidentMenuFrame(user, users, intervenants); // Show Resident Menu
                return true;
            }
        }

        
        for (Intervenant intervenant : intervenants) {
            
            if (intervenant.getEmail().equals(email)) {
                new IntervenantMenuFrame(intervenant, users, intervenants); // Show Intervenant Menu
                return true;
            }
        }
        return false;
    }

    private void SaveNewRegister(String email, String password){

        User user = new User("",email,password,"","");
        // Create a Gson object
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter("Donnees.json")){
            // Convert the object to JSON and write it to the file
            gson.toJson(user,writer);
            System.out.println("User data saved to Donnees.json");
        } catch (IOException e){
            e.printStackTrace();
        } 
    }
}