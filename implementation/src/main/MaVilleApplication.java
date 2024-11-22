package main; 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import main.Resident;
import main.Intervenant;
import main.RequeteTravail;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

class MaVilleApplication {
    private HashMap<String, Resident> residents;
    private HashMap<String, Intervenant> intervenants;
    private List<RequeteTravail> requetesTravail;

    public MaVilleApplication() {
        residents = new HashMap<>();
        intervenants = new HashMap<>();
        requetesTravail = new ArrayList<>();
        // Initialiser des exemples
        initialiserExemples();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Bienvenue sur l'application MaVille. Veuillez choisir une option :\n1. Connexion Résident\n2. Connexion Intervenant\n3. Quitter");
            int choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    connecterResident();
                    break;
                case 2:
                    connecterIntervenant();
                    break;
                case 3:
                    System.out.println("Merci d'avoir utilisé l'application MaVille. À bientôt!");
                    return;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }
    
    private void connecterResident() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adresse courriel :");
        String email = scanner.nextLine();
        System.out.println("Mot de passe :");
        String password = scanner.nextLine();
        Resident resident = residents.get(email);
        if (resident != null && resident.getPassword().equals(password)) {
            System.out.println("Connexion réussie!");
            afficherMenuResident(resident);
        } else {
            System.out.println("Erreur d'authentification, veuillez réessayer.");
        }
    }

    private void connecterIntervenant() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adresse courriel :");
        String email = scanner.nextLine();
        System.out.println("Mot de passe :");
        String password = scanner.nextLine();
        Intervenant intervenant = intervenants.get(email);
        if (intervenant != null && intervenant.getPassword().equals(password)) {
            System.out.println("Connexion réussie!");
            afficherMenuIntervenant(intervenant);
        } else {
            System.out.println("Erreur d'authentification, veuillez réessayer.");
        }
    }


    private void afficherMenuResident(Resident resident) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu principal - Résident\n1. Consulter les travaux en cours\n2. Consulter les entraves routières\n3. Soumettre une requête de travail\n4. Se déconnecter");
            int choix = scanner.nextInt();
            scanner.nextLine();  // Consommer la nouvelle ligne
            switch (choix) {
                case 1:
                    consulterTravaux();
                    break;
                case 2:
                    consulterEntraves();
                    break;
                case 3:
                    soumettreRequeteTravail(resident);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }

    private void consulterTravaux() {
         try {
            String url = "https://donnees.montreal.ca/api/3/action/datastore_search?resource_id=cc41b532-f12d-40fb-9f55-eb58c9a2b12b";
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            int responseCode = conn.getResponseCode();

            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray records = jsonResponse.getJSONObject("result").getJSONArray("records");

                Scanner scanner = new Scanner(System.in);
                int pageSize = 5; // Number of records per page
                int currentPage = 0;
                int totalPages = (int) Math.ceil((double) records.length() / pageSize);

                while (true) {
                    System.out.println("Travaux en cours (Page " + (currentPage + 1) + " sur " + totalPages + "):");
                    int start = currentPage * pageSize;
                    int end = Math.min(start + pageSize, records.length());
                    for (int i = start; i < end; i++) {
                        JSONObject record = records.getJSONObject(i);
                        System.out.println("- ID: " + record.getString("id") + " | Raison: " + record.getString("reason_category") + " | Status: " + record.getString("currentstatus"));
                    }

                    System.out.println("\nOptions: [n] Suivant, [p] Précédent, [q] Quitter");
                    String option = scanner.nextLine();
                    if (option.equals("n") && currentPage < totalPages - 1) {
                        currentPage++;
                    } else if (option.equals("p") && currentPage > 0) {
                        currentPage--;
                    } else if (option.equals("q")) {
                        break;
                    } else {
                        System.out.println("Option invalide, veuillez réessayer.");
                    }
                }
            } else {
                System.out.println("Erreur lors de la récupération des travaux.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Une erreur s'est produite lors de la consultation des travaux.");
        }
    }
    
    private void consulterEntraves() {
        try {
            String url = "https://donnees.montreal.ca/api/3/action/datastore_search?resource_id=a2bc8014-488c-495d-941b-e7ae1999d1bd";
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            int responseCode = conn.getResponseCode();

            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray records = jsonResponse.getJSONObject("result").getJSONArray("records");

                Scanner scanner = new Scanner(System.in);
                int pageSize = 5; // Number of records per page
                int currentPage = 0;
                int totalPages = (int) Math.ceil((double) records.length() / pageSize);

                while (true) {
                    System.out.println("Entraves en cours (Page " + (currentPage + 1) + " sur " + totalPages + "):");
                    int start = currentPage * pageSize;
                    int end = Math.min(start + pageSize, records.length());
                    for (int i = start; i < end; i++) {
                        JSONObject record = records.getJSONObject(i);
                        System.out.println("- ID Demande: " + record.getString("id_request") + " | Rue: " + record.getString("shortname") + " | Type d'impact: " + record.getString("streetimpacttype"));
                    }

                    System.out.println("\nOptions: [n] Suivant, [p] Précédent, [q] Quitter");
                    String option = scanner.nextLine();
                    if (option.equals("n") && currentPage < totalPages - 1) {
                        currentPage++;
                    } else if (option.equals("p") && currentPage > 0) {
                        currentPage--;
                    } else if (option.equals("q")) {
                        break;
                    } else {
                        System.out.println("Option invalide, veuillez réessayer.");
                    }
                }
            } else {
                System.out.println("Erreur lors de la récupération des entraves.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Une erreur s'est produite lors de la consultation des entraves.");
        }
    }

    private void soumettreRequeteTravail(Resident resident) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Titre du travail :");
        String titre = scanner.nextLine();
        System.out.println("Description du travail :");
        String description = scanner.nextLine();
        System.out.println("Type de travail :");
        String typeTravail = scanner.nextLine();
        System.out.println("Date de début espéré :");
        String dateDebut = scanner.nextLine();
        RequeteTravail requete = new RequeteTravail(resident.getEmail(), titre, description, typeTravail, dateDebut);
        requetesTravail.add(requete);
        System.out.println("Requête de travail soumise avec succès!");
    }

    private void afficherMenuIntervenant(Intervenant intervenant) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu principal - Intervenant\n1. Consulter les requêtes de travail\n2. Se déconnecter");
            int choix = scanner.nextInt();
            scanner.nextLine();  // Consommer la nouvelle ligne
            switch (choix) {
                case 1:
                    consulterRequetesTravail();
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }

    private void consulterRequetesTravail() {
        System.out.println("Requêtes de travail disponibles :");
        for (RequeteTravail requete : requetesTravail) {
            System.out.println("- " + requete.getTitre() + ": " + requete.getDescription());
        }
    }

    private void initialiserExemples() {
        residents.put("jean@gmail.com", new Resident("Jean", "jean@gmail.com", "password1"));
        residents.put("alex@gmail.com", new Resident("Alex", "alex@gmail.com", "password2"));
        residents.put("charles@gmail.com", new Resident("Charles", "charles@gmail.com", "password3"));

        intervenants.put("marie@outlook.com", new Intervenant("Marie", "marie@outlook.com", "password4"));
        intervenants.put("robert@outlook.com", new Intervenant("Robert", "robert@outlook.com", "password5"));
        intervenants.put("sofie@outlook.com", new Intervenant("Sofie", "sofie@outlook.com", "password6"));

        requetesTravail.add(new RequeteTravail("jean@gmail.com", "Réparer trottoir", "Trottoir endommagé devant chez moi", "Travaux routiers", "2025-01-31"));
        requetesTravail.add(new RequeteTravail("alex@gmail.com", "Réparer rue", "Rue endommagé devant chez moi", "Travaux routiers", "2025-01-31"));
        requetesTravail.add(new RequeteTravail("charles@gmail.com", "Remplacer panneau", "Remplacer un vieu panneau dans ma rue", "Travaux panneau", "2025-01-31"));
    }
}

