package pieces;

import game.Tile;

//Pawn class which is a type of Piece
public class Pawn extends Piece{
	public Pawn(int y, int x, String color) {
		super(y,x,color);
	}
	public String giveType() {
		if(color.equals("White"))
			return "P";
		else if(color.equals("Black"))
			return "p";
		return "error";
	}
	@Override
	public boolean isVaild(int endX, int endY) {
		if(this.color.equals("White")) {
			if((this.x==endX && this.y-1==endY)||(this.y==6 && this.x==endX && this.y-2==endY))
				return true;
		}
		if(this.color.equals("Black")) {
			if((this.x==endX&& this.y+1==endY)||(this.y==1 && this.x==endX && this.y+2==endY))
				return true;
		}
		return false;
	}
	@Override
	public boolean capture(int endX, int endY, Tile t) {
		if(this.color.equals("White")) {
			if((t.giveX()==endX && t.giveY()==endY)&&(this.x-1==endX && this.y-1==endY)||(this.x+1==endX && this.y-1==endY))
				return true;
			}
			if(this.color.equals("Black")) {
				if((t.giveX()==endX && t.giveY()==endY)&&(this.x+1==endX&& this.y+1==endY)||(this.x-1==endX&& this.y+1==endY))
					return true;
			}
		return false;
	}
}
