import java.io.*;

public class ReglePendu {

	private String mot;
	private char[] motTab;
	private int nbEssais;
	private int nbErreurs;
	private boolean[] lettresTrouve;

	public ReglePendu() {

		choixMot();

		motTab = new char[mot.length() - 1];

		for (int i = 0; i < motTab.length; i++) {
			motTab[i] = mot.charAt(i);
			// System.out.print("[" + motTab[i] + "] ");
		}
		System.out.print("\n");

		lettresTrouve = new boolean[motTab.length];

	}

	public void choixMot() {
		int n = (int) (Math.random() * 836); //nombre de mot

		try {
			File d = new File("dictionnaire.txt");
			BufferedReader buff1 = new BufferedReader(new FileReader(d));

			for (int i = 0; i < n; i++) {
				buff1.readLine();
			}
			mot = buff1.readLine();
			buff1.close();

			System.out.println(mot);

		} catch (FileNotFoundException e) {
			// Cette exception est levée si l'objet FileInputStream ne trouve aucun fichier
			e.printStackTrace();

		} catch (IOException e) {
			// Celle-ci se produit lors d'une erreur d'écriture ou de lecture
			e.printStackTrace();
		}

	}

	public void affiche1() {

		// 0 //
		System.out.println("Vous avez fait " + nbErreurs + " erreurs.");
		
		switch (nbErreurs) {

		default:
			break;

		case 1:
			break;

		case 2:
			break;

		case 3:
			break;

		case 4:
			break;

		case 5:
			break;

		case 6:
			break;

		}
	}

	public void affiche2() {

		for (int i = 0; i < motTab.length; i++) {

			if (lettresTrouve[i])
				System.out.print(" " + motTab[i] + " ");
			else
				System.out.print(" _ ");
		}

	}

	public boolean rechercher(char c) {

		boolean lettreExiste = false;

		for (int i = 0; i < motTab.length; i++) {
			if (c == motTab[i]) {
				lettresTrouve[i] = true;
				lettreExiste = true;
			}
		}
		return lettreExiste;
	}

	public boolean test() {

		int a = 0;
		boolean w = false;

		for (int i = 0; i < motTab.length; i++) {
			if (lettresTrouve[i])
				a++;
		}
		if (a == motTab.length)
			w = true;

		return w;
	}

	public char[] getMotTab() {
		return motTab;
	}

	public boolean[] getLettresTrouve() {
		return lettresTrouve;
	}

	public void SetNbErreurs() {
		nbErreurs++;
	}

	public int getNbErreurs() {
		return nbErreurs;
	}

	public String getMot() {
		return mot;
	}

	public int getNbEssais() {
		return nbEssais;
	}

	public void SetNbEssais() {
		nbEssais++;
	}

}
