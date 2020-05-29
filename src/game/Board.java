package game;
import java.util.ArrayList;

import pieces.*;

//class to represnt the board
public class Board{
	public Tile[][] board = new Tile[8][8];
	public ArrayList<Piece> out = new ArrayList<Piece>();
	//makes a board to with tiles
	public Board(){
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board.length; j++) {
				this.board[i][j] = new Tile(i,j);
			}
		}
	}
	//gives the piece at a tile
	public String givePiece(int x, int y) {
		if(board[y][x].givePiece()==null)
			return "Nothing X:"+x+" Y:"+y;
		return board[y][x].givePiece().giveType()+" X:"+board[y][x].giveX()+" Y:"+board[y][x].giveY();
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
	//allows for a piece to be passed between tiles and returns if move was able to be made
	public boolean play(int startX, int startY, int endX, int endY) {
		Piece curr = board[startY][startX].givePiece();
		if(curr.capture(endX, endY, board[endY][endX])) {
			out.add(board[endY][endX].givePiece());
			board[endY][endX].addPiece(null);
		}
		else if(curr.move(endX, endY)) {
			board[startY][startX].addPiece(null);
			board[endY][endX].addPiece(curr);
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
