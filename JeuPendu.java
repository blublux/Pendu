import java.util.Scanner;

public class JeuPendu {

	static boolean run = false;
	static int menuSelect;
	static char[] lettreUtilise = new char[26];

	public static void main(String[] args) {

		// Affichage frame = new Affichage();
		
		
		menu();

		ReglePendu r = new ReglePendu();
		//Affichage fen = new Affichage();


		while (run) {
			penduJeu(r);
		}

	}

	public static void penduJeu(ReglePendu r) {

		boolean ignore = false;

		r.affiche1();
		r.affiche2();

		Scanner sc = new Scanner(System.in);
		char input = sc.next().charAt(0);
		input = Character.toUpperCase(input);
		for (int i = 0; i < r.getNbEssais(); i++) {
			if (input == lettreUtilise[i]) {
				ignore = true;
			}
		}
		if (!ignore) {
			if (!r.rechercher(input)) {

				r.SetNbErreurs();
			}
			r.SetNbEssais();

			System.out.println("Lettres utilisés : ");
			for (int i = 0; i < r.getNbEssais(); i++) {
				if (lettreUtilise[i] == 0) {
					lettreUtilise[i] = input;
					break;
				}
			}
		}
		for (int i = 0; i < r.getNbEssais(); i++) {
			System.out.print(lettreUtilise[i] + " ");
		}
		System.out.print("\n");

		if (r.test())

		{
			partieGagne();
			for (int i = 0; i < r.getMotTab().length; i++) {
				System.out.print(" " + r.getMotTab()[i] + " ");
			}
			sc.close();
		}
		if (r.getNbErreurs() >= 6) {
			partiePerdu(r.getMot());
			sc.close();
		}
	}

	public static void menu() {

		switch (menuSelect) {

		case 0:
			System.out.println("Jouer");
			run = true;
			break;

		case 1:
			System.out.println("Scores");
			break;

		case 2:
			System.out.println("Quitter");
			if (true)
				System.exit(0);
			break;

		}
	}

	public static void partieGagne() {
		System.out.println("Bravo !");
		run = false;
	}

	public static void partiePerdu(String mot) {
		System.out.println("Tu pue la merde !");
		System.out.println(mot);
		run = false;
	}
}
