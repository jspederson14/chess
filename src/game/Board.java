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
		//adding all the pawns
		for(int i=0; i<8; i++) {
			board[1][i].addPiece(new Pawn(1,i,"Black"));
			board[6][i].addPiece(new Pawn(6,i,"White"));
		}
		//adding all the other black pieces
		board[0][0].addPiece(new Rook(0,0,"Black"));
		board[0][1].addPiece(new Knight(0,1,"Black"));
		board[0][2].addPiece(new Bishop(0,2,"Black"));
		board[0][3].addPiece(new Queen(0,3,"Black"));
		board[0][4].addPiece(new King(0,4,"Black"));
		board[0][5].addPiece(new Bishop(0,5,"Black"));
		board[0][6].addPiece(new Knight(0,6,"Black"));
		board[0][7].addPiece(new Rook(0,7,"Black"));
		//adding all the other white pieces
		board[7][0].addPiece(new Rook(7,0,"White"));
		board[7][1].addPiece(new Knight(7,1,"White"));
		board[7][2].addPiece(new Bishop(7,2,"White"));
		board[7][3].addPiece(new Queen(7,3,"White"));
		board[7][4].addPiece(new King(7,4,"White"));
		board[7][5].addPiece(new Bishop(7,5,"White"));
		board[7][6].addPiece(new Knight(7,6,"White"));
		board[7][7].addPiece(new Rook(7,7,"White"));
	}
	//makes the GUI for the board
	public void GUI() {
	}
	//allows for a piece to be passed between tiles and returns if move was able to be made
	public boolean play(int startX, int startY, int endX, int endY) {
		Piece curr = board[startX][startY].givePiece();
		if(curr.move(endX, endY)) {
			board[startX][startY].addPiece(null);
			board[endX][endY].addPiece(curr);
			return true;
		}
		return false;
	}
	//prints a board
	public void print() {
		System.out.println("   0  1  2  3  4  5  6  7");
		System.out.println("  -----------------------");
		for(int i=0; i<board.length; i++) {
			System.out.print(i+"|");
			for(int j=0; j<board.length; j++) {
				this.board[i][j].printPiece();
			}
			System.out.println();
		}
	}
}
