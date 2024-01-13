package Services;
import Phase1.Classes.Filiere;
import Phase1.Classes.Enseignant;
import Phase1.Classes.Departement;

import java.util.ArrayList;

public class FiliereService {

    public static Filiere addFiliere(String intitule, Enseignant responsable, Departement dept) {
        Filiere filiere = new Filiere(BaseDonnes.getFiliereById().getId(), intitule, responsable, dept);
        BaseDonnes.addFiliere(filiere);
        return filiere;
    }

    public static Filiere updateFiliere(int id, String intitule, Enseignant responsable, Departement dept) {
        Filiere filiere = new Filiere(id, intitule, responsable, dept);
        BaseDonnes.updateFiliere(id, filiere);
        return filiere;
    }

    public static ArrayList<Filiere> deleteFiliereById(int id) {
        BaseDonnes.deleteFiliereById(id);
        return null;
    }

    public static Filiere getFiliereById(int id) {
        Filiere filiere = BaseDonnes.getFiliereById();
        return filiere;
    }

    public static ArrayList<Filiere> getAllFilieres() {
        return BaseDonnes.getFilieres();
    }
}



