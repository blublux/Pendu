import java.io.*;

public class ReglePendu {

	private String mot;
	private char[] motTab;
	private int nbEssais;
	private int nbErreurs;
	private boolean[] lettresTrouve;

	public ReglePendu() {

		choixMot();
	}

	public void choixMot() {
		int n = (int) (Math.random() * 836); // nombre de mot

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
			System.exit(0);
		} catch (IOException e) {
			// Celle-ci se produit lors d'une erreur d'écriture ou de lecture
			e.printStackTrace();
			System.exit(0);
		}

		motTab = new char[mot.length() - 1];

		for (int i = 0; i < motTab.length; i++) {
			motTab[i] = mot.charAt(i);
		}

		lettresTrouve = new boolean[motTab.length];

	}

	public String affiche1() {
		String dessin = "";

		switch (nbErreurs) {

		case 0:
			break;

		case 1:
			dessin = "# # # # # ___ ----";
			break;

		case 2:
			dessin = "# --| # --| # --| # --| # _|_ ----";
			break;

		case 3:
			dessin = "- ____ # --| # --| # --| # --| # _|_ ";
			break;

		case 4:
			dessin = "- ____ # --|/ # --| # --| # --| # _|_ ";
			break;

		case 5:
			dessin = "- ____ # --|/----| # --| # --| # --| # _|_ ";
			break;

		case 6:
			dessin = "- ____ # --|/----| # --|---- o # --| # --| # _|_ ";
			break;

		case 7:
			dessin = "- ____ # --|/----| # --|---- o # --|-----| # --| # _|_ ";
			break;

		case 8:
			dessin = "- ____ # --|/----| # --|---- o # --|----/| # --| # _|_ ";
			break;

		case 9:
			dessin = "- ____ # --|/----| # --|---- o # --|----/|\\ # --| # _|_ ";
			break;

		case 10:
			dessin = "- ____ # --|/----| # --|---- o # --|----/|\\ # --|----/ # _|_ ";
			break;

		default:
			dessin = "- ____ # --|/----| # --|---- o # --|----/|\\ # --|----/-\\ # _|_ ";
			break;

		}
		return convertToMultiline(dessin);
	}

	public String affiche2() {
		String texte = "";
		int temp = motTab.length;
		for (int i = 0; i < temp; i++) {
			if (lettresTrouve[i]) {
				texte = texte + motTab[i] + ' ';
			}

			else {
				texte = texte + '_' + ' ';
			}
		}
		return texte;
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
		boolean win = false;

		for (int i = 0; i < motTab.length; i++) {
			if (lettresTrouve[i])
				a++;
		}
		if (a == motTab.length)
			win = true;

		return win;
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

	public static String convertToMultiline(String texte) {
		return "<html>" + texte.replaceAll("-", "&nbsp").replaceAll("#", "<br />");
	}

}
