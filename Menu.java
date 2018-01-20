import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener {

	private JPanel pan = new JPanel();
	private JButton b1 = new JButton("Jouer");
	private JButton b2 = new JButton("Quitter");
	private JLabel labelTitre = new JLabel("Pendu");
	private JLabel labelNoms = new JLabel();
	private Dimension dim = new Dimension(150, 50);

	public Menu() {

		this.setSize(800, 600);
		this.setTitle("Pendu");
		this.setLocationRelativeTo(null);

		JPanel panPlacement = new JPanel();
		panPlacement.setPreferredSize(new Dimension(800, 300));
		JPanel panDecalage = new JPanel();
		panDecalage.setPreferredSize(new Dimension(150, 300));

		labelTitre.setFont(new Font("Arial", Font.BOLD, 52));
		labelTitre.setForeground(Color.magenta);
		labelNoms.setText(convertToMultiline("FONTENEAU Clément # JARDILLIER Jason # POISSON Jérémie # SOURICE Yann"));

		b1.setPreferredSize(dim);
		b1.addActionListener(this);
		b2.setPreferredSize(dim);
		b2.addActionListener(this);

		panPlacement.add(b1);
		panPlacement.add(b2);

		panDecalage.add(labelTitre);
		panDecalage.add(labelNoms);

		pan.add(panDecalage, BorderLayout.NORTH);
		pan.add(panPlacement, BorderLayout.CENTER);

		this.setContentPane(pan);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Jouer")) {
			this.dispose();
			DessinPendu d = new DessinPendu();
		}
		if (e.getActionCommand().equals("Quitter")) {
			System.exit(0);
		}
	}

	public static String convertToMultiline(String texte) {
		return "<html>" + texte.replaceAll("-", "&nbsp").replaceAll("#", "<br />");
	}
}
