import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Affichage extends JFrame implements ActionListener, WindowListener {

	public Affichage() {

		setSize(800, 600);
		setTitle("Pendu");

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JButton b1 = new JButton("Jouer");
		JButton b2 = new JButton("Scores");
		JButton b3 = new JButton("Quitter");

		c.add(b1,BorderLayout.CENTER);
		c.add(b2);
		c.add(b3);

		setContentPane(c);

		addWindowListener(this);
		this.setVisible(true);

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

	public void actionPerformed(ActionEvent e) {

	}
}
