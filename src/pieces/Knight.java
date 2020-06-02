package pieces;

//Knight class which is type Piece
public class Knight extends Piece{
	public Knight(int y, int x, String color) {
		super(y,x,color);
	}
	public String giveType() {
		if(color.equals("White"))
			return "N";
		else if(color.equals("Black"))
			return "n";
		return "error";
	}
	@Override
	public boolean isVaild(int endX, int endY) {
		if((this.x == endX-1)&&((this.y == endY-2)||(this.y == endY+2)))
			return true;
		if((this.x == endX+1)&&((this.y == endY-2)||(this.y == endY+2)))
			return true;
		if((this.x == endX-2)&&((this.y == endY-1)||(this.y == endY+1)))
			return true;
		if((this.x == endX+2)&&((this.y == endY-1)||(this.y == endY+1)))
			return true;
		return false;
	}

}
