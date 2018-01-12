import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;

public class DessinPendu extends JFrame implements ActionListener, WindowListener {

	private boolean run = false;
	private static boolean nouvellePartie = true;
	private static char[] lettreUtilise = new char[26];

	public DessinPendu() {

		setSize(800, 600);
		setTitle("Pendu");

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JButton b = new JButton("Retour");
		b.addActionListener(this);
		c.add(b);
		
		this.penduJeu(new ReglePendu());

		this.setContentPane(c);
		this.addWindowListener(this);
		this.setVisible(true);

	}

	public void penduJeu(ReglePendu r) {

		while (run) {

			boolean ignore = false;

			if (nouvellePartie) {
				r.choixMot();
				nouvellePartie = false;
			}

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
	}

	public void partieGagne() {
		System.out.println("Bravo !");
	}

	public void partiePerdu(String mot) {
		System.out.println("Tu pue la merde !");
		System.out.println(mot);
	}

	public void actionPerformed(ActionEvent e) {
		if ((e.getActionCommand()).equals(("Retour"))) {
			run = false;
			this.dispose();
			Menu m = new Menu();
		}
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public void windowActivated(WindowEvent e) {

	}

	public void windowClosed(WindowEvent e) {

	}

	public void windowDeactivated(WindowEvent e) {

	}

	public void windowDeiconified(WindowEvent e) {

	}

	public void windowIconified(WindowEvent e) {

	}

	public void windowOpened(WindowEvent e) {

	}
}
