package Controllers;
import Phase1.Classes.Enseignant;
import Services.Departementservice;
import Services.Enseignantservice;
import Services.BaseDonnes;

public class Enseignantcontroller {

    public static void showMenu(){
        System.out.println("-------------------------[ Enseignant ]---------------------------");


        System.out.println("1: Pour ajouter un enseignant");
        System.out.println("2: Pour afficher les enseignants");
        System.out.println("3: Pour modifier un enseignant");
        System.out.println("4: Pour supprimer un ensignant");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createEnseignant();
                break;
            case 2:
                showEnseignants();
                break;
            case 3:
                editEnseignant();
                break;
            case 4:
                destroyEnseignant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    public static void showEnseignants(){
        for (Enseignant enseignant : Enseignantservice.getAllEns()) {
            System.out.print("Id : " + enseignant.getId());
            System.out.print(" | Nom : " + enseignant.getNom() + " " + enseignant.getPrenom());
            System.out.print(" | Email : " + enseignant.getEmail() );
            System.out.print(" | Grade : " + enseignant.getGrade() );
            System.out.print(" | Departement : " + enseignant.getDepartement() );
        }
    }
    public static void createEnseignant(){
        String nom = Main.getStringInput("Entrez le nom :");
        String prenom = Main.getStringInput("Entrez le prénom :");
        String email = Main.getStringInput("Entrez l'email :");
        String grade = Main.getStringInput("Entrez le grade :");

        Departementcontroller.showDepartements();
        int id = Main.getIntInput("Sélecionnez un departement par id :");
        Enseignantservice.addEns(nom, prenom, email, grade, Departementcontroller.getDeptById(id));

        showEnseignants();
        showMenu();



    }
    public static void editEnseignant(){
        showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        String nom = Main.getStringInput("Entrez le nom:");
        String prenom= Main.getStringInput("Entrez le prenom:");
        String email= Main.getStringInput("Entrez le mail:");
        String grade= Main.getStringInput("Entrez le grade:");


        Departementcontroller.showDepartements();
        int idDept = Main.getIntInput("Sélecionnez une departement par id :");

        Enseignantservice.updateEns(id, nom, prenom, email, grade, Departementservice.getDeptById(idDept));

        showEnseignants();
        showMenu();

    }
    public static void destroyEnseignant(){
        showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        Enseignantservice.deleteEnsById(id);
        showEnseignants();

    }
}


