public class Orque extends Animal {
    public static final double QTE_VIANDE_PAR_KILO = 0.1;

	public Orque(String name, double poids) {
		super(name, poids, new RegimeCarnivore(poids * QTE_VIANDE_PAR_KILO) );
	}

	public Orque(String name, double poids, Animal pere, Animal mere) {
		super(name, poids, pere, mere);
	}

	@Override
	public String getCri() {
		return "sifflement";
	}

  // lorsque le poids de l'orque change, la quantité de viande qu'il mange doit etre modifée
  @Override
  public void setPoids(double poids) {
    super.setPoids(poids);
    // Création du nouveau régime de l'orque
    this.regime = new RegimeCarnivore(poids * QTE_VIANDE_PAR_KILO);
  }

	@Override
	public String toString() {
		return "Je suis un orque " + super.toString() ;
	}

}
