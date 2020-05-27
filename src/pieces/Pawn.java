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
			if((this.x==endX && this.y==endY-1)||(endX==6 && this.y==endY-2))
				return true;
		}
		if(this.color.equals("Black")) {
			if((this.x==endX && this.y==endY+1)||(endX==1 && this.y==endY+2))
				return true;
		}
		return false;
	}
}
