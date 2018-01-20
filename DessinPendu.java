import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DessinPendu extends JFrame implements ActionListener {

	private ReglePendu r;
	private char[] lettreUtilise = new char[26];
	private String[] alphabet = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
			"R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
	private JPanel pan = new JPanel();
	private JLabel labelLettre = new JLabel();
	private JLabel labelDessin = new JLabel();
	private JButton[] boutonLettre = new JButton[26];
	private JButton b = new JButton("Retour");
	private Dimension dim = new Dimension(47, 40);
	private String textePopup;

	public DessinPendu() {

		this.setSize(600, 550);
		this.setTitle("Pendu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		r = new ReglePendu();
		labelLettre.setText(r.affiche2());

		// LA BARRE DE MENU

		JMenuBar mb = new JMenuBar();
		JMenu options = new JMenu("Options");
		JMenuItem recommencer = new JMenuItem("Recommencer");
		recommencer.addActionListener(this);
		JMenuItem retour = new JMenuItem("Retour");
		retour.addActionListener(this);

		mb.add(options);
		options.add(recommencer);
		options.add(retour);

		// CREER LES ZONES

		JPanel dessin = new JPanel();
		dessin.setPreferredSize(new Dimension(550, 280));
		// dessin.setBackground(Color.ORANGE);

		JPanel mot = new JPanel();
		mot.setPreferredSize(new Dimension(550, 50));
		// mot.setBackground(Color.YELLOW);

		JPanel lettre = new JPanel();
		lettre.setPreferredSize(new Dimension(550, 150));
		// lettre.setBackground(Color.RED);

		mot.add(labelLettre);
		labelDessin.setBorder(new EmptyBorder(0, 20, 0, 0));
		dessin.add(labelDessin);

		// GERER LES BOUTONS

		for (int i = 0; i < alphabet.length; i++) {
			boutonLettre[i] = new JButton(alphabet[i]);
			boutonLettre[i].setPreferredSize(dim);
			boutonLettre[i].addActionListener(this);
			lettre.add(boutonLettre[i]);
		}

		b.addActionListener(this);

		// GERER LES POLICES

		Font police = new Font("Arial", Font.BOLD, 34);
		labelLettre.setFont(police);
		labelDessin.setFont(police);

		// PLACEMENT DES ZONES

		pan.add(dessin, BorderLayout.NORTH);
		pan.add(mot, BorderLayout.CENTER);
		pan.add(lettre, BorderLayout.SOUTH);
		this.setJMenuBar(mb);
		this.setContentPane(pan);
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
				r.SetNbErreurs();
			}
			r.SetNbEssais();

			for (int i = 0; i < r.getNbEssais(); i++) {
				if (lettreUtilise[i] == 0) {
					lettreUtilise[i] = input;
				}
				for (int j = 0; j < lettreUtilise.length; j++) {
					if (lettreUtilise[i] == alphabet[j].charAt(0)) {
						boutonLettre[j].setEnabled(false);
					}
				}
			}

			labelDessin.setText(r.affiche1());
			labelLettre.setText(r.affiche2());

			if (r.test()) {
				partieFinie(true, r.getMot());
			}
		}
		if (r.getNbErreurs() >= 11) {
			partieFinie(false, r.getMot());
		}
	}

	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 26; i++) {
			if (e.getActionCommand().equals(alphabet[i])) {
				this.penduRun(alphabet[i].charAt(0));
			}
		}

		if (e.getActionCommand().equals("Recommencer")) {
			reset();
		}

		if (e.getActionCommand().equals("Retour")) {
			this.dispose();
			Menu m = new Menu();
		}
	}

	public void partieFinie(boolean win, String mot) {
		if (win) {
			this.textePopup = "Bravo vous avez gagné !";

		} else {
			this.textePopup = "Dommage le mot était : " + mot;

			// labelDessin.setText(r.affiche1());
			// labelLettre.setText(r.affiche2());
		}
		String[] boutonPopup = { "Recommencer", "Retour au menu" };
		JOptionPane jop = new JOptionPane();
		int choix;
		do {
			choix = JOptionPane.showOptionDialog(null, textePopup, "Fin", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, boutonPopup, boutonPopup[1]);
		} while (choix == JOptionPane.CLOSED_OPTION);

		if (choix == JOptionPane.YES_OPTION) {
			reset();
		} else if (choix == JOptionPane.NO_OPTION) {
			Menu m = new Menu();
			this.dispose();
		}

	}

	public void reset() {
		r = new ReglePendu();
		labelDessin.setText(r.affiche1());
		labelLettre.setText(r.affiche2());

		for (int i = 0; i < 26; i++) {
			boutonLettre[i].setEnabled(true);
			lettreUtilise[i] = 0;
		}
	}
}