package pieces;
import game.*;

//generic piece class
public abstract class Piece {
	public int x, y;
	public String color;
	
	//defines piece
	public Piece(int x, int y, String color) {
		this.x=x;
		this.y=y;
		this.color=color;
	}
	//checks to see if move is vaild
	public abstract boolean isVaild(int nx, int ny);
	
	
}
