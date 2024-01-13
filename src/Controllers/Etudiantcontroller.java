package Controllers;
import Phase1.Classes.Etudiant;
import Services.Etudiantservice;
import Services.FiliereService;
public class Etudiantcontroller {

    public static void showMenu(){
        System.out.println("-------------------------[ Etudiant ]---------------------------");

        System.out.println("1: Pour ajouter un étudiant");
        System.out.println("2: Pour afficher les étudiants");
        System.out.println("3: Pour modifier un étudiant");
        System.out.println("4: Pour supprimer un étudiant");
        System.out.println("0: Pour retourner au menu principal");

        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createEtudiant();
                break;
            case 2:
                showEtudiants();
                break;
            case 3:
                editEtudiant();
                break;
            case 4:
                destroyEtudiant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    public static void showEtudiants(){
        for (Etudiant etudiant : Etudiantservice.getAllEtd()) {
            System.out.print("Id : " + etudiant.getId());
            System.out.print(" | Nom : " + etudiant.getNom() + " " + etudiant.getPrenom());
            System.out.print(" | Email : " + etudiant.getEmail() );
            System.out.print(" | Apogee : " + etudiant.getApogee() );
            System.out.print(" | Filiere : " + etudiant.getFiliere() );
        }
    }

    public static void createEtudiant(){
        String nom = Main.getStringInput("Entrez le nom :");
        String prenom = Main.getStringInput("Entrez le prénom :");
        String email = Main.getStringInput("Entrez l'email :");
        int apogee = Main.getIntInput("Entrez l'Apogee :");
        String filiere = Main.getStringInput("Entrez la filière :");

        Filierecontroller.showFilieres();
        int id = Main.getIntInput("Sélecionnez une filiere par id :");
        Etudiantservice.addEtd(nom, prenom, email, apogee, FiliereService.getFiliereById(id));

        showEtudiants();
        showMenu();
    }

    public static void editEtudiant (){
        showEtudiants();
        int id = Main.getIntInput("Sélectionnez un étudiant par ID :");

        String nom = Main.getStringInput("Entrez le nouveau nom :");
        String prenom = Main.getStringInput("Entrez le nouveau prénom :");
        String email = Main.getStringInput("Entrez le nouvel email :");
        String apogee = Main.getStringInput("Entrez le nouveau niveau :");
        String filiere = Main.getStringInput("Entrez la nouvelle filière :");

        Filierecontroller.showFilieres();
        int idF = Main.getIntInput("Sélecionnez une filiere par id :");

        Etudiantservice.updateEtd(id, nom, prenom, email, Integer.parseInt(apogee), FiliereService.getFiliereById(idF));

        showEtudiants();
        showMenu();
    }

    public static void destroyEtudiant(){
        showEtudiants();
        int id = Main.getIntInput("Sélectionnez un étudiant par ID :");
        Etudiantservice.deleteEtdById(id);
        showEtudiants();
    }
}


