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
	//moves piece
	public boolean move(int endX, int endY) {
		if(isVaild(endX,endY)) {
			this.x=endX;
			this.y=endY;
			return true;
		}
		return false;
	}
	//checks to see if move is vaild
	public abstract boolean isVaild(int nx, int ny);
	
	//gives what type of piece it is
	public abstract String giveType();
	
}
