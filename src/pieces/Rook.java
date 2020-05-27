package pieces;

//Rook class which is type piece
public class Rook extends Piece{
	public Rook(int x, int y, String color) {
		super(x,y,color);
	}
	public String giveType() {
		if(color.equals("White"))
			return "R";
		else if(color.equals("Black"))
			return "r";
		return "error";
	}
	@Override
	public boolean isVaild(int x, int y) {
		return true;
	}
}
