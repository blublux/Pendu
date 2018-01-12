import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ScoresPendu extends JFrame implements ActionListener {
	
	Container c = getContentPane();
	JButton b = new JButton("Retour");

	
	public ScoresPendu() {
		
	}


	
	public void actionPerformed(ActionEvent e) {
		if ((e.getActionCommand()).equals(("Retour"))) {
			this.dispose();
			Menu m = new Menu();
		}
	}
}
