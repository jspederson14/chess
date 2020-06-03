package pieces;

//Bishop class with is a type Piece
public class Bishop extends Piece{
	public Bishop(int y, int x, String color) {
		super(y,x,color);
	}
	public String giveType() {
		if(color.equals("White"))
			return "B";
		else if(color.equals("Black"))
			return "b";
		return "error";
	}
	@Override
	public boolean isVaild(int endX, int endY) {
		if((this.x-endX) == (this.y-endY)||(this.x-endX)==(endY-this.y)||(this.y-endY)==(endX-this.x))
			return true;
		return false;
	}

}
