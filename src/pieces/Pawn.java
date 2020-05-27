package pieces;

//Pawn class which is a type of Piece
public class Pawn extends Piece{
	public Pawn(int x, int y, String color) {
		super(x,y,color);
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
			if((this.x-1==endX && this.y==endY)||(this.x==6 && this.x-2==endX && this.y==endY))
				return true;
		}
		if(this.color.equals("Black")) {
			if((this.x+1==endX&& this.y==endY)||(this.x==1 && this.x+2==endX && this.y==endY))
				return true;
		}
		return false;
	}
}
