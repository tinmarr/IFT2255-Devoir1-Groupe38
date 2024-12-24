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
        JButton buttonCandidature = new JButton("Soumettre sa candidature");
        JButton buttonSoustraireCand = new JButton("Soustraire sa candidature");
        JButton buttonSuivi = new JButton("Faire le suivi de sa candidature");
        JButton buttonProjet = new JButton("Soumettre un projet");
        JButton buttonModStat = new JButton("Modifier le statut d'un projet");

        actionsPanel.add(buttonRequetes);
        actionsPanel.add(buttonCandidature);
        actionsPanel.add(buttonSoustraireCand);
        actionsPanel.add(buttonSuivi);
        actionsPanel.add(buttonProjet);  //notification
        actionsPanel.add(buttonModStat); //notification

        add(actionsPanel, BorderLayout.CENTER);

        buttonRequetes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSignalerFrame();
            }
        });

        setVisible(true);
    }
}
