public class Employe implements CoutEvaluable {
    private String nom;
    private double coutParJour;

    public Employe(String nom, double coutParJour) {
        this.nom = nom;
        this.coutParJour = coutParJour;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public double getCout() {
        return coutParJour;
    }
}
