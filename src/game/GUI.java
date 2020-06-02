package game;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pieces.*;


public class GUI extends JFrame{
	
	JFrame f;
	JPanel p;
	
	Board gameBoard;
	
	int startX;
	int startY;
	
	int endX;
	int endY;
	
	//board setup
		public void setUpGUI() {
			gameBoard = new Board();
			gameBoard.setUp();
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
			f = new JFrame("Chess");
			f.setVisible(true);
			f.setSize(1000, 1000);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			f.add(boardGUI());
		}
	//updates the frame
		public void updateGUI() {
		    f.repaint();
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
		public void gameAction(boolean turn) {
			for(int x=0; x<8; x++) {
				for(int y=0; y<8; y++) {
					if((gameBoard.giveTile(x, y).givePiece()!=null)&&(turn)&&(gameBoard.isWhite(x, y))) {
						JPanel start = new JPanel();
						int tempX = x;
						int tempY = y;
						start = this.tileGUI(gameBoard.giveTile(x, y));
						start.addMouseListener(new MouseListener() {
							@Override
							public void mouseClicked(MouseEvent e) {
								startX = tempX;
								startY = tempY;
								System.out.print("beep");
							}

							@Override
							public void mouseReleased(MouseEvent e) {
								// TODO Auto-generated method stub
								//do nothing
							}

							@Override
							public void mouseEntered(MouseEvent e) {
								// TODO Auto-generated method stub
								//do nothing
							}

							@Override
							public void mouseExited(MouseEvent e) {
								// TODO Auto-generated method stub
								//do nothing
							}

							@Override
							public void mousePressed(MouseEvent e) {
								// TODO Auto-generated method stub
								//do nothing
							}
						});
					}
						
				}
			}
			for(int x=0; x<8; x++) {
				for(int y=0; y<8; y++) {
					if((gameBoard.giveTile(x, y).givePiece()!=null)&&(!turn)&&(!gameBoard.isWhite(x, y))) {
						JPanel start = new JPanel();
						int tempX = x;
						int tempY = y;
						start = this.tileGUI(gameBoard.giveTile(x, y));
						start.addMouseListener(new MouseListener() {
							@Override
							public void mouseClicked(MouseEvent e) {
								startX = tempX;
								startY = tempY;
								System.out.print("beep");
							}

							@Override
							public void mouseReleased(MouseEvent e) {
								// TODO Auto-generated method stub
								//do nothing
							}

							@Override
							public void mouseEntered(MouseEvent e) {
								// TODO Auto-generated method stub
								//do nothing
							}

							@Override
							public void mouseExited(MouseEvent e) {
								// TODO Auto-generated method stub
								//do nothing
							}

							@Override
							public void mousePressed(MouseEvent e) {
								// TODO Auto-generated method stub
								//do nothing
							}
						});
					}
						
				}
			}
			for(int x=0; x<8; x++) {
				for(int y=0; y<8; y++) {
					if(gameBoard.giveTile(startX, startY).givePiece().isVaild(x, y)) {
						JPanel start = new JPanel();
						int tempX = x;
						int tempY = y;
						start = this.tileGUI(gameBoard.giveTile(x, y));
						start.addMouseListener(new MouseListener() {
							@Override
							public void mouseClicked(MouseEvent e) {
								endX = tempX;
								endY = tempY;
								System.out.print("bp");
							}

							@Override
							public void mouseReleased(MouseEvent e) {
								// TODO Auto-generated method stub
								//do nothing
							}

							@Override
							public void mouseEntered(MouseEvent e) {
								// TODO Auto-generated method stub
								//do nothing
							}

							@Override
							public void mouseExited(MouseEvent e) {
								// TODO Auto-generated method stub
								//do nothing
							}

							@Override
							public void mousePressed(MouseEvent e) {
								// TODO Auto-generated method stub
								//do nothing
							}
						});
					}
						
				}
			}
			gameBoard.play(startX, startY, endX, endY);
		}
}