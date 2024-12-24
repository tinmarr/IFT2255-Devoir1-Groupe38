import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import com.google.gson.Gson;
import java.io.*;

class Project{
    private String id;
    private String title;
    private String description;
    private String startDate;
    private String endDate;

    public Project(String id, String title,String description, String startDate, String endDate){
        this.id = id;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public String getStartDate(){
        return startDate;
    }

    public String getEndDate(){
        return endDate;
    }
}

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

        JLabel IdLabel = new JLabel("intervenantId:");
        JTextField IdField = new JTextField(10);
        JLabel messageLabel = new JLabel("message:");
        JTextArea messageArea = new JTextArea(10,20);
        JButton soumettreButton = new JButton("Soumettre");
        JButton retourButton = new JButton("Retour");

        panel.add(IdLabel);
        panel.add(IdField);
        panel.add(messageLabel);
        panel.add(messageArea);
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
        
        JFrame newFrame = new JFrame("Soumettre un projet");
        newFrame.setSize(400, 300);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel IdLabel = new JLabel("Id:");
        JTextField IdField = new JTextField(20);
        JLabel titleLabel = new JLabel("title:");
        JTextField titleField = new JTextField(20);
        JLabel descriptionLabel = new JLabel("description:");
        JTextArea descriptionArea = new JTextArea(10,20);
        JLabel startLabel = new JLabel("start date:");
        JTextField startField = new JTextField(10);
        JLabel endLabel = new JLabel("end date:");
        JTextField endField = new JTextField(10);
        JButton soumettreButton = new JButton("Soumettre");
        JButton retourButton = new JButton("Retour");

        panel.add(IdLabel);
        panel.add(IdField);
        panel.add(titleLabel);
        panel.add(titleField);
        panel.add(descriptionLabel);
        panel.add(descriptionArea);
        panel.add(startLabel);
        panel.add(startField);
        panel.add(endLabel);
        panel.add(endField);
        panel.add(soumettreButton);
        panel.add(retourButton);

        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newFrame.dispose(); // Close the new frame
            }
        });

        soumettreButton.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                SaveNewProject(IdField.getText(),titleField.getText(),descriptionArea.getText(),startField.getText(),endField.getText());
            }
        }));

        newFrame.add(panel, BorderLayout.CENTER);
        newFrame.setVisible(true);

    }

    private void SaveNewProject(String id, String title,String description, String startDate, String endDate){

        Project project = new Project(id,title,description,startDate,endDate);
        // Create a Gson object
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter("File.json")){
            // Convert the object to JSON and write it to the file
            gson.toJson(project,writer);
            System.out.println("User data saved to File.json");
        } catch (IOException e){
            e.printStackTrace();
        } 
    }

    private void openProjet(){

    }
}
