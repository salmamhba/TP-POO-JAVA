package Services;
import Phase1.Classes.Departement;
import Phase1.Classes.Enseignant;

import java.util.ArrayList;


public class Departementservice {


    public static Departement addDept(String intitule, Enseignant responsable){
        Departement departement = new Departement(BaseDonnes.getDeptId(), intitule, responsable);
        BaseDonnes.addDept(departement);
        return departement;
    }

    public static Departement updateDept(int id,String intitule, Enseignant responsable){
        Departement departement = new Departement(id, intitule, responsable);
        BaseDonnes.updateDept(id, departement);
        return departement;
    }
    public static ArrayList<Departement> deleteDeptById(int id){
        BaseDonnes.deleteDeptById(id);
        return null;
    }


    public static Departement  getDeptById(int id){
        Departement departement = BaseDonnes.getDeptById(id);
        return departement;
    }

    public static ArrayList<Departement> getAllDept(){
        return BaseDonnes.getDepartements();
    }
}



