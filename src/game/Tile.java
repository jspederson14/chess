package game;
import pieces.*;
public class Tile {
	public int x,y;
	public Piece p;
	public Tile(int y, int x) {
		super();
		this.x=x;
		this.y=y;
		p = null;
	}
	//adds a piece to the tile
	public void addPiece(Piece p) {
		this.p=p;
	}
	//gives x
	public int giveX() {
		return this.x;
	}
	//gives y
	public int giveY() {
		return this.y;
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
