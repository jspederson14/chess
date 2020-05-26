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
	public void addPiece(Piece p) {
		this.p=p;
	}
}
