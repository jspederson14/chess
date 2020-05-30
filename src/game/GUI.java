package game;

import java.awt.*;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pieces.*;

public class GUI extends JFrame{
	
	JFrame f;
	JPanel p;
	
	Board gameBoard;
	
	//makes the GUI for the board
		public void frameGUI(Board gameBoard) {
			f = new JFrame("Chess");
			f.setVisible(true);
			f.setSize(1000, 1000);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			this.gameBoard = gameBoard;
			
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
					p.add(this.tileGUI(gameBoard.giveTile(x,y)),c);
				}
			}
			return p;
		}
	//creates tiles to be added to board
		public JPanel tileGUI(Tile gameTile) {
			JPanel tile = new JPanel();
			Font font = new Font("TimesRoman",Font.BOLD, 36);
			tile.setSize(100, 100);
			if((gameTile.giveX()+gameTile.giveY())%2==0)
				tile.setBackground(Color.WHITE);
			else
				tile.setBackground(Color.BLACK);
			
			if(gameTile.givePiece()!=null) {
				JLabel piece = new JLabel(gameTile.givePiece().giveType());
				piece.setFont(font);
				if(gameTile.givePiece().giveColor().equals("Black"))
					piece.setForeground(Color.DARK_GRAY);
				if(gameTile.givePiece().giveColor().equals("White"))
					piece.setForeground(Color.GRAY);
				tile.add(piece);
			}
			return tile;
		}
	//adds action to tiles
		public JPanel gameAction(boolean turn) {
			for(int x=0; x<8; x++) {
				for(int y=0; y<8; y++) {
					if((gameBoard.givePiece(x, y)!=null)&&(turn)) {
						JPanel act = new JPanel();
						act = this.tileGUI(gameBoard.giveTile(x, y));
						act.addMouseListener(new MouseListener() {
							
						});
					}
						
				}
			}
			
			
		}
}