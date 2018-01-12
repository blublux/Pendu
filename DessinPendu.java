import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DessinPendu extends JFrame implements ActionListener, WindowListener {

	private ReglePendu r;
	private static char[] lettreUtilise = new char[26];
	private String[] alphabet = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
			"R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

	public DessinPendu() {

		setSize(800, 600);
		setTitle("Pendu");

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JButton b = new JButton("Retour");
		b.addActionListener(this);
		c.add(b);

		for (int i = 0; i < 26; i++) {
			JButton btn = new JButton();
			btn.setText(alphabet[i]);
			btn.addActionListener(this);
			c.add(btn);
		}

		r = new ReglePendu();
		r.choixMot();

		this.setContentPane(c);
		this.addWindowListener(this);
		this.setVisible(true);
	}

	public void penduRun(char input) {

		boolean ignore = false;

		for (int i = 0; i < r.getNbEssais(); i++) {
			if (input == lettreUtilise[i]) {
				ignore = true;
			}
		}
		if (!ignore) {
			if (!r.rechercher(input)) {
				System.out.print("test");

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

			for (int i = 0; i < r.getNbEssais(); i++) {
				System.out.print(lettreUtilise[i] + " ");
			}
			System.out.print("\n");

			r.affiche1();
			r.affiche2();

			if (r.test()) {
				partieGagne();
				for (int i = 0; i < r.getMotTab().length; i++) {
					System.out.print(" " + r.getMotTab()[i] + " ");
				}
			}
			System.out.println("\n");
		}
		if (r.getNbErreurs() >= 6) {
			partiePerdu(r.getMot());
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

		for (int i = 0; i < 26; i++) {
			if ((e.getActionCommand().equals(alphabet[i]))) {
				this.penduRun(alphabet[i].charAt(0));
			}
		}

		if ((e.getActionCommand()).equals(("Retour"))) {
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
