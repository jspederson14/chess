package game;
import pieces.*;

//class to represnt the board
public class Board{
	public Tile[][] board = new Tile[8][8];
	//makes a board to with tiles
	public Board(){
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board.length; j++) {
				this.board[i][j] = new Tile(i,j);
			}
		}
	}
	//sets up the board for a game
	public void setUp() {
		
	}
	//makes the GUI for the board
	public void GUI() {
	}
	//prints a board
	public void print() {
		
	}
}
