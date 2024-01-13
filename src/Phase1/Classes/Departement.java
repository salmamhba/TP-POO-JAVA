package Phase1.Classes;

public class Departement {
    private int id;
    private String intitule;
    private Enseignant responsable;

    public Departement(int id, String intitule, Enseignant responsable) {
        this.id = id;
        this.intitule = intitule;
        this.responsable = responsable;
    }
    public Departement(){

    }
    // Getters et setters
    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {

        this.intitule = intitule;
    }

    public Enseignant getResponsable() {

        return responsable;
    }

    public void setResponsable(Enseignant responsable) {

        this.responsable = responsable;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

