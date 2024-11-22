package main;

class RequeteTravail {
    private String emailResident;
    private String titre;
    private String description;
    private String typeTravail;
    private String dateDebut;

    public RequeteTravail(String emailResident, String titre, String description, String typeTravail, String dateDebut) {
        this.emailResident = emailResident;
        this.titre = titre;
        this.description = description;
        this.typeTravail = typeTravail;
        this.dateDebut = dateDebut;
    }

    public String getEmailResident() {
        return emailResident;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getTypeTravail() {
        return typeTravail;
    }

    public String getDateDebut() {
        return dateDebut;
    }
}
