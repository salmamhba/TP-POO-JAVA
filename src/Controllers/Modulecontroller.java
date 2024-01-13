package Controllers;
import Phase1.Classes.Module;
import Services.Enseignantservice;
import Services.FiliereService;

import Services.Moduleservice;


public class Modulecontroller {


    public static void showMenu() {
        System.out.println("-------------------------[ Module ]---------------------------");

        System.out.println("1: Pour ajouter un module");
        System.out.println("2: Pour afficher les modules");
        System.out.println("3: Pour modifier un module");
        System.out.println("4: Pour supprimer un module");
        System.out.println("0: Pour retourner au menu principal");

        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                createModule();
                break;
            case 2:
                showModules();
                break;
            case 3:
                editModule();
                break;
            case 4:
                destroyModule();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    public static void showModules() {
        for (Module module : Moduleservice.getAllModules()) {
            System.out.print("Id : " + module.getId());
            System.out.print(" | Intitulé : " + module.getIntitule());
            System.out.println(" | Enseignant responsable : " + module.getProfesseur());
            System.out.println(" | Filiere : " + module.getFiliere());
        }
    }

    public static void createModule() {
        String intitule = Main.getStringInput("Entrez l'intitulé du module :");
        Enseignantcontroller.showEnseignants();
        int idEns = Main.getIntInput("Sélecionnez un enseignant par id :");
        Filierecontroller.showFilieres();
        int idF= Main.getIntInput("Sélecionnez une Filiere par ID :");

        Moduleservice.addModule(intitule, Enseignantservice.getEnsById(idEns),FiliereService.getFiliereById(idF));

        showModules();
        showMenu();
    }

    public static void editModule() {
        showModules();
        int id = Main.getIntInput("Sélectionnez un module par ID :");
        String newIntitule = Main.getStringInput("Entrez le nouvel intitulé du module :");
        Enseignantcontroller.showEnseignants();
        int idEns = Main.getIntInput("Sélecionnez un enseignant par id :");
        Filierecontroller.showFilieres();
        int idF= Main.getIntInput("Sélecionnez une Filiere par ID :");

        Moduleservice.updateModule(id, newIntitule, Enseignantservice.getEnsById(idEns),FiliereService.getFiliereById(idF));

        showModules();
        showMenu();
    }

    public static void destroyModule() {
        showModules();
        int id = Main.getIntInput("Sélectionnez un module par ID :");
        Moduleservice.deleteModuleById(id);
        showModules();
    }
}



