import java.util.*;
import java.time.LocalDate;

public class MainTwo {
    private static List<User> users = new ArrayList<>();
    private static List<Intervenant> intervenants = new ArrayList<>();

    public static void main(String[] args) {
        // Add some sample users and intervenants
        users.add(new Resident("John Doe", LocalDate.of(1990, 1, 1), "john@example.com", "password123", "123 Main St", "555-1234"));
        intervenants.add(new Intervenant("Jane Smith", "jane@example.com", "password456", "456 Elm St", "555-5678"));

        // Launch the main GUI
        new MainGUI(users, intervenants);
    }
}

class User {
    private String fullName;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;

    public User(String fullName, String email, String password, String address, String phoneNumber) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
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
        // Logic to determine the neighborhood from the address
        return "Default Neighborhood";
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