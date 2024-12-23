import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainGUI {
    private List<User> users;
    private List<Intervenant> intervenants;

    public MainGUI(List<User> users, List<Intervenant> intervenants) {
        this.users = users;
        this.intervenants = intervenants;

        // Fenêtre principale
        JFrame frame = new JFrame("MaVille");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout()); // Set layout manager

        // Label de bienvenue
        JLabel label = new JLabel("Bienvenue sur l'application MaVille !");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(label, BorderLayout.CENTER); // Add label to frame

        // Boutton de connection
        JButton button = new JButton("Se connecter");
        frame.add(button, BorderLayout.SOUTH); // Add button to frame
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme la première fenêtre
                new ConnexionFrame(users, intervenants);
            }
        });

        frame.setVisible(true); // Make the frame visible
    }
}
