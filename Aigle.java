
public class Aigle extends Animal {
	double envergure;
    public static final int QTE_VIANDE_DEFAUT = 1 ;
    // par défaut, un aigle mange 1kg de viande / jour

	public Aigle(String name, double poids, double envergure, int qteDeViande) {
		super(name, poids, new RegimeCarnivore(qteDeViande) );
		this.envergure = envergure;
	}

    // par défaut, un aigle mange 1kg de viande / jour
    // => on surcharge le constructeur
	public Aigle(String name, double poids, double envergure) {
		this(name, poids, envergure, QTE_VIANDE_DEFAUT);
	}

	public Aigle(String name, double poids, Aigle pere, Aigle mere) {
		super(name, poids, pere, mere);
	}

	@Override
	public String getCri() {
		return "sifflement";
	}

	@Override
	public String toString() {
		return "Je suis un aigle " + super.toString() + "; envergure : " + envergure;
	}

}
