package Graphics;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Window extends JFrame {
	public Window() {
		setTitle("Guerra");
		setPreferredSize(new Dimension(640, 480));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}

