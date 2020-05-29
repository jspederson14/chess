package game;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame{
	
	JFrame f;
	JPanel p;
	
	//makes the GUI for the board
		public void GUI() {
			f = new JFrame("Chess");
			f.setVisible(true);
			f.setSize(1000, 1000);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		
			f.add(this.boardGUI());
		}
	//creates board that tiles will be added to
		public JPanel boardGUI() {
			p = new JPanel(new GridLayout(8,8));
			GridBagConstraints c = new GridBagConstraints();
			for(int x=0; x<8; x++) {
				for(int y=0; y<8; y++) {
					c.gridx = x;
					c.gridy = y;
					p.add(this.tileGUI(x,y),c);
				}
			}
			return p;
		}
	//creates tiles to be added to board
		public JPanel tileGUI(int x, int y) {
			JPanel t = new JPanel();
			t.setSize(100, 100);
			if((x+y)%2==0)
				t.setBackground(Color.WHITE);
			else
				t.setBackground(Color.BLACK);
			return t;
		}
}
