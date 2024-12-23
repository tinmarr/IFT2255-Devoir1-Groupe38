import javax.swing.*;
import java.awt.BorderLayout;
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

        JButton action1Button = new JButton("Action 1");
        JButton action2Button = new JButton("Action 2");
        JButton action3Button = new JButton("Action 3");
        JButton action4Button = new JButton("Action 4");
        JButton action5Button = new JButton("Action 5");
        JButton action6Button = new JButton("Action 6");

        actionsPanel.add(action1Button);
        actionsPanel.add(action2Button);
        actionsPanel.add(action3Button);
        actionsPanel.add(action4Button);
        actionsPanel.add(action5Button);
        actionsPanel.add(action6Button);

        add(actionsPanel, BorderLayout.CENTER);
        setVisible(true);
    }
}
