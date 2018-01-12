import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DessinPendu extends JFrame implements ActionListener {

	private ReglePendu r;
	private Container c = this.getContentPane();
	private static char[] lettreUtilise = new char[26];
	private String[] alphabet = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
			"R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

	public DessinPendu() {

		JButton b = new JButton("Retour");
		this.setSize(800, 600);
		this.setTitle("Pendu");
		this.setLocationRelativeTo(null);

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

		c.setLayout(new FlowLayout());
		this.setContentPane(c);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			
			System.out.println("Lettres utilisées : ");
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

	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 26; i++) {
			if ((e.getActionCommand().equals(alphabet[i]))) {
				this.penduRun(alphabet[i].charAt(0));
			}
		}
	}
	
	public static void partieGagne() {
		System.out.println("Bravo !");
	}

	public static void partiePerdu(String mot) {
		System.out.println("Tu pue la merde !");
		System.out.println(mot);
	}
}
