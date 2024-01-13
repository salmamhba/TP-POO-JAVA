package Phase2;

import java.sql.*;

public class MyJDBC {


    /* Informations de connexion à la base de données
        static final String URL = "jdbc:mysql://localhost:3306/universite";
        static final String USER = "root";
        static final String PASSWORD = "password";*/
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-shema", "root", "19Salouma")) {
            createEnseignantTable(connection);
            insertSampleEnseignantData(connection);
            createDepartementTable(connection);
            insertSampleDepartementData(connection);
            createFiliereTable(connection);
            insertSampleFiliereData(connection);
            createEtudiantTable(connection);
            insertSampleEtudiantData(connection);
            createModuleTable(connection);
            insertSampleModuleData(connection);




        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createEnseignantTable(Connection connection) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS Enseignant (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "nom VARCHAR(45)," +
                "prenom VARCHAR(45)," +
                "email VARCHAR(45)," +
                "grade VARCHAR(45)," +
                "departement_id INT," +
                "FOREIGN KEY (departement_id) REFERENCES Departement(id)" +
                ")";

        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
        }
    }



    public static void insertSampleEnseignantData(Connection connection) throws SQLException {
        String insertQuery = "INSERT INTO Enseignant (nom, prenom, email, grade, departement_id) VALUES " +
                "('mhb', 'salim', 'salimmhb@example.com', 'Prof', 1)," +
                "('mari', 'hadi', 'hadimari@example.com', 'Maître de conférences', 2)";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(insertQuery);
        }
    }
    public static void createDepartementTable(Connection connection) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS Departement (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "intitule VARCHAR(255)," +
                "responsable_id INT," +
                "FOREIGN KEY (responsable_id) REFERENCES Enseignant(id)" +
                ")";

        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
        }
    }
    public static void insertSampleDepartementData(Connection connection) throws SQLException {
        String insertQuery = "INSERT INTO Departement (intitule, responsable_id) VALUES " +
                "('Informatique', 1)," +
                "('Mathématiques', 2)," +
                "('Physique', 3)";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(insertQuery);
        }
    }



    public static void createFiliereTable(Connection connection) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS Filiere (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "intitule VARCHAR(255)," +
                "responsable_id INT," +
                "departement_id INT," +
                "FOREIGN KEY (responsable_id) REFERENCES Enseignant(id)," +
                "FOREIGN KEY (departement_id) REFERENCES Departement(id)" +
                ")";

        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
        }
    }
    public static void insertSampleFiliereData(Connection connection) throws SQLException {
        String insertQuery = "INSERT INTO Filiere (intitule, responsable_id, departement_id) VALUES " +
                "('Informatique', 1, 1)," +
                "('Mathématiques', 2, 2)," +
                "('Physique', 3, 3)";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(insertQuery);
        }
    }
    public static void createEtudiantTable(Connection connection) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS Etudiant (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "nom VARCHAR(45)," +
                "prenom VARCHAR(45)," +
                "email VARCHAR(45)," +
                "apogee INT," +
                "filiere_id INT," +
                "FOREIGN KEY (filiere_id) REFERENCES Filiere(id)" +
                ")";

        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
        }
    }

    public static void insertSampleEtudiantData(Connection connection) throws SQLException {
        String insertQuery = "INSERT INTO Etudiant (nom, prenom, email, apogee, filiere_id) VALUES " +
                "('ahmed', 'mouhib', 'ahmed.mhb@example.com', 123456, 1)," +
                "('aymen', 'mouhibe', 'aymen.mhbe@example.com', 789012, 2)," +
                "('leila', 'toubir', 'leila.tbr@example.com', 345678, 1)";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(insertQuery);
        }
    }



    public static void createModuleTable(Connection connection) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS Module (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "intitule VARCHAR(255)," +
                "filiere_id INT," +
                "professeur_id INT," +
                "FOREIGN KEY (filiere_id) REFERENCES Filiere(id)," +
                "FOREIGN KEY (professeur_id) REFERENCES Enseignant(id)" +
                ")";

        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
        }
    }
    public static void insertSampleModuleData(Connection connection) throws SQLException {
        String insertQuery = "INSERT INTO Module (intitule, filiere_id, professeur_id) VALUES " +
                "('php', 1, 1)," +
                "('statistique', 2, 2)," +
                "('elecricite', 3, 3)";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(insertQuery);
        }
    }





}
