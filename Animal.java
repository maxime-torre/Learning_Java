import java.util.*;


public abstract class Animal implements CoutEvaluable {
  private String name;
  private Animal pere;
  private Animal mere;
  private double poids;
  protected Regime regime; // pour accès dans Orque
  // Pour les enfants :
  // On choisit une List
  //   => conservation de l'ordre des naissance
  // Nouvelle collection pour stocker les enfants
	private List<Animal> enfants;

  public Animal(String name, double poids, Regime regime){ // Premier constructeur
    if(name == null || name.length() == 0) {
      throw new IllegalArgumentException(" pas de prénoms");
    }
    this.name = name;
    this.setPoids(poids);
    this.regime = regime;
    this.pere = null; // Il faut initialiser les objets car ils n'ont pas de parents, c'est les premiers à étre crée
    this.mere = null;
    this.enfants = new ArrayList<>(); // Initialize the list of children
  }
  public Animal(String name, double poids, Animal pere, Animal mere) {
		this.name = name;
		this.poids = poids;
		//this.pere = new Animal(pere.getName(), pere.getPoids(), null); // Il faut créer un nouvel objet de type animal
    this.pere = pere;
		this.mere = mere;
    this.regime = pere.getRegime();
		this.enfants = new LinkedList<Animal>();
		if (pere != null) {
			pere.ajouterEnfant(this);
		}
		if (mere != null) {
			mere.ajouterEnfant(this);
		}
	}
  // Méthode pour ajouter un enfant à la collection
	public void ajouterEnfant(Animal enfant) {
		enfants.add(enfant);
	}

	// Méthode pour récupérer le nombre de descendants
	public int getNbDescendants() {
		HashSet<String> descendants = new HashSet<String>();
		for (Animal enfant : enfants) {
			descendants.add(enfant.getName());
			descendants.addAll(enfant.getDescendants());
		}
		return descendants.size();
	}

	// Méthode pour récupérer les descendants sous forme d'une collection de noms
	public HashSet<String> getDescendants() {
		HashSet<String> descendants = new HashSet<String>();
		for (Animal enfant : enfants) {
			descendants.add(enfant.getName());
			descendants.addAll(enfant.getDescendants());
		}
		return descendants;
	}
  public Animal getPere() {
    return pere;
}
  public Animal getMere() {
    return mere;
}
  public String getName() {
    return name;
  }
  public double getPoids() {
    return poids;
  }
  public void setPoids(double poids) {
    if(poids < 0) {
      throw new IllegalArgumentException("poids ne peut etre négatif");
    }
    this.poids = poids;
  }
  public double getCout() {
    return regime.getCout();
  }

  public Regime getRegime() {
    return regime;
  }

  // Le cri est spécifique à chaque type (chaque classe) d'animal.
  // Mais tous les animaux (eg toutes les autruches)
  // d'un type donné crient pareil.
  // On a donc pas besoin de stocker en mémoire un attribut "cri"
  //      dans chaque objet Animal.
  // => on décide d'implanter le cri au moyen d'une méthode abstraite
  //    qui sera redéfinie dans les sous-classes
  public abstract String getCri();

  // Ecrit le cri dans le Terminal
  // Méthode concrète... qui appelle une méthode abstraite. Eh oui, ça marche !
  public void crier() {
    System.out.println( "Je crie ! => " + this.getCri() );
  }

  @Override
  public String toString(){
    return "Nom: "+ name + " poids " + poids + " regime " + regime;
  }

  // Test d'égalité entre animaux.
  // Cf sujet : "deux animaux sont égaux au sens de la méthode
  // equals si ils ont le même nom"
  //
  // Attention : equals prend toujours un Object en paramètre !
  @Override
  public boolean equals(Object other){
    if( ! (other instanceof Animal)) {
      return false; // other n'est pas un Animal (mais un avion ou autre chose)
    }
    Animal a = (Animal) other; // on cast l'object other en Animal
    return a.name.equals(this.name);
    // attention : pas
    //		a.nom == this.name ;
    // car cela testerait l'égalité des adresses !
    // Il faut utiliser ici la méthode equals() de la classe String !
  }
}
