package Services;
import Phase1.Classes.Enseignant;
import Phase1.Classes.Filiere;
import Phase1.Classes.Module;
import java.util.ArrayList;
public class Moduleservice {

    public static Module addModule(String intitule, Enseignant responsable,  Filiere filiere) {
        Module module = new Module(BaseDonnes.getModuleById().getId(), intitule, filiere, responsable);
        BaseDonnes.addModule(module);
        return module;
    }

    public static Module updateModule(int id, String intitule, Enseignant responsable, Filiere filiere) {
        Module module = new Module(id, intitule, filiere, responsable);
        BaseDonnes.updateModule(id, module);
        return module;
    }

    public static ArrayList<Module> deleteModuleById(int id) {
        BaseDonnes.deleteModuleById(id);
        return null;
    }

    public static Module getModuleById(int id) {
        Module module = BaseDonnes.getModuleById();
        return module;
    }

    public static ArrayList<Module> getAllModules() {
        return BaseDonnes.getModules();
    }

}

