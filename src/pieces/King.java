package pieces;

//King which is a type of Piece
public class King extends Piece{
	public King(int y, int x, String color) {
		super(y,x,color);
	}
	public String giveType() {
		if(color.equals("White"))
			return "K";
		else if(color.equals("Black"))
			return "k";
		return "error";
	}
	@Override
	public boolean isVaild(int x, int y) {
		return true;
	}

}
