package main;

class Intervenant {
    private String nom;
    private String email;
    private String password;

    public Intervenant(String nom, String email, String password) {
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
