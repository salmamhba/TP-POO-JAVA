package Phase1.Classes;

public class Etudiant {
    private static String nom;
    private static String prenom;
    private int id;
    private static String email;
    private static int apogee;
    private static Filiere filiere;

    public Etudiant(int id, String nom, String prenom, String email, int apogee, Filiere filiere) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.apogee = apogee;
        this.filiere = filiere;

    }
    public Etudiant(){

    }
    public static String getNom() {
        return nom;
    }
    public void setNom(String nom) {

        this.nom = nom;
    }

    public static String getPrenom() {

        return prenom;
    }
    public void setPrenom(String prenom) {

        this.prenom = prenom;
    }

    public static String getEmail() {

        return email;
    }
    public void setEmail(String email) {

        this.email = email;
    }

    public static int getApogee() {

        return apogee;
    }
    public void setApogee(int apogee) {

        this.apogee = apogee;
    }

    public static Filiere getFiliere() {

        return filiere;
    }

    public void setFiliere(Filiere filiere) {

        this.filiere = filiere;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
    }
}
