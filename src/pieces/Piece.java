package pieces;
import game.*;

//generic piece class
public abstract class Piece {
	public int x, y;
	public String color;
	
	//defines piece
	public Piece(int y, int x, String color) {
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
	//gives the coordinates of the piece
	public String giveCord() {
		return "X:"+x+" Y:"+y;
	}
	//returns if a capture is can be made
	public boolean capture(int endX, int endY, Tile t) {
		if(isVaild(endX,endY))
			if(t.giveX()==endX && t.giveY()==endY)
				return true;
		return false;
	}
	//checks to see if move is vaild
	public abstract boolean isVaild(int endX, int endY);
	
	//gives what type of piece it is
	public abstract String giveType();
	
}
