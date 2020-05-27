package game;
import pieces.*;
public class Tile {
	public int x,y;
	public Piece p;
	public Tile(int x, int y) {
		super();
		this.x=x;
		this.y=y;
		p = null;
	}
	//adds a piece to the tile
	public void addPiece(Piece p) {
		this.p=p;
	}
	//gives the piece being manipulated
	public Piece givePiece() {
		return p;
	}
	public void printPiece() {
		if(p==null)
			System.out.print(" * ");
		else
			System.out.print(" "+p.giveType()+" ");
	}
}
