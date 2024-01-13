package Phase1.Classes;

    public class Filiere {
        private String intitule;
        private Enseignant responsable;
        private Departement departement;
        private int id;

        public Filiere(int id, String intitule, Enseignant responsable, Departement departement) {
            this.id = id;
            this.intitule = intitule;
            this.responsable = responsable;
            this.departement = departement;
        }
        public Filiere(){

        }
        public String getIntitule() {
            return intitule;
        }
        public void setIntitule(String intitule) {
            this.intitule = intitule;
        }

        public Enseignant getResponsable() {

            return responsable;
        }
        public void setResponsable(Enseignant responsable) {

            this.responsable = responsable;
        }


        public Departement getDepartement() {

            return departement;
        }
        public void setDepartement(Departement departement) {

            this.departement = departement;
        }
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
