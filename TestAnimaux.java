
public class TestAnimaux {
	public static void main(String[] args) {
		Aigle papa = new Aigle( "papa", 100, null , null);
		Aigle maman = new Aigle( "maman", 100, null , null);

		Aigle fils1 = new Aigle("fils1", 200, papa, maman);
		Aigle fille1 = new Aigle("fils1", 200, papa, maman);

		Aigle pFils1 = new Aigle("petit fils 1", 100, fils1, fille1);

		System.out.println(fils1);
		System.out.println(papa.getNbDescendants());
		System.out.println(papa.getDescendants());

		System.out.println(pFils1);
		System.out.println(papa.getNbDescendants());
		System.out.println(papa.getDescendants());
	}
}