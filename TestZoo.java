
public class TestZoo {
	public static void main(String[] args) {
		Zoo Manotec = new Zoo("Manotec");
		Aigle Fantome = new Aigle("Fantome", 120, 12);
		Aigle Fantomette = new Aigle("Fantomette", 100, 20, 4);
		Manotec.ajoute(Fantome);
		Manotec.ajoute(Fantomette);
		Aigle Fontomas = new Aigle("Fantomas", 100, Fantome, Fantomette);
		Aigle Mimi = new Aigle("Mimi Geignarde", 80, Fantome, Fantomette);
		Manotec.ajoute(Fontomas);
		Manotec.ajoute(Mimi);
		Aigle Casper  = new Aigle("Casper", 20, Fontomas, Mimi);
		Manotec.ajoute(Casper);

		Orque Paul = new Orque("Paul", 8000);
		Manotec.ajoute(Paul);

		System.out.println(Fantome.getName() + " a " + Fantome.getNbDescendants() + " descendants");
		System.out.println(Paul.getName() + " a " + Paul.getNbDescendants() + " descendants");

/*
		System.out.println(minatec);
		System.out.println("Le minatec coute " + minatec.coutTotal() + " Euros/jour");

		//Recuperation de Toto
		System.out.println("==> Recuperation de Toto...");
		System.out.println("Voici l'animal nommé toto => " + minatec.getAnimal("Toto"));

		// Suppresion
		System.out.println("==> Supression de René...");
		minatec.remove("René");
		System.out.println(minatec);

		// Ajout d'un animal avec un nom deja existant
		System.out.println("==> Ajout d'un nouvel animal nommé Toto");
		try {
			minatec.ajoute(new Aigle("Toto", 15, 12));
		} catch( IllegalArgumentException e) {
			System.out.println("Ajout de l'animal nommé Toto impossible");
			System.out.println("Exception recue : " + e);
		}

		System.out.println(minatec);
*/
	}
}


// Ce programme sort sur le Terminal :
//$ java TestZoo
//Zoo:Minatec avec 4 animaux
//Je suis un aigle Nom: Toto poids 15.0 regime Carnivore, qte viande 1.0 cout : 200.0; envergure : 12.0
//Je suis un aigle Nom: Paulette poids 13.0 regime Carnivore, qte viande 4.0 cout : 1700.0; envergure : 12.0
//Je suis une Autruche Nom: René poids 85.0 regime Herbivore, qte de nourriture 5.0 cout : 3.6534269252681075 et j'ai 12 plumes
//Je suis un orque Nom: Sylvain poids 1000.0 regime Carnivore, qte viande 100.0 cout : 1000100.0
//
//Le minatec coute 1002003.6534269253 Euros/jour
//==> Recuperation de Toto...
//Voici l'animal nommé toto => Je suis un aigle Nom: Toto poids 15.0 regime Carnivore, qte viande 1.0 cout : 200.0; envergure : 12.0
//==> Supression de René...
//Zoo:Minatec avec 3 animaux
//Je suis un aigle Nom: Toto poids 15.0 regime Carnivore, qte viande 1.0 cout : 200.0; envergure : 12.0
//Je suis un aigle Nom: Paulette poids 13.0 regime Carnivore, qte viande 4.0 cout : 1700.0; envergure : 12.0
//Je suis un orque Nom: Sylvain poids 1000.0 regime Carnivore, qte viande 100.0 cout : 1000100.0
//
//==> Ajout d'un nouvel animal nommé Toto
//Ajout de l'animal nommé Toto impossible
//Exception recue : java.lang.IllegalArgumentException: il y a deja un animal de ce nom dans le zoo
//Zoo:Minatec avec 3 animaux
//Je suis un aigle Nom: Toto poids 15.0 regime Carnivore, qte viande 1.0 cout : 200.0; envergure : 12.0
//Je suis un aigle Nom: Paulette poids 13.0 regime Carnivore, qte viande 4.0 cout : 1700.0; envergure : 12.0
//Je suis un orque Nom: Sylvain poids 1000.0 regime Carnivore, qte viande 100.0 cout : 1000100.0
