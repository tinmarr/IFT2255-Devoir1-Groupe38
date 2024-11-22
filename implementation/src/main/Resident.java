package main;

class Resident {
    private String nom;
    private String email;
    private String password;

    public Resident(String nom, String email, String password) {
        this.nom = nom;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

