import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ResidentMenuFrame extends JFrame {
    private List<User> users;
    private List<Intervenant> intervenants;
    private User currentUser;

    public ResidentMenuFrame(User user, List<User> users, List<Intervenant> intervenants) {
        this.users = users;
        this.intervenants = intervenants;
        this.currentUser = user;
        setTitle("Menu Résident");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel actionsPanel = new JPanel();
        actionsPanel.setLayout(new BoxLayout(actionsPanel, BoxLayout.Y_AXIS));

        JButton bouttonSignaler = new JButton("Signaler un problème");
        JButton bouttonConsulter = new JButton("Consulter un travail en cours");
        JButton bouttonRechercher = new JButton("Rechercher des travaux");
        JButton bouttonModifNotif = new JButton("Modifier les notifications");
        JButton bouttonSoumettreReq = new JButton("Soumettre une requête de travail");
        JButton bouttonRetour = new JButton("Retour au menu principal");

        actionsPanel.add(bouttonSignaler);
        actionsPanel.add(bouttonConsulter);
        actionsPanel.add(bouttonRechercher);
        actionsPanel.add(bouttonModifNotif);
        actionsPanel.add(bouttonSoumettreReq);
        actionsPanel.add(bouttonRetour);

        add(actionsPanel, BorderLayout.CENTER);

        bouttonSignaler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSignalerFrame();
            }
        });

        bouttonConsulter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNewFrame("Consulter un travail en cours");
            }
        });

        bouttonRechercher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNewFrame("Rechercher des travaux");
            }
        });

        bouttonModifNotif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNewFrame("Modifier les notifications");
            }
        });

        bouttonSoumettreReq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSoumettreReqFrame();
            }
        });

        bouttonRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current frame
                new MainGUI(users, intervenants); // Assuming you want to return to the main menu
            }
        });

        setVisible(true);
    }

    private void openSignalerFrame() {
        JFrame newFrame = new JFrame("Signaler un problème");
        newFrame.setSize(400, 300);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Décrivez le problème rencontré:");
        JTextArea textArea = new JTextArea(10, 30);
        JButton soumettreButton = new JButton("Soumettre");
        JButton retourButton = new JButton("Retour");

        panel.add(label);
        panel.add(new JScrollPane(textArea));
        panel.add(soumettreButton);
        panel.add(retourButton);

        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newFrame.dispose(); // Close the new frame
            }
        });

        newFrame.add(panel, BorderLayout.CENTER);
        newFrame.setVisible(true);
    }

    private void openSoumettreReqFrame() {
        JFrame newFrame = new JFrame("Soumettre une requête de travail");
        newFrame.setSize(400, 300);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Décrivez votre requête:");
        JTextArea textArea = new JTextArea(10, 30);
        JButton soumettreButton = new JButton("Soumettre");
        JButton retourButton = new JButton("Retour");

        panel.add(label);
        panel.add(new JScrollPane(textArea));
        panel.add(soumettreButton);
        panel.add(retourButton);

        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newFrame.dispose(); // Close the new frame
            }
        });

        newFrame.add(panel, BorderLayout.CENTER);
        newFrame.setVisible(true);
    }

    private void openNewFrame(String title) {
        JFrame newFrame = new JFrame(title);
        newFrame.setSize(400, 300);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setLayout(new BorderLayout());

        JButton retourButton = new JButton("Retour");
        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newFrame.dispose(); // Close the new frame
            }
        });

        JPanel panel = new JPanel();
        panel.add(retourButton);

        newFrame.add(panel, BorderLayout.SOUTH);
        newFrame.setVisible(true);
    }
}
