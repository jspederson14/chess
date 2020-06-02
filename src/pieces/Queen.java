package pieces;

//Queen which is a type of Piece
public class Queen extends Piece{
	public Queen(int y, int x, String color) {
		super(y,x,color);
	}
	public String giveType() {
		if(color.equals("White"))
			return "Q";
		else if(color.equals("Black"))
			return "q";
		return "error";
	}
	@Override
	public boolean isVaild(int endX, int endY) {
		if((this.x-endX) == (this.y-endY)||(this.x == endX)||(this.y==endY))
			return true;
		return false;
	}
}
