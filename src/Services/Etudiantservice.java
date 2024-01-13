package Services;
import Phase1.Classes.Etudiant;
import Phase1.Classes.Filiere;

import java.util.ArrayList;


public class Etudiantservice {


    public static Etudiant addEtd(String nom, String prenom, String email, int apogee, Filiere filiere){
        Etudiant etudiant = new Etudiant(BaseDonnes.getEtdById().getId(),nom, prenom, email, apogee, filiere);
        BaseDonnes.addEtd(etudiant);
        return etudiant;
    }

    public static Etudiant updateEtd(int id, String nom, String prenom, String email, int apogee, Filiere filiere){
        Etudiant etudiant = new Etudiant(id, nom, prenom, email, apogee, filiere);
        BaseDonnes.updateEtd(id, etudiant);
        return etudiant;
    }

    public static ArrayList<Etudiant> deleteEtdById(int id){
        BaseDonnes.deleteEtdById(id);
        return null;
    }

    public static Etudiant getEtdById(int id){
        Etudiant etudiant = BaseDonnes.getEtdById();
        return etudiant;
    }

    public static ArrayList<Etudiant> getAllEtd(){
        return BaseDonnes.getEtudiants();
    }
}


