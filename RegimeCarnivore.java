
public class RegimeCarnivore extends Regime {
	private double qteViande;
	// ici, dans la vraie vie, on définirait d'autres attributs
	// qui caractérisent un régime carnivoire.:
	//Par ex. une chaine de caractère précisant le type de viande préférée de la bestiole.

	public RegimeCarnivore(double qteDeViande) {
		// super() ; // appel de super(); sous entendu
		this.qteViande = qteDeViande;
	}

	public double getQteViande() {
		return qteViande;
	}

	public void updateQteViante(double qteDeViande) {
		if(qteViande <= 0) {
			throw new IllegalArgumentException("qte viande ne peut etre négatif");
		}
		this.qteViande = qteDeViande;
	}

	@Override
	public double getCout() {
		return (getQteViande()*10)*(getQteViande()*10)+100;
	}

	@Override
	public String toString() {
		return "Carnivore, qte viande " + qteViande + " cout : " + getCout();
	}
}
