
package Controllers;
import Phase1.Classes.Departement;
import Services.BaseDonnes;
import Services.Departementservice;
import Services.Enseignantservice;


public class Departementcontroller {

    public static void showMenu(){
        System.out.println("-------------------------[ Départements ]---------------------------");


        System.out.println("1: Pour ajouter un département");
        System.out.println("2: Pour afficher les départements");
        System.out.println("3: Pour modifier un département");
        System.out.println("4: Pour supprimer un département");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createDepartement();
                break;
            case 2:
                showDepartements();
                break;
            case 3:
                editDepartement();
                break;
            case 4:
                destroyDepartement();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showDepartements(){
        for (Departement departement : Departementservice.getAllDept()) {
            System.out.print("Id : " + departement.getId());
            System.out.print(" | Intitulé : " + departement.getIntitule());
            if (! Main.isNull(departement.getResponsable())) {
                System.out.print(" | Responsable : " + departement.getResponsable().getNom() + " " + departement.getResponsable().getPrenom());
            }
            System.out.println(" ");
        }

    }
    public static void createDepartement(){
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        Enseignantcontroller.showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        Departementservice.addDept(intitule,Enseignantservice.getEnsById(id));

        showDepartements();
        showMenu();


    }
    public static void editDepartement(){
        showDepartements();
        int id = Main.getIntInput("Sélecionnez un departement par id :");
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        Enseignantcontroller.showEnseignants();
        int idEns = Main.getIntInput("Sélecionnez un enseignant par id :");

        Departementservice.updateDept(id, intitule, Enseignantservice.getEnsById(idEns));

        showDepartements();
        showMenu();
    }
    public static void destroyDepartement(){
        showDepartements();
        int id = Main.getIntInput("Sélecionnez un departement par id :");
        Departementservice.deleteDeptById(id);
        showDepartements();

    }

    public static Departement  getDeptById(int id){
        Departement departement = BaseDonnes.getDeptById(id);
        return departement;
    }
    }


