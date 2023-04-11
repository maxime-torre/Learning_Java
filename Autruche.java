public class Autruche extends Animal {
	private int nbPlumes;

	// Sujet : le regime de toutes les autruches est toujours le même pour toutes les autruches.
	// Donc : le régime des autruches peut être vu comme une propriété
	//        de la CLASSE autruche => attribut de classe, static
	// Intéret conceptuel : c'est propre par rapport au sujet !
	// Intérêt technique : cela évite d'alouer un objet régime
	//     pour chaque autruche, tous ces objets occupant
	//     de la mémoire pour rien puisqu'ils seraient identiques !
	private static RegimeHerbivore REGIME_DES_AUTRUCHES = new RegimeHerbivore(5);

	public Autruche(String name, double poids, int nbPlumes) {
		super(name, poids, REGIME_DES_AUTRUCHES);
		this.nbPlumes = nbPlumes;
	}

    // sans la variable static (=> moins propre et moins optimal)
    // on aurait pu écrire :
    //
    //    public Autruche(String name, double poids, int nbPlumes) {
    //        super(name, poids, new RegimeHerbivore(5));
    //        this.nbPlumes = nbPlumes;
    //    }
 

	// Le nombre de plume est modifiable, cf sujet
	// => un modifieur sur cet attribut
	public void setNbPlumes(int n) {
		nbPlumes = n;
	}


	@Override
	public String getCri() {
		return "beuglement";
	}

	@Override
	public String toString() {
		return "Je suis une Autruche "+ super.toString() + " et j'ai " + nbPlumes + " plumes";
	}
}
