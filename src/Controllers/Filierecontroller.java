package Controllers;
import Phase1.Classes.Filiere;
import Services.Departementservice;
import Services.Enseignantservice;
import Services.FiliereService;


public class Filierecontroller {

    public static void showMenu() {
        System.out.println("-------------------------[ Filière ]---------------------------");

        System.out.println("1: Pour ajouter une filière");
        System.out.println("2: Pour afficher les filières");
        System.out.println("3: Pour modifier une filière");
        System.out.println("4: Pour supprimer une filière");
        System.out.println("0: Pour retourner au menu principal");

        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                createFiliere();
                break;
            case 2:
                showFilieres();
                break;
            case 3:
                editFiliere();
                break;
            case 4:
                destroyFiliere();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    public static void showFilieres() {
        for (Filiere filiere : FiliereService.getAllFilieres()) {
            System.out.print("Id : " + filiere.getId());
            System.out.print(" | Intitulé : " + filiere.getIntitule());
            System.out.println("le responsable :" + filiere.getResponsable());
            System.out.println("le departement :" + filiere.getDepartement());
        }
    }

    public static void createFiliere() {
        String intitule = Main.getStringInput("Entrez l'intitulé de la filière :");
        Enseignantcontroller.showEnseignants();
        int idEns = Main.getIntInput("Sélecionnez un enseignant par id :");
        Departementcontroller.showDepartements();
        int idd = Main.getIntInput("Sélecionnez un departement par id :");

        FiliereService.addFiliere(intitule, Enseignantservice.getEnsById(idEns), Departementservice.getDeptById(idd));


        showFilieres();
        showMenu();
    }

    public static void editFiliere() {
        showFilieres();
        int id = Main.getIntInput("Sélectionnez une filière par ID :");
        String newIntitule = Main.getStringInput("Entrez le nouvel intitulé de la filière :");
        Enseignantcontroller.showEnseignants();
        int idEns = Main.getIntInput("Sélectionnez un enseignant par ID :");
        Departementcontroller.showDepartements();
        int idd = Main.getIntInput("Sélectionnez un departement par ID :");
        FiliereService.updateFiliere(id, newIntitule, Enseignantservice.getEnsById(idEns), Departementservice.getDeptById(idd));

        showFilieres();
        showMenu();
    }


    public static void destroyFiliere() {
        showFilieres();
        int id = Main.getIntInput("Sélectionnez une filière par ID :");
        FiliereService.deleteFiliereById(id);
        showFilieres();
    }
}


