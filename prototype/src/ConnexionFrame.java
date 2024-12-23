import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ConnexionFrame extends JFrame {
    private List<User> users;
    private List<Intervenant> intervenants;

    public ConnexionFrame(List<User> users, List<Intervenant> intervenants) {
        this.users = users;
        this.intervenants = intervenants;

        setTitle("Connexion");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        JButton bouttonConnection = new JButton("Sign In");
        JButton bouttonInscripton = new JButton("Sign Up");
        JButton quitButton = new JButton("Quit");

        buttonPanel.add(bouttonConnection);
        buttonPanel.add(bouttonInscripton);
        buttonPanel.add(quitButton);

        add(buttonPanel, BorderLayout.CENTER);

        bouttonConnection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Ferme la fenêtre de connexion
                new SignInFrame(users, intervenants);
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Ferme la fenêtre de connexion
            }
        });

        setVisible(true);
    }
}
