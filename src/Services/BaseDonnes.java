package Services;
import Phase1.Classes.*;
import Phase1.Classes.Module;
 import java.sql.*;

import java.util.ArrayList;


public class BaseDonnes {

    public static int DEPT_ID = 0;
    public static int ENS_ID = 0;
    public static int ETD_ID = 0;
    public static int FIL_ID = 0;
    public static int MOD_ID = 0;
    public static ArrayList<Departement> departements = new ArrayList<Departement>();
    public static ArrayList<Enseignant> enseignants = new ArrayList<Enseignant>();
    public static ArrayList<Filiere> filieres = new ArrayList<Filiere>();
    public static ArrayList<Module> modules = new ArrayList<Module>();
    public static ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
    private static int id;


    public  static int getDeptId(){
        DEPT_ID++;
        return DEPT_ID;
    }
    public  static int getEnsId(){
        ENS_ID++;
        return ENS_ID;
    }

    public static ArrayList<Departement> getDepartements() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-shema","root","19Salouma")) {
            String sql = "SELECT * FROM departement";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");
                int apogee = resultSet.getInt("apogee");
                int filiere_id = resultSet.getInt("filiere_id");
                Filiere filiere = FiliereService.getFiliereById(filiere_id);
                Departement departement = new Departement();
                departements.add(departement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departements;
    }

    public static ArrayList<Enseignant> getEnseignants() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-shema","root","19Salouma")) {
            String sql = "SELECT * FROM enseignant";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");
                String grade = resultSet.getString("grade");
                int departement_id = resultSet.getInt("departement_id");
                Departement departement = Departementservice.getDeptById(departement_id);
                Enseignant enseignant = new Enseignant(id, nom, prenom, email, grade, departement);
                enseignants.add(enseignant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return enseignants;
    }

    public static ArrayList<Filiere> getFilieres() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-shema","root","19Salouma")) {
            String sql = "SELECT * FROM filiere";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String intitule = resultSet.getString("intitule");
                int departement_id = resultSet.getInt("departement_id");
                Departement departement = Departementservice.getDeptById(departement_id);
                Filiere filiere = new Filiere();
                filieres.add(filiere);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return filieres;
    }

    public static ArrayList<Module> getModules() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-shema","root","19Salouma")) {
            String sql = "SELECT * FROM module";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String intitule = resultSet.getString("intitule");
                int enseignant_id = resultSet.getInt("enseignant_id");
                Enseignant enseignant = Enseignantservice.getEnsById(enseignant_id);
                Module module = new Module();
                modules.add(module);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modules;
    }

    public static ArrayList<Etudiant> getEtudiants() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-shema","root","19Salouma")) {
            String sql = "SELECT * FROM etudiant";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");
                int apogee = resultSet.getInt("apogee");
                int filiere_id = resultSet.getInt("filiere_id");
                Filiere filiere = FiliereService.getFiliereById(filiere_id);
                Etudiant etudiant = new Etudiant();
                etudiants.add(etudiant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return etudiants;
    }

    // add methods for crate update delete and get by id on database
    public static void addDept(Departement departement) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-shema", "root", "19Salouma")) {
            String sql = "INSERT INTO departement (intitule, responsable_id) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, departement.getIntitule());
            statement.setInt(2, departement.getResponsable().getId());

            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("A new department was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void updateDept(int id, Departement departement) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-shema", "root", "19Salouma")) {
            String sql = "UPDATE departement SET intitule = ?, responsable_id = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, departement.getIntitule());
            statement.setInt(2, departement.getResponsable().getId());
            statement.setInt(3, id);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("A department was updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void deleteDeptById(int id) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-shema","root","19Salouma")) {
            String sql = "DELETE FROM departement WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("A departement was deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Departement getDeptById(int id) {
        Departement departement = null;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-shema","root","19Salouma")) {
            String sql = "SELECT * FROM departement WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");
                int apogee = resultSet.getInt("apogee");
                int filiere_id = resultSet.getInt("filiere_id");
                Filiere filiere = FiliereService.getFiliereById(filiere_id);
                departement = new Departement();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departement;
    }

    public static void addEns(Enseignant enseignant) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-shema","root","19Salouma")) {
            String sql = "INSERT INTO enseignant (nom, prenom, email, grade, departement_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, enseignant.getNom());
            statement.setString(2, enseignant.getPrenom());
            statement.setString(3, enseignant.getEmail());
            statement.setString(4, enseignant.getGrade());
            statement.setInt(5, enseignant.getDepartement().getId());
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("A new enseignant was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateEns(int id, Enseignant enseignant) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-shema","root","19Salouma")) {
            String sql = "UPDATE enseignant SET nom = ?, prenom = ?, email = ?, grade = ?, departement_id = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, enseignant.getNom());
            statement.setString(2, enseignant.getPrenom());
            statement.setString(3, enseignant.getEmail());
            statement.setString(4, enseignant.getGrade());
            statement.setInt(5, enseignant.getDepartement().getId());
            statement.setInt(6, id);
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("A enseignant was updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteEnsById(int id) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-shema","root","19Salouma")) {
            String sql = "DELETE FROM enseignant WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("A enseignant was deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Enseignant getEnsById(int id) {
        Enseignant enseignant = null;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-shema","root","19Salouma")) {
            String sql = "SELECT * FROM enseignant WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");
                String grade = resultSet.getString("grade");
                int departement_id = resultSet.getInt("departement_id");
                Departement departement = Departementservice.getDeptById(departement_id);
                enseignant = new Enseignant(id, nom, prenom, email, grade, departement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return enseignant;
    }

    public static void addFiliere(Filiere filiere) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-shema","root","19Salouma")) {
            String sql = "INSERT INTO filiere (intitule, departement_id) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, filiere.getIntitule());
            statement.setInt(2, filiere.getDepartement().getId());
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("A new filiere was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateFiliere(int id, Filiere filiere) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-shema","root","19Salouma")) {
            String sql = "UPDATE filiere SET intitule = ?, departement_id = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, filiere.getIntitule());
            statement.setInt(2, filiere.getDepartement().getId());
            statement.setInt(3, id);
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("A filiere was updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFiliereById(int id) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-shema","root","19Salouma")) {
            String sql = "DELETE FROM filiere WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("A filiere was deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Filiere getFiliereById() {
        Filiere filiere = null;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-shema","root","19Salouma")) {
            String sql = "SELECT * FROM filiere WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String intitule = resultSet.getString("intitule");
                int departement_id = resultSet.getInt("departement_id");
                Departement departement = Departementservice.getDeptById(departement_id);
                filiere = new Filiere();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return filiere;
    }

    public static void addModule(Module module) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-shema","root","19Salouma")) {
            String sql = "INSERT INTO module (intitule, enseignant_id) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, module.getIntitule());
            statement.setInt(2, module.getProfesseur().getId());
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("A new module was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateModule(int id, Module module) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-shema","root","19Salouma")) {
            String sql = "UPDATE module SET intitule = ?, enseignant_id = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, module.getIntitule());
            statement.setInt(2, module.getProfesseur().getId());
            statement.setInt(3, id);
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("A module was updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteModuleById(int id) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-shema","root","19Salouma")) {
            String sql = "DELETE FROM module WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("A module was deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Module getModuleById() {
        Module module = null;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-shema","root","19Salouma")) {
            String sql = "SELECT * FROM module WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String intitule = resultSet.getString("intitule");
                int enseignant_id = resultSet.getInt("enseignant_id");
                Enseignant enseignant = Enseignantservice.getEnsById(enseignant_id);
                module = new Module();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return module;
    }

    public static void addEtd(Etudiant etudiant) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-shema","root","19Salouma")) {
            String sql = "INSERT INTO etudiant (id,nom, prenom, email, apogee, filiere) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, etudiant.getId());
            statement.setString(2, etudiant.getNom());
            statement.setString(3, etudiant.getPrenom());
            statement.setString(4, etudiant.getEmail());
            statement.setInt(5, etudiant.getApogee());
            statement.setString(6, String.valueOf(etudiant.getFiliere ()));
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("A new etudiant was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateEtd(int id, Etudiant etudiant) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-shema","root","19Salouma")) {
            String sql = "UPDATE etudiant SET nom = ?, prenom = ?, email = ?, apogee = ?, filiere = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, etudiant.getNom());
            statement.setString(2, etudiant.getPrenom());
            statement.setString(3, etudiant.getEmail());
            statement.setInt(4, etudiant.getApogee());
            statement.setString(5, String.valueOf(etudiant.getFiliere()));
            statement.setInt(6, id);
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("A etudiant was updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteEtdById(int id) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-shema","root","19Salouma")) {
            String sql = "DELETE FROM etudiant WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("A etudiant was deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Etudiant getEtdById() {
        Etudiant etudiant = null;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-shema","root","19Salouma")) {
            String sql = "SELECT * FROM etudiant WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");
                int apogee = resultSet.getInt("apogee");
                int filiere_id = resultSet.getInt("filiere_id");
                Filiere filiere = FiliereService.getFiliereById(filiere_id);
                etudiant = new Etudiant();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return etudiant;
    }
}

