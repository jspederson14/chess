package pieces;

//Rook class which is type piece
public class Rook extends Piece{
	public Rook(int y, int x, String color) {
		super(y,x,color);
	}
	public String giveType() {
		if(color.equals("White"))
			return "R";
		else if(color.equals("Black"))
			return "r";
		return "error";
	}
	@Override
	public boolean isVaild(int endX, int endY) {
		if((this.x == endX)||(this.y==endY))
			return true;
		return false;
	}
}
