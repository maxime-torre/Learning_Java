import java.util.*;

class AnimalCoutComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal a1, Animal a2) {
        if (a1.getCout() < a2.getCout()) {
            return -1;
        } else if (a1.getCout() > a2.getCout()) {
            return 1;
        } else {
            return 0;
        }
    }
}


// Le zoo
//    avec seulement une LinkedList
// A finaliser de telle sorte que :
//    l'affichage soit toujours "dans l'ordre d'ajout"
//    et "l'accès par nom soit de complexité constante O(1)"


/** Une classe représentant un Zoo :
 *
 * Un zoo a un nom, et peut contenir un nombre quelconque d'animaux de noms tous différents
 * On peut :
 *  ajouter un nouvel animal (unicité des noms)
 *  récupérer le nombre d'animaux,
 *  calculer le coût de nourriture,
 *  supprimer un animal par son nom
 *  récupérer un animal par son nom
 *  récupérer une chaine de caractères représentant l'état du Zoo,
 *      avec affichage des animaux dans l'ordre d'ajout au ZOo
 *  Il faudrait que tous ces traitements soient optimaux
 *    (ce n'est pas encore la cas...)
 **/
public class Zoo {
	private String nom;

	// Liste d'animaux ( affichage dans l'ordre d'ajout au Zoo => List)
	private List<Animal> animaux;
	private double coutTotal; // Amélioration de getcout : Ajout de l'attribut coutTotal
	private List<CoutEvaluable> coutEvaluables;

	/** Construit le zoo de nom name, initialement vide */
	public Zoo(String name) {
		nom = name;

	  // Pour la liste "animaux",
	  // Une LinkedList<> est plus adaptée qu'une ArrayList<>
	  // car on utilisera pas la méthode get(int)
	  // et l'ajout dans une LinkedList est toujours en O(1)
		animaux = new LinkedList<Animal>();
		coutTotal = 0; // Amélioration de getcout : Initialisation de l'attribut coutTotal
		coutEvaluables = new LinkedList<>();
	}

	/** Ajoute l'animal a au zoo apres avoir vérifié qu'il n'y a pas dejà un animal de même nom */
	public void ajoute(Animal a) {
//		// ==> Solution utilisant la LinkedList pour l'unicité des noms.
		// LinkedList<>.contains() utilise la méthode boolean equals(Object o) de la classe Animal
		// qui a été écrite pour que "deux animaux sont égaux si ils ont le même nom".
		// Cout : O(n)
		if(animaux.contains(a)) {
			throw new IllegalArgumentException("il y a deja un animal de ce nom dans le zoo");
		}

		// Mais... ce parcours est en O(n)...
		// Quel type abstrait et structure de donnée faudrait-il avoir dans
		// la classe Zoo de vérifier l'unicité des noms en O(1) ?
		//     Cf fiche 8 Collections et Map
		// A faire pour la prochaine séance

		animaux.add(a);
		coutTotal += a.getCout(); // Amélioration de getcout : Mettre à jour le coût total lors de l'ajout d'un animal
		coutEvaluables.add(a);
	}

	/** Retourne le nombre d'animaux contenu dans le zoo */
	public int nbAnimaux() {
		return animaux.size();
	}

	public Animal getAnimal(String nom) {
		// ==> Solution à base de LinkedList
		// Coût : O(n)
		for(Animal a : animaux) {
			if(a.getName().equals(nom)){
				return a;
			}
		}
		return null;

		// Mais... ce parcours est en O(n)...
		// Quel type abstrait et structure de donnée faudrait-il avoir dans
		// la classe Zoo de récupérer l'animal de nom "nom" en O(1) ?
		//     Cf fiche 8 Collections et Map
		// A faire pour la prochaine séance
	}

	/** Supprime l'animal nommé "nom" */
	public void remove(String nom) {
		// Il faut trouver l'animal de nom "nom"
		// Cout : O(n)
		Iterator<Animal> itr = animaux.iterator();
		while(itr.hasNext()) {
			Animal a = itr.next();
			if(a.getName().equals(nom)){
				itr.remove(); // O(1) sur une LinkedList<>
				coutTotal -= a.getCout(); // Amélioration de getcout : Mettre à jour le coût total lors de la suppression d'un animal
				return;
			}
		}
	}

	public void ajouteEmploye(Employe e) {
		coutEvaluables.add(e);
		coutTotal += e.getCout(); // Mettre à jour le coût total lors de l'ajout d'un employé
	}
	

	public double getCout() {
		return coutTotal;
	}
	
	public TreeSet<Animal> getAnimauxTriesParCout() {
		TreeSet<Animal> animauxTries = new TreeSet<>(new AnimalCoutComparator());
		animauxTries.addAll(animaux);
		return animauxTries;
	}

	/** Retourne une chaine de caractères représentant l'état du zoo et de tous ces animaux */
	public String toString() {
		String s = "Zoo:"+nom+" avec "+nbAnimaux()+" animaux\n";
		// affichage dans l'ordre d'ajout au Zoo :
		for (Animal a : animaux) s += "     " + a + "\n";

		// Ou plus simplement, en utilisant la méthode toString() de LinkedList :
		//   s += animaux.toString();
		// mais dans ce cas on ne maitrise pas le formatage...
		return s;
	}
}
