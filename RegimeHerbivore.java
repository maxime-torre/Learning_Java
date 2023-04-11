
public class RegimeHerbivore extends Regime {
	private double quantiteLegumes;
	// ici, dans la vraie vie, on définirait d'autres attributs
	// qui caractérisent un régime carnivoire.:
	//Par ex. une chaine de caractère précisant le type de végétaux préférée de la bestiole.

	public RegimeHerbivore(double quantite) {
		// super() ; // appel de super(); sous entendu
		this.quantiteLegumes = quantite;
	}

	public double getQuantiteLegumes() {
		return quantiteLegumes;
	}

	@Override
	public double getCout() {
		return 1.2 * Math.log( (getQuantiteLegumes()+5)*2+1);
	}

	@Override
	public String toString() {
		return "Herbivore, qte de legumes " + quantiteLegumes + " cout : " + getCout();
	}
}
