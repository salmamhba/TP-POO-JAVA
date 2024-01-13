
package Services;
import Phase1.Classes.Enseignant;
import Phase1.Classes.Departement;
import Services.BaseDonnes;


import java.util.ArrayList;


public class Enseignantservice {

    public static Enseignant addEns(String nom, String prenom, String email, String grade, Departement dept){
        Enseignant enseignant = new Enseignant(BaseDonnes.getEnsId(), nom, prenom, email, grade, dept);
        BaseDonnes.addEns(enseignant);
        return enseignant;
    }

    public static Enseignant updateEns(int id,String nom, String prenom, String email, String grade, Departement dept){
        Enseignant enseignant = new Enseignant(id, nom, prenom, email, grade, dept);
        BaseDonnes.updateEns(id, enseignant);
        return enseignant;
    }

    public static ArrayList<Enseignant> deleteEnsById(int id){
        BaseDonnes.deleteEnsById(id);
        return null;
    }

    public static Enseignant getEnsById(int id){
        Enseignant enseignant = BaseDonnes.getEnsById(id);
        return enseignant;
    }

    public static ArrayList<Enseignant> getAllEns(){
        return BaseDonnes.getEnseignants();
    }
}






