import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener {

	private boolean run = false;
	Container c = this.getContentPane();
	JButton b1 = new JButton("Jouer");
	JButton b2 = new JButton("Scores");
	JButton b3 = new JButton("Quitter");

	public Menu() {

		this.setSize(800, 600);
		this.setTitle("Pendu");
	    this.setLocationRelativeTo(null);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		c.add(b1);
		c.add(b2);
		c.add(b3);

	    c.setLayout(new FlowLayout());
		this.setContentPane(c);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

}
