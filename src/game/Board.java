package game;
import java.util.ArrayList;

import pieces.*;

//class to represent the board
public class Board{
	public Tile[][] board = new Tile[8][8];
	public ArrayList<Piece> out = new ArrayList<Piece>();
	public boolean turn;
	//makes a board to with tiles
	public Board(){
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board.length; j++) {
				this.board[i][j] = new Tile(i,j);
			}
		}
	}
	//checks to see if the game has ended
	public boolean gameOver() {
		for(Piece cap:out)
			if(cap.giveType().equals("k")||cap.giveType().equals("K"))
				return true;
		return false;
	}
	//gives the piece at a tile
	public String givePiece(int x, int y) {
		if(board[y][x].givePiece()==null)
			return "Nothing X:"+x+" Y:"+y;
		return board[y][x].givePiece().giveType()+" X:"+board[y][x].giveX()+" Y:"+board[y][x].giveY();
	}
	//gives color of piece
	public boolean isWhite(int x, int y) {
		if(board[y][x].givePiece().giveColor().equals("White"))
			return true;
		return false;
			
	}
	//gives turn. white is true black is false
	public boolean turn() {
		return turn;
	}
	//gives a tile for the given coordinates
	public Tile giveTile(int x, int y) {
		return board[y][x];
	}
	//checks to see if path is clear
	public boolean isClear(int startX, int startY, int endX, int endY) {
		int largeX;
		int smallX;
		int largeY;
		int smallY;
		Piece p = board[startY][startX].givePiece();
		if(startX>endX) {
			largeX = startX;
			smallX = endX;
		}
		else {
			largeX = endX;
			smallX= startX;
		}
		if(startY>endY) {
			largeY = startY;
			smallY = endY;
		}
		else {
			largeY = endY;
			smallY = startY;
		}
		if(smallX!=largeX && smallY!=largeY) {
			for(int x = smallX; x>largeX; x++) {
				for(int y = smallY; y>largeY; y++) {
					if(p.isVaild(x, y))
						if(board[y][x].givePiece()!=null)
							return false;
				}
			}
		}
		if(smallX==largeX && smallY!=largeY) {
			int x = smallX;
			for(int y = smallY; y>largeY; y++) {
				if(p.isVaild(x, y))
					if(board[y][x].givePiece()!=null)
						return false;
			}
		}
		if(smallY==largeY && smallX!=largeX) {
			int y = smallY;
			for(int x = smallX; x>largeX; x++) {
				if(p.isVaild(x, y))
					if(board[y][x].givePiece()!=null)
						return false;
			}
		}
		return true;
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
		turn = true;
	}
	//allows for a piece to be passed between tiles and returns if move was able to be made
	public boolean play(int startX, int startY, int endX, int endY) {
		Piece curr = board[startY][startX].givePiece();
		if((curr.capture(endX, endY, board[endY][endX])&&isClear(startX,startY,endX,endY))) {
			out.add(board[endY][endX].givePiece());
			board[startY][startX].givePiece().x = endX;
			board[startY][startX].givePiece().y = endY;
			board[endY][endX].addPiece(curr);
			board[startY][startX].addPiece(null);
			return true;
		}
		else if((curr.move(endX, endY))&&isClear(startX,startY,endX,endY)) {
			board[startY][startX].givePiece().x = endX;
			board[startY][startX].givePiece().y = endY;
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
