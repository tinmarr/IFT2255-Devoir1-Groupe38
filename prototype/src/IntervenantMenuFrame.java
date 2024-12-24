import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class IntervenantMenuFrame extends JFrame {
    private List<User> users;   
    private List<Intervenant> intervenants;
    private Intervenant currentIntervenant;

    public IntervenantMenuFrame(Intervenant intervenant, List<User> users, List<Intervenant> intervenants) {
        this.users = users;
        this.intervenants = intervenants;
        this.currentIntervenant = intervenant;
        setTitle("Menu Intervenant");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel actionsPanel = new JPanel();
        actionsPanel.setLayout(new BoxLayout(actionsPanel, BoxLayout.Y_AXIS));

        JButton buttonRequetes = new JButton("Consulter les requetes de travail");
        JButton buttonSoumettreCand = new JButton("Soumettre sa candidature");
        JButton buttonSoustraireCand = new JButton("Soustraire sa candidature");
        JButton buttonSuiviCand = new JButton("Faire le suivi de sa candidature");
        JButton bouttonSoumettreProj = new JButton("Soumettre un projet");
        JButton buttonStatuProj = new JButton("Modifier le statut d'un projet");

        actionsPanel.add(buttonRequetes);
        actionsPanel.add(buttonSoumettreCand);
        actionsPanel.add(buttonSoustraireCand);
        actionsPanel.add(buttonSuiviCand);
        actionsPanel.add(bouttonSoumettreProj);  //notification
        actionsPanel.add(buttonStatuProj); //notification

        add(actionsPanel, BorderLayout.CENTER);

        buttonRequetes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNewFrame("Consulter les requetes de travail");
            }
        });

        buttonSoumettreCand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                openSoumettreCand();
            }
        });

        bottonSoustraireCand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                SoustraireCand();
            }
        });

        buttonSuiviCand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                openCandidature();
            }
        });

        bouttonSoumettreProj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSoumettreProj();
            }
        });

        bouttonStatuProj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openProjet();
            }
        });

        setVisible(true);
    }

    private void openNewFrame(String title){
        JFrame newFrame = new JFrame(title);
        newFrame.setSize(400,300);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setLayout(new BorderLayout());

        JButton retourButton = new JButton(title);
        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                newFrame.dispose(); //Close the new frame
            }
        });
    }

    private void openSoumettreCand(){
        JFrame newFrame = new JFrame("Soumettre une candidature");
        newFrame.setSize(400, 300);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);
        JLabel experienceLabel = new JLabel("Experience:");
        JTextField experienceField = new JTextField(20);
        JLabel passedJobsLabel = new JLabel("Passed Jobs:");
        JTextArea passedJobsArea = new JTextArea(10,20);
        JButton soumettreButton = new JButton("Soumettre");
        JButton retourButton = new JButton("Retour");

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(experienceLabel);
        panel.add(experienceField);
        panel.add(passedJobsLabel);
        panel.add(passedJobsArea);
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

    private void SoustraireCand(){

    }

    private void openCandidature(){

    }

    private void openSoumettreProj(){

    }

    private void openProjet(){

    }
}
