package game;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import pieces.*;


public class GUI extends JFrame{
	
	JFrame f;
	JPanel p;
	
	Board gameBoard;
	
	boolean picked;
	boolean done;
	boolean turn;
	
	int startX;
	int startY;
	
	int endX;
	int endY;
	
	//board setup
		public void setUpGUI() {
			gameBoard = new Board();
			gameBoard.setUp();
			picked = false;
			turn = true;
		}
	//checks to see if game is over
		public boolean gameOverGUI() {
			return gameBoard.gameOver();
		}
	//checks to see if play is possible
		public void playGUI(int startX, int startY, int endX, int endY) {
			gameBoard.play(startX, startY, endX, endY);
		}
	//makes the GUI for the board
		public void frameGUI() {
			String player;
			if(gameOverGUI()) {
				if(turn)
					player = "Black";
				else
					player = "White";
				f = new JFrame("The winner is: "+player);
				f.setVisible(true);
				f.setSize(1000, 1000);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				p = new JPanel();
				Font font = new Font("TimesRoman",Font.BOLD, 36);
				JLabel l1 = new JLabel("Congradulations: ");
				l1.setFont(font);
				JLabel l2 = new JLabel(player);
				l2.setFont(font);
				GridBagConstraints c = new GridBagConstraints();
				c.gridx = 0;
				c.gridy = 1;
				p.add(l1,c);
				c.gridx = 0;
				c.gridy = 2;
				p.add(l2,c);
				
			}
			else {
				if(turn)
					player = "White";
				else
					player = "Black";
				f = new JFrame(player+"'s turn");
				f.setVisible(true);
				f.setSize(1000, 1000);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
				f.add(boardGUI());
			}
		}
	//updates the frame
		public void updateGUI() {
				done = false;
				picked = false;
				if(turn)
					turn=false;
				else 
					turn=true;
				
		}
		//creates board that tiles will be added to
		public JPanel boardGUI() {
			p = new JPanel(new GridLayout(8,8));
			GridBagConstraints c = new GridBagConstraints();
			for(int x=0; x<8; x++) {
				for(int y=0; y<8; y++) {
					c.gridx = x;
					c.gridy = y;
					p.add(tileGUI(gameBoard.giveTile(x,y)),c);
				}
			}
			return p;
		}
	//creates tiles to be added to board
		public JPanel tileGUI(Tile gameTile) {
			JPanel tile = new JPanel();
			Font font = new Font("TimesRoman",Font.BOLD, 36);
			tile.setSize(100, 100);
			tile.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//do nothing
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					//do nothing
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					if(tile.getBackground()!=Color.RED) {
						tile.setBackground(Color.GREEN);
					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					if(tile.getBackground()!=Color.RED) {
						if((gameTile.giveX()+gameTile.giveY())%2==0)
							tile.setBackground(Color.WHITE);
						else
							tile.setBackground(Color.BLACK);
					}
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					if(picked) {
						endX = gameTile.x;
						endY = gameTile.y;
						done = true;
						gameBoard.play(startX, startY, endX, endY);
						updateGUI();
						frameGUI();
					}
					if((!picked)&&(vaildStart(gameTile.x,gameTile.y))) {
						tile.setBackground(Color.RED);
						startX = gameTile.x;
						startY = gameTile.y;
						picked = true;
					}
				}
			});
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
	//checks to see if valid start piece
		public boolean vaildStart(int startX, int startY) {
			if((gameBoard.giveTile(startX, startY).givePiece()!=null)&&(!picked)) {
				if(turn) {
					if(gameBoard.giveTile(startX, startY).givePiece().giveColor().equals("White"))
						return true;
				}
				if(!turn) {
					if(gameBoard.giveTile(startX, startY).givePiece().giveColor().equals("Black"))
						return true;
				}
			}
			return false;
		}
	//move complete
		public boolean moveComplete() {
			return done;
		}
}