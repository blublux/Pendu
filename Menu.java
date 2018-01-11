import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener, WindowListener {

	private boolean run = false;

	public Menu() {

		setSize(800, 600);
		setTitle("Pendu");

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JButton b1 = new JButton("Jouer");
		JButton b2 = new JButton("Scores");
		JButton b3 = new JButton("Quitter");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		c.add(b1);
		c.add(b2);
		c.add(b3);

		this.setContentPane(c);
		this.addWindowListener(this);
		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if ((e.getActionCommand()).equals(("Jouer"))) {
			this.run = true;
			this.dispose();
			DessinPendu d = new DessinPendu();
		}
		if ((e.getActionCommand()).equals(("Scores"))) {

		}
		if ((e.getActionCommand()).equals(("Quitter"))) {
			System.exit(0);
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
