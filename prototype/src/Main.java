import java.util.*;
import java.time.LocalDate;
import java.time.Period;

/*class User {
    protected String fullName;
    protected String email;
    protected String password;
    protected String address;
    protected String phoneNumber;

    public User(String fullName, String email, String password, String address, String phoneNumber) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}

class Resident extends User {
    private LocalDate dateOfBirth;
    private List<String> subscribedNotifications;

    public Resident(String fullName, LocalDate dateOfBirth, String email, String password, String address, String phoneNumber) {
        super(fullName, email, password, address, phoneNumber);
        this.dateOfBirth = dateOfBirth;
        this.subscribedNotifications = new ArrayList<>();
        this.subscribedNotifications.add(getNeighborhood(address)); // Auto-subscribe to neighborhood
    }

    private String getNeighborhood(String address) {
        // Logique pour déterminer le quartier à partir de l'adresse
        return "Quartier par défaut";
    }

    public void subscribeToNotification(String location) {
        subscribedNotifications.add(location);
    }
}

class Intervenant extends User {
    public Intervenant(String fullName, String email, String password, String address, String phoneNumber) {
        super(fullName, email, password, address, phoneNumber);
    }
}

class Problem {
    private String residentName;
    private String email;
    private String address;
    private String problemType;
    private String description;

    public Problem(String residentName, String email, String address, String problemType, String description) {
        this.residentName = residentName;
        this.email = email;
        this.address = address;
        this.problemType = problemType;
        this.description = description;
    }
}


    class WorkRequest {
        private String title;
        private String description;
        private String type;
        private LocalDate expectedStartDate;

        public WorkRequest(String title, String description, String type, LocalDate expectedStartDate) {
            this.title = title;
            this.description = description;
            this.type = type;
            this.expectedStartDate = expectedStartDate;
        }

        // Ajout des getters
        public String getTitle() {
            return title;
        }

        public String getType() {
            return type;
        }

        public LocalDate getExpectedStartDate() {
            return expectedStartDate;
        }
    }

public class Main {
    private static Map<String, User> users = new HashMap<>();
    private static List<Problem> problems = new ArrayList<>();
    private static List<WorkRequest> workRequests = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Se connecter");
            System.out.println("2. S'inscrire comme résident");
            System.out.println("3. Quitter");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    login();
                    residentMenu();
                    break;
                case 2:
                    registerResident();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    private static void login() {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String password = scanner.nextLine();

        User user = users.get(email);
        if (user != null && user.password.equals(password)) {
            if (user instanceof Resident) {
                residentMenu();
            } else if (user instanceof Intervenant) {
                intervenantMenu((Intervenant) user);
            }
        } else {
            System.out.println("Email ou mot de passe incorrect.");
        }
    }

    private static void registerResident() {
        System.out.print("Nom complet: ");
        String fullName = scanner.nextLine();

        System.out.print("Date de naissance (YYYY-MM-DD): ");
        LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());

        if (Period.between(dateOfBirth, LocalDate.now()).getYears() < 16) {
            System.out.println("Vous devez avoir au moins 16 ans pour vous inscrire.");
            return;
        }

        System.out.print("Email: ");
        String email = scanner.nextLine();

        if (users.containsKey(email)) {
            System.out.println("Cet email est déjà utilisé.");
            return;
        }

        System.out.print("Mot de passe: ");
        String password = scanner.nextLine();

        System.out.print("Adresse: ");
        String address = scanner.nextLine();

        System.out.print("Téléphone (optionnel): ");
        String phoneNumber = scanner.nextLine();

        Resident resident = new Resident(fullName, dateOfBirth, email, password, address, phoneNumber);
        users.put(email, resident);
        System.out.println("Inscription réussie!");
    }

    private static void residentMenu() {
        while (true) {
            System.out.println("\nMenu Résident:");
            System.out.println("1. Signaler un problème");
            System.out.println("2. Consulter un travail en cours");
            System.out.println("3. Rechercher des travaux");
            System.out.println("4. Modifier les notifications");
            System.out.println("5. Soumettre une requête de travail");
            System.out.println("6. Retour au menu principal");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Option 'Signaler un problème' sélectionnée.");
                    break;
                case 2:
                    System.out.println("Option 'Consulter un travail en cours' sélectionnée.");
                    break;
                case 3:
                    System.out.println("Option 'Rechercher des travaux' sélectionnée.");
                    break;
                case 4:
                    System.out.println("Option 'Modifier les notifications' sélectionnée.");
                    break;
                case 5:
                    System.out.println("Option 'Soumettre une requête de travail' sélectionnée.");
                    break;
                case 6:
                    System.out.println("Retour au menu principal.");
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    private static void intervenantMenu(Intervenant intervenant) {
        System.out.println("Menu Intervenant: Fonctionnalités non implémentées dans ce prototype.");
    }

    private static void reportProblem(Resident resident) {
        System.out.print("Type de problème: ");
        String problemType = scanner.nextLine();

        System.out.print("Description du problème: ");
        String description = scanner.nextLine();

        Problem problem = new Problem(resident.fullName, resident.email, resident.address, problemType, description);
        problems.add(problem);
        System.out.println("Problème signalé avec succès.");
    }

    private static void submitWorkRequest(Resident resident) {
        System.out.print("Titre du travail: ");
        String title = scanner.nextLine();

        System.out.print("Description détaillée: ");
        String description = scanner.nextLine();

        System.out.print("Type de travail: ");
        String type = scanner.nextLine();

        System.out.print("Date de début espérée (YYYY-MM-DD): ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());

        WorkRequest workRequest = new WorkRequest(title, description, type, startDate);
        workRequests.add(workRequest);
        System.out.println("Requête de travail soumise avec succès.");
    }

    private static void manageNotifications(Resident resident) {
        System.out.print("Entrez le quartier ou la rue pour les notifications: ");
        String location = scanner.nextLine();
        resident.subscribeToNotification(location);
        System.out.println("Abonnement aux notifications pour " + location + " réussi.");
    }

    private static void searchWorks() {
        System.out.print("Recherche (titre, type ou quartier): ");
        String search = scanner.nextLine().toLowerCase();

        for (WorkRequest work : workRequests) {
            if (work.getTitle().toLowerCase().contains(search) ||
                    work.getType().toLowerCase().contains(search)) {
                System.out.println(work.getTitle() + " - " + work.getType() + " - " + work.getExpectedStartDate());
            }
        }
    }

    private static void viewUpcomingWorks() {
        LocalDate threeMonthsLater = LocalDate.now().plusMonths(3);

        System.out.println("Travaux pour les 3 prochains mois:");
        for (WorkRequest work : workRequests) {
            if (work.getExpectedStartDate().isBefore(threeMonthsLater)) {
                System.out.println(work.getTitle() + " - " + work.getType() + " - " + work.getExpectedStartDate());
            }
        }
    }
}
*/